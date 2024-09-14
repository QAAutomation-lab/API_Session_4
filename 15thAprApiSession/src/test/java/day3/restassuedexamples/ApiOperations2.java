package day3.restassuedexamples;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiOperations2 {

	@Test
	public void createUser() {
		String payload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		//first form the base URL
		RestAssured.baseURI = "https://reqres.in/";
		//Given
		RequestSpecification req  = RestAssured.given()
					   .header("Content-Type", "application/json")
					   .contentType(ContentType.JSON)
					   .accept(ContentType.JSON)
					   .body(payload);
		//when
		Response res=req.post("api/users");
		
		//From response object you can validate anything that is coming as response
		String statusLine = res.getStatusLine();
		System.out.println("Status Line: " + statusLine);
		int statusCode = res.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = res.getBody().asString();
		System.out.println("responseBody: " + responseBody);
		
		//then
		res.then().statusCode(201);
			//or
		//Assert.assertEquals(201, statusCode);
	}
}
/*
Practice remaining API GET & POST

*/