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

public class ApiOperations {

	@Test
	public void createUser() {
		String payload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		//first form the base URL
		RestAssured.baseURI = "https://reqres.in/";
		
		Response res = RestAssured.given()
					   .header("Content-Type", "application/json")
					   .contentType(ContentType.JSON)
					   .accept(ContentType.JSON)
					   .body(payload)
					   .post("api/users");

		String statusLine = res.getStatusLine();
		System.out.println("Status Line: " + statusLine);
		int statusCode = res.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = res.getBody().asString();
		System.out.println("responseBody: " + responseBody);
		//validation
		res.then().statusCode(201);
	}
	
	@Test
	public void createUser2() {
		//String payload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

		JSONObject jObject=new JSONObject();
		jObject.put("name", "morpheus");
		jObject.put("job", "leader");
		System.out.println("JSON Object: "+jObject.toJSONString());
				
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
					.header("Content-Type","application/json")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(jObject.toJSONString())
					.post("api/users");
		
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
		
		//Validation
		//res.then().statusCode(201);
		Assert.assertEquals(statusCode, 201);
	}
	@Test
	public void testCaseForPost3() {

		byte[] data = null;
		try {
			data=Files.readAllBytes(Paths.get(".\\src\\test\\resources\\data\\UserDetails.json"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String payLoad=new String(data);
		
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
					.header("Content-Type","application/json")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payLoad)
					.post("api/users");
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
		
		//Validation
		//res.then().statusCode(201);
		Assert.assertEquals(statusCode, 201);
	}

	@Test
	public void getUserList() {
		// form base URL
		RestAssured.baseURI = "https://reqres.in/";
		// Given conditions
		RequestSpecification req = RestAssured.given()
								   .header("Content-Type", "application/json")
								   .contentType(ContentType.JSON)
								   .accept(ContentType.JSON);
		// Action - GET/POST/PUT/DELETE
		Response res = req.get("/api/users?page=2");

		// Validations
		String statusLine = res.getStatusLine();
		System.out.println("Status Line: \n\t\t" + statusLine);
		int statusCode = res.getStatusCode();
		System.out.println("Status code: \n\t\t" + statusCode);
		String responseBody = res.getBody().asString();
		System.out.println("responseBody: \n\t\t" + responseBody);
		
		//validation
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void updateUser() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Shailesh");
		obj.put("job", "Team Lead");
		String payLoad=obj.toJSONString();
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response res=RestAssured.given()
					.header("Content-Type","application/json")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payLoad)
					.put("api/users/2");
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
		
		//Validation
		//res.then().statusCode(200);
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void deleteOps() {
		RestAssured.baseURI="https://reqres.in/";
		
		Response res=RestAssured.given()
					.header("Content-Type","application/json")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.delete("api/users/2");
		
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		//Validation
		//res.then().statusCode(204);
		Assert.assertEquals(statusCode, 204);
	}
}
/*
Practice remaining API GET & POST & Delete

user: https://petstore.swagger.io/#/

*/