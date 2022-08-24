package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;

import api.payload.StorePojo;

import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	StorePojo storePayload;
	
	public Logger logger;
	
	@BeforeClass
	public void SetupData()
	{
		faker=new Faker();
		storePayload=new StorePojo();
		
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(6);
		storePayload.setShipDate("2022-08-23");
		storePayload.setStatus("placed");
		
		
		//logs
		logger= LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostStore()
	{
		logger.info("********** Creating user  ***************");

		Response response=StoreEndPoints.createorderId(storePayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User is created  ***************");

	}
	
	@Test(priority=2)
	public void testGetId()
	{
		logger.info("********** Reading User Info ***************");

		Response response=StoreEndPoints.getorderId(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User info  is displayed ***************");
		
	}
	
	
	@Test(priority=3)
	public void testDeleteId()
	{
		logger.info("**********   Deleting User  ***************");
		
		Response response=StoreEndPoints.deleteorderId(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User deleted ***************");
	}

	

}
