package day3.restassuedexamples;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiOps_May {

	@Test
	public void testUserCreation() {
		String payload="{\"name\": \"morpheus\", \"job\": \"leader\"}";
		//base URL
		RestAssured.baseURI="https://reqres.in/";
		//Given
		RequestSpecification request=RestAssured.given().header("Content-Type","application/json")
						   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON).body(payload);
		//Action
		Response res=request.post("api/users");
		//Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String responseBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+responseBody);
		res.then().statusCode(200);		  
	}
	
	@Test
	public void testUserCreationWithJsonObject() {
		//String payload="{\"name\": \"morpheus\", \"job\": \"leader\"}";
		
		JSONObject obj=new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "leader");
		//base URL
		RestAssured.baseURI="https://reqres.in/";
		//Given & When
		Response res=RestAssured.given().header("Content-Type","application/json")
						   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON).body(obj.toJSONString()).post("api/users");
		//Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String responseBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+responseBody);
		res.then().statusCode(201);		  
	}
	
	@Test
	public void testUserCreationWithPOJOClass() {
		//String payload="{\"name\": \"morpheus\", \"job\": \"leader\"}";
		
//		JSONObject obj=new JSONObject();
//		obj.put("name", "morpheus");
//		obj.put("job", "leader");
		
		UserDetails getData=new UserDetails("morpheus","leader");
		JSONObject obj=new JSONObject();
		obj.put("name", getData.getName());
		obj.put("job", getData.getJob());
		//base URL
		RestAssured.baseURI="https://reqres.in/";
		//Given & When
		Response res=RestAssured.given().header("Content-Type","application/json")
						   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON).body(obj.toJSONString()).post("api/users");
		//Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String responseBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+responseBody);
		res.then().statusCode(201);		  
	}
	
	@Test
	public void testUserCreationWithJSONFile() {
		//TODO:
	}
}
