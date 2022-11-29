package tv.ondemand.projecttest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

/**
 * 
 * @author c-sohans
 *Validate the rights end Date of an particular assets
 *If the end date is not provided than the date should be "9999-01-30T00:00:00.000Z" by default
 */

public class RightsEndDate {
	@Test(groups = {"smokeTest"})
	public void rightsEndDate() {
		String channelName = "ldrwild";
		Response resp1 = given()
				.when().get("http://3.82.204.32:31300/config/channel/"+channelName);
				String tenantKey = resp1.jsonPath().get("wf_config[0].ingest_config[0].custom_config.metastore_key");
				System.out.println(tenantKey);
		
				Response resp = given()
				.headers("Authorization", tenantKey)
				.params("updated_at", "2022-06-28T00:00:00.000Z")

				.when()
				.get("http://metastore-dev.amagi.tv/titles");

		resp.then();
		List<Object> titleID = resp.jsonPath().getList("titles.id");
		System.out.println(titleID);
		
		for(Object id:titleID) {
			System.out.println(id);

			Response data = given()
			.headers("Authorization", tenantKey)

			.when()
			.get("http://metastore-dev.amagi.tv/titles/"+id);

			data.then().assertThat().extract().response().asString();
			Object endDate = data.path("title.rights.ends");
			System.out.println(endDate);
		}

	}
}
