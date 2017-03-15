#  **Sample Example  in Java invoking GCP Endpoint using Service Account.**

This example show: How invoke Google Cloud Endpoint from another application using [Service Account](https://developers.google.com/identity/protocols/OAuth2ServiceAccount)

Sometime you need create a integration server-to-server between application onprimisse and application on [Google App Engine](https://cloud.google.com/appengine/) and you want to restrict the access for. 

One nice and simple solutions is restric the access using Service Account.

To do that you need follow some steps. (To be more didatic I will split the steps between server **App Engine Apps** and client) 

### Steps of server side:

- Create a **web client** in GCP Console

- Create a **Service Account** in GCP Console

- Change the **authentical level to REQUIRED** in your GoogleCloundEndpoint Class

- Include the **clients id** in your GoogleCloundEndpoint Class

### Steps of client side:

- Get your JSON file of service Account in your GCP Project

- Generate your Accesss Token using your Service Account

- Enjoy !!!!

## Deep Dive into Server Side

### Create a **web client** in GCP Console

#In PROGRESS