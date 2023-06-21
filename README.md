# CallingThird-Api
How to call third api from another project

/*

* Constructs the URL: The variable url is created by concatenating the base URL "http://localhost:8080/college/" with the collegeId value.

* Creates the URI: The URI object uri is created using the URI.create() method, passing the url as the argument.

* Builds the HTTP request: The HttpRequest object request is built using the HttpRequest.newBuilder().uri(uri).build() method chain. 
  It sets the URI of the request to the previously created uri.

* Sends the HTTP request and retrieves the response: The client.send(request, HttpResponse.BodyHandlers.ofString()) method is called 
  to send the HTTP request and retrieve the response. The response is captured in the HttpResponse object responseClient. 
  The HttpResponse.BodyHandlers.ofString() method is used to indicate that the response body should be returned as a String.

* Creates an ObjectMapper instance: The ObjectMapper object mapper is created. 
  The ObjectMapper class is from the Jackson library and is used for JSON serialization and deserialization.

* Deserializes the response body to a College object: The responseClient.body() method is called to retrieve the response body as a String. 
  The mapper.readValue(c1, College.class) method is used to deserialize the JSON string into a College object.

* Sets the College object in the response: The College object is set into the response object using response.setCollege(college).

  Overall, this code sends an HTTP request to retrieve a JSON response from the specified URL, 
  deserializes the response body into a College object using ObjectMapper, and sets the College object into the response object.

*/
