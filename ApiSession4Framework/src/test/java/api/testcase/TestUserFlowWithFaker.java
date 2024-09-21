package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class TestUserFlowWithFaker {
	
	Faker faker;
	UserPOJO getUserPayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		getUserPayload=new UserPOJO();
		getUserPayload.setId(faker.idNumber().hashCode());
		getUserPayload.setUsername(faker.name().username());
		getUserPayload.setFirstname(faker.name().firstName());
		getUserPayload.setLastame(faker.name().lastName());
		getUserPayload.setEmail(faker.internet().safeEmailAddress());
		getUserPayload.setPassword(faker.internet().password(5, 10));
		getUserPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void testUserCreation() {
		Response res=UserEndPoints.createUser(getUserPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testToGetCreatedUser() {
		Response res=UserEndPoints.getUser(getUserPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		//data to update
		getUserPayload.setFirstname(faker.name().firstName());
		getUserPayload.setLastame(faker.name().lastName());
		getUserPayload.setEmail(faker.internet().safeEmailAddress());
		//trying to update user details
		Response res=UserEndPoints.updateUser(getUserPayload.getUsername(), getUserPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		//check whether user is updated or not
		Response afterUpdate=UserEndPoints.getUser(getUserPayload.getUsername());
		Assert.assertEquals(afterUpdate.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeleteUser() {
		Response res=UserEndPoints.deleteUser(getUserPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
