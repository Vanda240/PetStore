package api.endpoints;

/* 
Swagger URI --> https://petstore.swagger.io/v2

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/


public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module
	
	public static String poststore_url = base_url+"/store/order";
	public static String getstore_url = base_url+"/store/order/{orderId}";
	public static String deletestore_url =base_url+"/store/order/{orderId}";
	
	//Pet Module
	
	public static String postpet_url = base_url+"/pet";
	public static String getpet_url = base_url+"/pet/{petId}";
	public static String updatepet_url = base_url+"/pet/{petId}";
	public static String deletepet_url = base_url+"/pet/{petId}";
}
