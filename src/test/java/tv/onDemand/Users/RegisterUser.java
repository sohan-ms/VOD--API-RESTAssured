package tv.onDemand.Users;

import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tv.onDemand.genericUtility.API_BaseClass;
import tv.onDemand.genericUtility.Auth;
import tv.onDemand.pojoUtility.UserDetails;

import java.util.Random;

/**
 * 
 * @author c-sohans
 *This testScripts validates the ADD USER functionality
 */

public class RegisterUser extends API_BaseClass{
	@Test
	public void registerUser(String location, String email, String roleID, String status, String phno, String custID, String custIDString) {
		Random no = new Random();
		char ch = (char) (no.nextInt(26) + 'a');
		UserDetails User = new UserDetails(ch+ch+"_sohan@amagi.com", "sohanms", "india", "7", "active", "9980447871", "371", "371");
		Response resp = given()
		.headers("Authorization", Auth.generateToken())
		.contentType(ContentType.JSON)
		.body(User)
		.when()
		.post("http://3.90.29.174:31100/users/user");
		
		resp.then()
		.extract().response().asString();
		String respBody = resp.jsonPath().get("description");
		Assert.assertEquals(respBody, "Added user (sohanms)");
	}
}
