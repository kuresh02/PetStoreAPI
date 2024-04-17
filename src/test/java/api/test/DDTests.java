package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import api.utility.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	@Test(priority=1,dataProvider="Data",dataProviderClass= DataProviders.class)
	public void testPostuser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph)
	
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		
		Response response = UserEndPoint.createUser(userPayload);
				
		Assert.assertEquals(response.statusCode(),200);
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass= DataProviders.class)
	public void testDeleteuserByName(String userName)
	{
		Response response = UserEndPoint.deleteUser(userName);
		Assert.assertEquals(response.statusCode(),200);
	}
}
