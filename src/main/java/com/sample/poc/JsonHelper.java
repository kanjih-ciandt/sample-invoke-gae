package com.sample.poc;

import com.sample.to.ResultTest;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class JsonHelper {

  final static Logger logger = LoggerFactory.getLogger(JsonHelper.class);

 /**
  * 
  * @param json
  * @return
  */
  public static ResultTest extractElements(String json) throws JSONException{   
      JSONObject root = new JSONObject(json);
      
      return new ResultTest(root.getString("id"), root.getDouble("amount"), root.getDouble("confidenceLevel"), root.getString("kind"), root.getString("etag"));

     }

  /**
   * Convert the {@link InputStream} into a String which contains the
   * whole JSON response from the server.
   */
  public static String readFromStream(InputStream inputStream) throws IOException {
    StringBuilder output = new StringBuilder();
    if (inputStream != null) {
      InputStreamReader inputStreamReader =
          new InputStreamReader(inputStream, Charset.forName("UTF-8"));
      BufferedReader reader = new BufferedReader(inputStreamReader);
      String line = reader.readLine();
      while (line != null) {
        output.append(line);
        line = reader.readLine();
      }
    }
    return output.toString();
  }

}
