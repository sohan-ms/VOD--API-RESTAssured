package tv.onDemand.onBoardChannel;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tv.ondemand.endPointURI.Configuration;
import tv.ondemand.genericUtility.API_BaseClass;
import tv.ondemand.genericUtility.Ports;

import static io.restassured.RestAssured.*;

public class Channel extends API_BaseClass{
	String query = "select channel from \"Configuration\".channel_wf_config cwc2 ";
	String channelName = "TSTCTM";
	@Test
	public void onBoardFeedToCustomer() throws Throwable {
		 String channelStatus = given().headers("Authorization", token).port(Ports.configuration).basePath(Configuration.configWFsetup).
		queryParam("wf_version", "2.0.0").queryParam("channelType", "dropoff").contentType(ContentType.JSON)
		.when().post(customerName+"/"+channelName)
		.then().extract().body().asString();
		Assert.assertEquals(channelStatus, "Channel setup execution started..");
		
		//Verify the channel in database
		dLib.getDataFromDBAndVerify(query, 1, channelName);
	}
	@Test
	public void getFeedDetails() {
		given().headers("Authorization", token).port(Ports.configuration).basePath(Configuration.configWFsetup).
		queryParam("wf_version", "2.0.0").contentType(ContentType.JSON)
		.when().get(customerName+"/"+channelName)
		.then().body("common_ingest", equalTo(false))
		.body("setupConfig.status", equalTo("Done"))
		.body("setupConfig.setup.channelCreated", equalTo("Done"))
		.body("setupConfig.setup.channelEFSImported", equalTo("Done"))
		.body("setupConfig.setup.channelMetastoreKeyCreated", equalTo("Done"))
		.body("setupConfig.setup.channelScheduleCreated", equalTo("Done"))
		.body("setupConfig.setup.channelCPS3ConfigImported", equalTo("Done"))
		.body("setupConfig.setup.channelDefaultAlertsCreated", equalTo("Done"));
		
	}
}