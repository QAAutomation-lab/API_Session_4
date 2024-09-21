package api.endpoints;

import api.payload.UserPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	//create new user with POST method
	public static Response createUser(UserPOJO payload) {
		Response res=RestAssured.given().contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(payload)
		.when().post(BaseURLs.POST_URL);
		return res;
	}
	
	//get user details using GET method
	public static Response getUser(String username) {
		Response res=RestAssured.given()
				.pathParam("username", username)
				.when().get(BaseURLs.GET_URL);
		return res;
	}
	
	//update user details using PUT method
	public static Response updateUser(String username,UserPOJO payload) {
		Response res=RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when().put(BaseURLs.UPDATE_URL);
				return res;
	}
	
	//delete user using DELETE method
	public static Response deleteUser(String username) {
		Response res=RestAssured.given().pathParam("username", username)
				.when().delete(BaseURLs.DELETE_URL);
		return res;
	}
}
