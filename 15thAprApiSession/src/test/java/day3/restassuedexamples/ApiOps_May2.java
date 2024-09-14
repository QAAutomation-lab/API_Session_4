package day3.restassuedexamples;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiOps_May2 {

	@Test
	public void testUserDetails() {
		
		//base URL
		RestAssured.baseURI="https://reqres.in/";
		//Given
		RequestSpecification request=RestAssured.given().header("Content-Type","application/json")
						   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON);
		//Action
		Response res=request.get("api/users?page=2");
		//Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String responseBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+responseBody);
		res.then().statusCode(200);		
			//or
		//Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testUpdateUser() {
		String payload="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		//base URL
		RestAssured.baseURI="https://reqres.in/";
		//Given
		RequestSpecification request=RestAssured.given().header("Content-Type","application/json")
						   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON).body(payload);
		//Action
		Response res=request.put("api/users/2");
		//Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String responseBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+responseBody);
		res.then().statusCode(200);		
			//or
		//Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testDeleteUser() {

		//base URL
		RestAssured.baseURI="https://reqres.in/";
		//Given
		RequestSpecification request=RestAssured.given().header("Content-Type","application/json")
						   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON);
		//Action
		Response res=request.delete("api/users/2");
		//Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String responseBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+responseBody);
		res.then().statusCode(204);		
			//or
		//Assert.assertEquals(statusCode, 204);
	}
	

}
