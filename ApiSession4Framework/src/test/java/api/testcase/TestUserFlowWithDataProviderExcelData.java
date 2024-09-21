package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPOJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class TestUserFlowWithDataProviderExcelData {
	
	UserPOJO getUserPayload;

	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testUserCreation(String userID,String userName, String fname, String lname,String useremail,String pwd,String phone) {
		getUserPayload=new UserPOJO();
		getUserPayload.setId(Integer.parseInt(userID));
		getUserPayload.setUsername(userName);
		getUserPayload.setFirstname(fname);
		getUserPayload.setLastame(lname);
		getUserPayload.setEmail(useremail);
		getUserPayload.setPassword(pwd);
		getUserPayload.setPhone(phone);
		
		Response res=UserEndPoints.createUser(getUserPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) {
		Response res=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
