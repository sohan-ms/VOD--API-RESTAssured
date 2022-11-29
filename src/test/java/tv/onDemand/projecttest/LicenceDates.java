package tv.onDemand.projecttest;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tv.onDemand.genericUtility.IConstants;

import static io.restassured.RestAssured.*;

import java.util.List;

/**
 * 
 * @author c-sohans
 *Validate the Licence_start_Date and Licence_end_Date from meta_store
 *If the end date is not provided than the date should be "9999-01-30T00:00:00.000Z" by default
 *If the start date is not provided than default it should be 'current date'
 */

public class LicenceDates {
	@Test(groups = {"smokeTest"})
	public void rightsEndDate() {
		String channelName = "ldrwild";
		RestAssured.baseURI = IConstants.configURL;
		Response resp1 = given()
				.when().get("channel/"+channelName);
				String tenantKey = resp1.jsonPath().get("wf_config[0].ingest_config[0].custom_config.metastore_key");
				System.out.println(tenantKey);
				
				RestAssured.baseURI = IConstants.devMetastore;
				Response resp = given()
				.headers("Authorization", tenantKey)
				.params("updated_at", "2022-06-28T00:00:00.000Z")
				
				.when()
				.get("titles");

		resp.then();
		List<Object> titleID = resp.jsonPath().getList("titles.id");
		System.out.println(titleID);
		
		for(Object id:titleID) {
			System.out.println(id);
			RestAssured.baseURI = IConstants.devMetastore;
			Response data = given()
			.headers("Authorization", tenantKey)

			.when()
			.get("titles/"+id);

			Object endDate = data.path("title.metadatum.meta_json");
			System.out.println(endDate);
		}

	}
}
