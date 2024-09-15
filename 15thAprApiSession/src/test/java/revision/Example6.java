package revision;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example6 {
  @Test
  public void testUserCreation() {
	  
	  String payload="[\n"
	  		+ "  {\n"
	  		+ "    \"id\": 101,\n"
	  		+ "    \"username\": \"Login404\",\n"
	  		+ "    \"firstName\": \"Tester\",\n"
	  		+ "    \"lastName\": \"QA\",\n"
	  		+ "    \"email\": \"qa@gmail.com\",\n"
	  		+ "    \"password\": \"abc12345\",\n"
	  		+ "    \"phone\": \"987654152\",\n"
	  		+ "    \"userStatus\": 0\n"
	  		+ "  }\n"
	  		+ "]";
	  
	  //BaseURL
	  RestAssured.baseURI="https://petstore.swagger.io/";
	  //Given
	 RequestSpecification request= RestAssured.given().header("Content-Type","application/json")
	  					 .contentType(ContentType.JSON)
	  					 .accept(ContentType.JSON)
	  					 .body(payload);
	 //when 
	 Response res=request.post("v2/user/createWithList");
	 //then
	 String statusLine=res.getStatusLine();
	 int statusCode= res.getStatusCode();
	 String body=res.getBody().asString();
	 System.out.println("Status Line: "+statusLine);
	 System.out.println("Status Code: "+statusCode);
	 System.out.println("Response Body: "+body);
	 
	 res.then().statusCode(201);
  }
  
  @Test
  public void testCreatedUser() {
	  //BaseURL
	  RestAssured.baseURI="https://petstore.swagger.io/";
	  //Given
	  RequestSpecification request= RestAssured.given().header("Content-Type","application/json")
		  					 .contentType(ContentType.JSON)
		  					 .accept(ContentType.JSON);
	//when 
	  Response res=request.get("v2/user/Login404");
	//then
		 String statusLine=res.getStatusLine();
		 int statusCode= res.getStatusCode();
		 String body=res.getBody().asString();
		 System.out.println("Status Line: "+statusLine);
		 System.out.println("Status Code: "+statusCode);
		 System.out.println("Response Body: "+body);
		 
		 res.then().statusCode(200);
  }
}
