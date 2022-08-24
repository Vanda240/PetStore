package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.StorePojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	public static Response createorderId(StorePojo payload)
	{
		Response response= given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		   .post(Routes.poststore_url);
		
		return response;
	}
	
	public static Response getorderId(int Id)
	{
		Response response= given()
		   .pathParam("orderId", Id)
		   
		.when()
		   .get(Routes.getstore_url);
		   
		 return response;  
	}
	
	
	public static Response deleteorderId(int Id)
	{
		Response response= given()
		   .pathParam("orderId", Id)
		   
		.when()
		   .delete(Routes.deletestore_url);
		   
		 return response;  
	}

}
