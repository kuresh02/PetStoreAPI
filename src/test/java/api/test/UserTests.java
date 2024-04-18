package api.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	Logger logger;
	
	@BeforeClass
	public void setupData() {
		faker= new Faker();
		userPayload =new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser() {
		logger.info("****************Creating User Info*******************");
		Response response=UserEndPoint.createUser(userPayload);
		response.then().log().all();
		System.out.println(this.userPayload.getUsername()+"=======");
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****************User is Created*******************");
	}
	
	@Test(priority=2)
	public void testgetUser() {
		logger.info("****************Reading User Info*******************");
		Response response=UserEndPoint.getUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****************Reading User Info display*******************");
	}
	
	@Test(priority=3)
	public void testupdateUserByName() {
		logger.info("****************Updating User Info *******************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoint.putUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Checking data after update
		Response responseAfterUpdate = UserEndPoint.getUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		logger.info("****************User Info updated*******************");
	}
	
	@Test(priority=4)
	public void testdeleteUserByName() {
		logger.info("**************** deleteing User*******************");
		Response response=UserEndPoint.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****************User Deleted*******************");
	}
	
	
}