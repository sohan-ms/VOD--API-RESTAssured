package tv.ondemand.genericUtility;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Auth{
	public static String generateToken() {
		JSONObject jobj = new JSONObject();
		jobj.put("username", "amagiadmin@gmail.com");
		jobj.put("password", "User@321");
		
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(jobj)
				.when()
				.post(IConstants.QA_URL+IConstants.token);
		String token = resp.jsonPath().get("ondemand_token");
		return token;

	}
}