package tv.onDemand.Users;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tv.onDemand.genericUtility.API_BaseClass;
import tv.onDemand.genericUtility.Auth;
import tv.onDemand.genericUtility.IConstants;
import tv.onDemand.genericUtility.IEndPoints;

/**
 * 
 * @author c-sohans
 * This test script extracts the USERNAME unique id and get all the details of the user
 */
public class GetSpecifiedUserDetails extends API_BaseClass{
	String userName = "Tester";
	@Test(groups = {"regression"})
	private void getUserDetaild() {

		Response resp =
				given().headers("Authorization", Auth.generateToken())

				.when().get(IEndPoints.users);
		
		//Validation
		resp.then().statusCode(200);

		//	get the user ID provided with the user
		List<String> uniqueUserName = resp.jsonPath().getList("Users.Username");
		//	us returns the full username
		for (int j = 0; j < uniqueUserName.size(); j++) {
			String user = resp.jsonPath().get("Users["+j+"].Attributes[5].Value");
//		provide the user name value
			if(user.equalsIgnoreCase(userName)) {
				String userID = resp.jsonPath().get("Users["+j+"].Attributes[0].Value");
				System.out.println(userID);
				given().headers("Authorization", Auth.generateToken())
				
				.when()
				.get(IEndPoints.getSpecifiedUserDetails+userID)
				
				.then().assertThat().statusCode(200)
				.contentType(ContentType.JSON)
				.log().all();
				break;
			}
		}
	}
}
