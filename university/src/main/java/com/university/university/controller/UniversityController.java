
package com.university.university.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.university.Entity.College;
import com.university.university.Entity.StudentEntity;
import com.university.university.Response.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class UniversityController {

	@Autowired
	WebClient.Builder webClient;
	
	@GetMapping("/{studentId}")
	public ResponseEntity<ResponseData> getStudentDetails(@PathVariable("studentId") Long studentId) {

		ResponseData response = new ResponseData();
		StudentEntity s = new StudentEntity();

		s.setStudentId(1l);
		s.setStudentName("A");
		s.setAddress("Delhi");
		s.setCollegeId(1l);

		response.setStudent(s);

		Long collegeId = s.getCollegeId();
		  
//		  RestTemplate restTemplate = new RestTemplate(); 
//		  String url ="http://localhost:8080/college/{collegeId}"; 
//		  ResponseEntity<College> data =restTemplate.getForEntity(url, College.class, collegeId);
//		 		  
//		  if(data.getStatusCodeValue()==200) { 
//			  College c = data.getBody();
//		  
//		  response.setCollege(c); 
//		  }
		 		 
//		  College c = webClient.build().get().uri("http://localhost:8080/college/" + collegeId).retrieve().bodyToMono(College.class).block();		 	  
//		  response.setCollege(c);
		  
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> responseClient = null;

		try {
			String url = "http://localhost:8080/college/" + collegeId;
			URI uri = URI.create(url);
			HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
			responseClient = client.send(request, HttpResponse.BodyHandlers.ofString());

			ObjectMapper mapper = new ObjectMapper();

			String c1 = responseClient.body();
		//  response.setCollege(mapper.readValue(c1, College.class));
			College college = mapper.readValue(c1	, College.class);

			response.setCollege(college);
		} catch (Exception e) {
			log.error("Please provide valid URL");
		}
		return new ResponseEntity<ResponseData>(response, HttpStatus.OK);
	}
}


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
