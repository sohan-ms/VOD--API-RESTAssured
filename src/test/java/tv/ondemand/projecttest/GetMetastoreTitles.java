package tv.ondemand.projecttest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


import io.restassured.response.Response;
import tv.ondemand.genericUtility.Auth;

public class GetMetastoreTitles {
	@Test
	public void metastoreTitles() {
		String tenantKey = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjQ4MDY4MDE4NTQsImlzcyI6Im1ldGFzdG9yZSIsImF1ZCI6ImNsaWVudCIsInVzZXJuYW1lIjoibGl"
				+ "0dGxlLWRvdC1zdHVkaW9zX3ZvZCIsImN1c3RvbWVyIjoiTGl0dGxlLURvdC1TdHVkaW9zIn0.Se7g8EmKjSQeK6llbAsLnCaaViJSyRqk7_n"
				+ "Sjk10d0g";
		Response resp = given()
				.headers("Authorization", tenantKey)
				
				.when()
				.get("http://metastore-dev.amagi.tv/titles/1");
				
				resp.then();
				 String rights1 = resp.jsonPath().getString("title.rights[0].ends");
				System.out.println("ends date ---> "+rights1);
				
				given()
				.headers("Authorization", Auth.generateToken())
				.param("export", "true")
				
				.when()
				.get("http://3.82.204.32:31200/media/assets/liscense/invalid/customer/Little-Dot-Studios/ldrwild")
				
				.then()
				.log().all();
	}
}