package tv.onDemand.customer;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import tv.onDemand.endPointURI.Configuration;
import tv.onDemand.genericUtility.API_BaseClass;
import tv.onDemand.genericUtility.Ports;
import tv.onDemand.pojoUtility.ContentPartner;
import tv.onDemand.pojoUtility.CustomConfig;

public class Customer extends API_BaseClass{
	String customerName = "TestCust3";

	@Test
	public void createCustomertesting() {
		String cc= "{\n"
				+ "    \"domain\": \"na.amagi.tv\",\n"
				+ "    \"commoningest\": false,\n"
				+ "    \"source\": \"OnDemand\"\n"
				+ "}";
//		CustomConfig custom_config = new CustomConfig("hc.amagi.tv", "false", "OnDemand");
//		ContentPartner cp = new ContentPartner(customerName, "4", "demo.com", "inactive",custom_config);
		Response customer = given().headers("Authorization",token).contentType(ContentType.JSON).port(Ports.configuration).basePath(Configuration.customer)
				.headers("Authorization", token)
				.body(cc)
				.when().post(customerName);
		customer.then().log().all();
	}
}
