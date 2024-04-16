package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoint  
//Created for the perform Create,Read, Update, Delete requests the user API
public class UserEndPoint {
	public static Response createUser(User payload) {

		Response response = given()
				 .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(String userName) {

		Response response = given()
				.pathParam("username",userName)
			.when()
				.get(Routes.get_url);
		
		return response;
	}
	public static Response putUser(String userName, User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				
			.when()
				.put(Routes.put_url);
		
		return response;
	}
	public static Response deleteUser(String userName) {

		Response response = given()
				.pathParam("username",userName)
			.when()
				.delete(Routes.delete_url);
		
		return response;
	}
}