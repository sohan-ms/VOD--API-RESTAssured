package tv.ondemand.projecttest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


import io.restassured.response.Response;
import tv.ondemand.genericUtility.Auth;
import tv.ondemand.genericUtility.IConstants;
import tv.ondemand.genericUtility.IEndPoints;

/**
 * 
 * @author c-sohans
 *This is for practice
 */
public class Test12 {
	@Test(groups = {"skip"})
	public void testmethods() {

		Response resp1 =
				given().headers("Authorization", Auth.generateToken())

				.when().get(IConstants.devBaseURI+IEndPoints.users);
		//Validation
		resp1.then().statusCode(200);

		//	get the username provided with the user
		List<String> userNo = resp1.jsonPath().getList("Users.Username");
//		List<String> name=new ArrayList<String>();
//		for(int i = 0; i<=userNo.size(); i++) {
//			//			usernames return the only name
//			String usernames = resp1.jsonPath().get("Users["+i+"].Attributes[5].Value");
//			name.add(usernames);
//		}
		//	us returns the full username
		for (int j = 0; j < userNo.size(); j++) {
			String us = resp1.jsonPath().get("Users["+j+"].Attributes[5].Value");
			if(us.equalsIgnoreCase("amaginow")) {
				String userID = resp1.jsonPath().get("Users["+j+"].Attributes[0].Value");
				System.out.println(userID);
				break;
			}
		}

	}
}
