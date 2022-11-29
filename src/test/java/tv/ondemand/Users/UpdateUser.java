package tv.ondemand.Users;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tv.ondemand.genericUtility.Auth;
import tv.ondemand.genericUtility.IConstants;
import tv.ondemand.genericUtility.IEndPoints;
import tv.ondemand.pojoUtility.UserDetails;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.*;


public class UpdateUser{
	@Test
	public void updateUser() {
		String name = "sohanms";
		UserDetails user = new UserDetails("sohan@amagi.com", name, "india", "7", "inactive", "9980447871", "371", "371");
		Response resp = given()
		.headers("Authorization", Auth.generateToken())
		.contentType(ContentType.JSON)
		.body(user)
		.when()
		.patch(IConstants.devaBaseURI+IEndPoints.registerUser+"/77a8b954-033c-4b36-803a-b80a4a47b2d2");
		resp.then().assertThat().statusCode(200)
		.extract().response().asString();
		String respBody = resp.jsonPath().get("description");
		Assert.assertNotSame(respBody, "Updated user ("+name+")");
	}
}
