package tv.ondemand.projecttest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import tv.ondemand.genericUtility.Auth;
import tv.ondemand.genericUtility.IConstants;
import tv.ondemand.genericUtility.IEndPoints;

import static io.restassured.RestAssured.*;

public class CustomerConfig{
	@Test
	public void customerConfig() {
		given()
			.headers("Authorization", Auth.generateToken())
		.when()
			.get(IEndPoints.configCustomer)

		//Validation
		.then()
			.statusCode(200)
			.contentType(ContentType.HTML)
			.log().all();

	}
}
