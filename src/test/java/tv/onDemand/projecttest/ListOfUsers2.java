package tv.onDemand.projecttest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.response.Response;
import tv.onDemand.genericUtility.Auth;
import tv.onDemand.genericUtility.IConstants;
import tv.onDemand.genericUtility.IEndPoints;

/**
 * 
 * @author c-sohans
 *This testScript collects all the user name from the Users List
 */
public class ListOfUsers2 {
	@Test(groups = {"regressionTest"})
	public void listOfUsers() {
		Response resp = given()
		.headers("Authorization", Auth.generateToken())
		.when()
				.get(IConstants.devBaseURI+IEndPoints.users);
		resp.then()
		.assertThat().statusCode(200);
		 List<Object> username = resp.jsonPath().getJsonObject("Users.Username");
		 int n = username.size();
		 System.out.println("Number of Users is = "+n);
		 for(Object un: username) {
			 System.out.println(un);
		 }
		
	}
}
