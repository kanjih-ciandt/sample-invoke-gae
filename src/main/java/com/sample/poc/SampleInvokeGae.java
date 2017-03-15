package com.sample.poc;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import com.sample.to.ResultTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

/**
 * A sample example with how invoke a Google Cloud Endpoint that you need be authenticate.
 * Using just service Account
 * 
 * @author kanjih
 *
 */
public class SampleInvokeGae {

  private String URL = "https://<GAE_PROJECT>/_ah/api/<YOUR API>";
  final static Logger logger = LoggerFactory.getLogger(SampleInvokeGae.class);

  
  
  /**
   * Make an HTTP request to the given URL and return a String as the response
   * @param url of your endpoint
   * @return json response of your endpoint
   * @throws IOException
   */
  private  String makeHttpRequest(URL url) throws IOException {
    String jsonResponse = "";
    
    if (url == null) {
      return jsonResponse;
    }

    HttpURLConnection urlConnection = null;
    InputStream inputStream = null;
    try {
      urlConnection =  (HttpURLConnection) url.openConnection();
      urlConnection.setDoOutput(true);
      urlConnection.setRequestMethod("POST");
      urlConnection.setRequestProperty( "Content-Type", "application/json");
      
      String token = generateAccessToken();
      
      System.out.println("Bearer " + token);
      
      urlConnection.setRequestProperty( "Authorization", "Bearer " + token);  
      OutputStream os = urlConnection.getOutputStream();
      
      String input = "{\"id\": \"test-kanjih-img1\"}";
      os.write(input.getBytes());
      os.flush();
      
      if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        inputStream = urlConnection.getInputStream();
        jsonResponse = JsonHelper.readFromStream(inputStream);
       
      } else {
        throw new RuntimeException("Failed : HTTP error code : "
            + urlConnection.getResponseCode() + " - msg - " + urlConnection.getResponseMessage());
      }
     
    } catch (IOException e) {
      logger.error("Problem retrieving the JSON results.", e);
    } finally {
      if (urlConnection != null) {
        urlConnection.disconnect();
      }
      if (inputStream != null) {
        inputStream.close();
      }
    }
    return jsonResponse;
  }
  
  /**
   * GENERATE ACCESS TOKEN FOR YOUR SERVICE ACCOUNT
   * @return Access Token
   * @throws IOException
   */
  private String generateAccessToken() throws IOException{
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream resourceAsStream = new FileInputStream(classLoader.getResource("service_acccount_external.json").getFile());
    GoogleCredential credential = GoogleCredential.fromStream(resourceAsStream);
    
    if (credential.createScopedRequired()) {
        credential = credential.createScoped(Collections.singletonList("https://www.googleapis.com/auth/userinfo.email"));
    }
    credential.refreshToken();
    return credential.getAccessToken();
  }


  /**
   * execute 
   */
  private void execute() {
    String jsonResponse = null;
    try {

      URL url = new URL(URL);

      jsonResponse = makeHttpRequest(url);
    } catch (IOException e) {
      logger.error("Error closing input stream", e);
    }

    ResultTest resultTest = JsonHelper.extractElements(jsonResponse);   
    System.out.println(resultTest.toString()); 
  }   
 
 
  /**
   * Just invoke execute
   * @param args
   */
  public static void main(String[] args) {
    new SampleInvokeGae().execute();

  }

}
