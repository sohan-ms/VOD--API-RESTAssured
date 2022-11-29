package tv.onDemand.endToend;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tv.ondemand.endPointURI.Configuration;
import tv.ondemand.genericUtility.API_BaseClass;
import tv.ondemand.genericUtility.Ports;
import tv.ondemand.pojoUtility.UserDetails;

import static io.restassured.RestAssured.*;


public class UserConfigurations extends API_BaseClass{
	String user = "sohanms";
	String ContentPartner = "TestCustomer";
	public String userID;
	public String customerID="6";
	public String customerRoleID="";
	
	@Test(priority = -2)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Severity(SeverityLevel.NORMAL)
	@Feature("Automation testing Scenario-10: 'Create a User and deleting a User'")
	@Story("configure Content Partner to the user")
	public void configCustomer() {
		Response response = given().port(Ports.configuration).basePath(Configuration.customer).headers("Authorization", token)
		.when().get(ContentPartner);
		response.then().assertThat().extract().asString();
		List<Object> id = response.jsonPath().getList("id");
		for (Object custID : id) {
			customerID = (String) custID;
		}
		System.out.println(customerID);
	}
	
	@Test(priority = 1)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Automation testing Scenario-10: 'Create a User and deleting a User'")
	@Story("register User")
	public void registerUser(){
		UserDetails usr = new UserDetails("sohanms@amagi.com", user, "india", customerRoleID, "active", "9876543211", customerID, "536");
		Response userResponse = given()
				.port(Ports.userManagement).basePath("users/user")
				.contentType(ContentType.JSON)
				.headers("Authorization", token)
				.body(usr)
				.when().post();
		userResponse.then().assertThat().statusCode(200);
		String responseBody = userResponse.jsonPath().get("description");
		Assert.assertEquals(responseBody, "Added user ("+user+")");
	}
	@Test(priority = 2)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Severity(SeverityLevel.MINOR)
	@Feature("Automation testing Scenario-10: 'Create a User and deleting a User'")
	@Story("get Specified User Details")
	public void getSpecifiedUserDetails() {
		Response userDetails = given().port(Ports.userManagement).basePath("users")
		.headers("Authorization", token)
		.when().get();
		userDetails.then().assertThat().statusCode(200);
		List<String> uniqueUserName = userDetails.jsonPath().getList("Users.Username");
		for (int j = 0; j < uniqueUserName.size(); j++) {
			String usr = userDetails.jsonPath().get("Users["+j+"].Attributes[5].Value");
			if(usr.equalsIgnoreCase(user)) {
				userID = userDetails.jsonPath().get("Users["+j+"].Attributes[0].Value");
				System.out.println(userID);
				
				given().headers("Authorization", token).port(Ports.userManagement).basePath("users/user")
				.when()
				.get(userID)
				.then().assertThat().statusCode(200)
				.log().all();
				break;
			}
		}
		
	}
	
	@Test(priority = 3)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Automation testing Scenario-10: 'Create a User and deleting a User'")
	@Story("update User")
	public void updateUser() {
		UserDetails usr = new UserDetails("sohanms@amagi.com", user, "india", customerRoleID, "inactive", "9876543211", customerID, "536");
		Response resp = given().port(Ports.userManagement).basePath("users/user")
		.headers("Authorization", token)
		.contentType(ContentType.JSON)
		.body(usr)
		.when().patch(userID);
//		.when().patch("fb6f4505-d39f-4e8f-aa4a-b1f211a39033");
		resp.then().assertThat().extract().response().asString();
		
		String respBody = resp.jsonPath().get("description");
		System.out.println(respBody);
		Assert.assertEquals(respBody, ("Updated user ("+user+")"));
	}
	@Test(priority = -1)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Severity(SeverityLevel.MINOR)
	@Feature("Automation testing Scenario-10: 'Create a User and deleting a User'")
	@Story("user Roles")
	public void userRoles() {
		Response resp = given().port(Ports.userManagement).basePath("/roles/userroles")
		.headers("Authorization", token)
		.when().get();
		resp.then().assertThat().statusCode(200);
//		.body("roleid", hasItems(6,7))
//		.body("rolename", hasItems("Amagi Admin", "Customer Admin"));
			String customerAdmin = resp.jsonPath().get("[1].rolename");
			if(customerAdmin.equals("Customer Admin")) {
				int roleID = resp.jsonPath().get("[1].roleid");
				customerRoleID = String.valueOf(roleID);
			}
	}
	
	@Test(priority = 4)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Automation testing Scenario-10: 'Create a User and deleting a User'")
	@Story("delete User")
	public void deleteUser() {
		Response userDetails = given().port(Ports.userManagement).basePath("users")
		.headers("Authorization", token)
		.when().get();
		userDetails.then().assertThat().statusCode(200);
		List<String> uniqueUserName = userDetails.jsonPath().getList("Users.Username");
		for (int j = 0; j < uniqueUserName.size(); j++) {
			String usr = userDetails.jsonPath().get("Users["+j+"].Attributes[5].Value");
			if(usr.equalsIgnoreCase(user)) {
				userID = userDetails.jsonPath().get("Users["+j+"].Attributes[0].Value");
				System.out.println(userID);
				
				Response responseBody = given().headers("Authorization", token).port(Ports.userManagement).basePath("users/user")
				.when()
				.delete(userID);
				responseBody.then().assertThat()
				.statusCode(200).log().all();
				String description = responseBody.jsonPath().get("description");
				Assert.assertEquals(description, "Deleted user ("+userID+")");
				break;
			}
		}
	}
}