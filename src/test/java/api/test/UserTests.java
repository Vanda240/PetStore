package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPojo;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	UserPojo userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void SetupData()
	{
		faker=new Faker();
		userPayload=new UserPojo();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("********** Creating user  ***************");

		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User is created  ***************");

	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		logger.info("********** Reading User Info ***************");

		Response response=UserEndPoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User info  is displayed ***************");
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("********** Updating User ***************");
		//Update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body().statusCode(200); //chai assertion
		
		//Assert.assertEquals(response.getStatusCode(), 200); //testng assertion
		
		logger.info("********** User updated ***************");
		//Checking data after update
		Response responseafterupdate=UserEndPoints.getUser(this.userPayload.getUsername());
		
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUserBYName()
	{
		logger.info("**********   Deleting User  ***************");
		
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User deleted ***************");
	}

	

}
