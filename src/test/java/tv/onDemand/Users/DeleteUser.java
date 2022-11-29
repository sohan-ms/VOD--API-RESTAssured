package tv.onDemand.Users;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import tv.onDemand.genericUtility.Auth;
import tv.onDemand.genericUtility.IConstants;
import tv.onDemand.genericUtility.IEndPoints;

public class DeleteUser {
	@Test(groups = {"regression"})
	private void deleteUser() {

		Response resp =
				given().headers("Authorization", Auth.generateToken())

				.when().get(IConstants.devaBaseURI+IEndPoints.users);
		
		resp.then().statusCode(200);

		List<String> uniqueUserName = resp.jsonPath().getList("Users.Username");
		for (int j = 0; j < uniqueUserName.size(); j++) {
			String user = resp.jsonPath().get("Users["+j+"].Attributes[5].Value");
			if(user.equalsIgnoreCase("sohanms")) {
				String userID = resp.jsonPath().get("Users["+j+"].Attributes[0].Value");
				System.out.println(userID);
				given().headers("Authorization", Auth.generateToken())
				
				.when()
				.delete(IConstants.devaBaseURI+IEndPoints.registerUser+"/"+userID)
				
				.then().assertThat().statusCode(200)
				.log().all();
				break;
			}
		}
	}
}
