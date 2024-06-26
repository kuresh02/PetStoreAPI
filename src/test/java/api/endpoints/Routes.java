package api.endpoints;

/* 

Create user(Post) : https://petstore.swagger.io/v2/user
Get user(Get) : https://petstore.swagger.io/v2/user/{username}
Update user(Put) : https://petstore.swagger.io/v2/user/{username}
Delete user(Delete) : https://petstore.swagger.io/v2/user/{username}
for github- from local to remote--https://www.youtube.com/watch?v=B2N1AKIQfnY&t=325s

*/
public class Routes {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = post_url+"/{username}";
	public static String put_url = post_url+"/{username}";
	public static String delete_url = post_url+"/{username}";
	
}