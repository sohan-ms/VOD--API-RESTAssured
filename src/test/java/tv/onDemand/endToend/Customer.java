package tv.onDemand.endToend;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

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
import tv.ondemand.pojoUtility.ContentPartner;

public class Customer extends API_BaseClass{
	String noOfFeed = "5";
	String deleteQuery = "delete from \"Configuration\".customer c where customer ='"+customerName+"'";
	String selectCustQuery = "select * from \"Configuration\".customer c where customer ='"+customerName+"'";
	
	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Feature("Automation testing Scenario-1: 'Create a customer'")
	@Story("Create a New VOD Customer")
	public void createCustomer() throws Throwable {
		ArrayList<String> customerNamesFromDB = dLib.getListOfDataFromDB(selectCustQuery, 2);
		for(String getCustomerName: customerNamesFromDB) {
			if(customerName.equalsIgnoreCase(getCustomerName)) {
				System.out.println("customerExist");
				Assert.assertFalse(false);
			}
			break;
		}
		ContentPartner cp = new ContentPartner(customerName, noOfFeed, "demo.com", "active");
		Response customer = given().headers("Authorization",token).contentType(ContentType.JSON)
				.port(Ports.configuration).basePath(Configuration.customer).headers("Authorization", token)
		.body(cp)
		.when().post(customerName);
		String status = customer.jsonPath().get("description");
		Assert.assertEquals(status, "Workflow version ($) created");
	}
	
	@Test(priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Feature("Automation testing Scenario-1: 'Update a customer'")
	@Story("Update a VOD Customer")
	public void updateCustomer(){
		ContentPartner cp = new ContentPartner(customerName, noOfFeed+"1","demo.com", "inactive");
		Response customer = given().headers("Authorization",token).contentType(ContentType.JSON)
				.port(Ports.configuration).basePath("config/customer")
		.body(cp)
		.when().patch(customerName);
		customer.then().assertThat().statusCode(200);
		String customerResp = customer.jsonPath().get("description");
		Assert.assertEquals(customerResp, "Workflow version ($) created");
		
	}@Test(priority = 3)
	@Severity(SeverityLevel.NORMAL)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Feature("Automation testing Scenario-1: 'Update a customer'")
	@Story("List All VOD Customers")
	public void listAllVODCustomers() {
		Response customersList = given().headers("Authorization", token).port(Ports.configuration)
				.basePath(Configuration.customer)
		.when().get();
		customersList.then().assertThat().statusCode(200);
		List<Object> custName = customersList.jsonPath().getList("customer");
		for(Object ls: custName) {
			if(ls.equals(customerName)) {
				System.out.println(ls);
				Response resp = given().headers("Authorization", token).port(Ports.configuration)
						.basePath(Configuration.customer)
				.when().get(customerName);
				resp.then().assertThat().statusCode(200);
				String cust = resp.jsonPath().get("[0].customer");
				String no = resp.jsonPath().get("[0].numberofchannels");
				Assert.assertEquals(cust, customerName);
				Assert.assertNotEquals(no, noOfFeed);
				break;
			}
		}
	}
	
	@Test(priority = 4)
	@Severity(SeverityLevel.MINOR)
	@Epic("CPV20-2438-API Automation Testing - Q3'22")
	@Feature("Automation testing Scenario-1: 'Update a customer'")
	@Story("delete a vod customer from the DataBase")
	public void deleteTheVODCustomer() throws SQLException {
		String deleteQuery1 = "delete from \"Configuration\".customer c where customer ='testswager'";
		dLib.executeQuery(deleteQuery1);
		System.out.println("=============deleted customer============");
	}
	
}
