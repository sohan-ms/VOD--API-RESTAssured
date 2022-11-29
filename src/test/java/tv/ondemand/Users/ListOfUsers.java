package tv.ondemand.Users;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import tv.ondemand.genericUtility.API_BaseClass;
import tv.ondemand.genericUtility.Auth;
import tv.ondemand.genericUtility.IEndPoints;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author c-sohans
 *This test scripts collects all the user name from the users list
 */
public class ListOfUsers extends API_BaseClass{
	@Test(groups = {"smoke", "regression"})
	public void listOfUsers() {
		Response resp =
		given()
		.headers("Authorization", Auth.generateToken()).log().all()
	.when()
		.get(IEndPoints.users);
	//Validation
	resp.then()
	.log().all();
	List<String> userNo = resp.jsonPath().getList("Users.Username");
	 List<String> name=new ArrayList<String>(); 
	 System.out.println(userNo.size());
	for(int i = 0; i<=userNo.size(); i++) {
		 String usernames = resp.jsonPath().get("Users["+i+"].Attributes[5].Value");
		 	if (usernames == null) {
		 		String username2 = resp.jsonPath().get("Users["+i+"].Attributes[3].Value");
		 		System.out.println("Google User --> "+username2);
		 	}
		 	else {
		 		name.add(usernames);
			}
				
	}
		for(String asd : name) {
		System.out.println("Cognito User --> "+asd);
		}
	}
}
