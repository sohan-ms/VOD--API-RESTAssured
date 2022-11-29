package tv.onDemand.customer;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tv.ondemand.endPointURI.Configuration;
import tv.ondemand.genericUtility.API_BaseClass;
import tv.ondemand.genericUtility.Ports;

public class Delete{
@Test
public void dlete() {
	String token = "eyJraWQiOiJxZUZ3QzVoN3RhdVNaMnI0SkYrV283VmZZZFh3cFQyZFRtenpvc0NWYjJzPSIsImFsZyI6IlJTMjU2In0.eyJjdXN0b206YWN0aXZlc3RhdHVzIjoiYWN0aXZlIiwic3ViIjoiMWNhNTBmMjAtMDhkMi00ZjMzLTkyZjYtYjY5NjM5OTE5YTEzIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX2xLTmw5QW5qbCIsImNvZ25pdG86dXNlcm5hbWUiOiIxY2E1MGYyMC0wOGQyLTRmMzMtOTJmNi1iNjk2Mzk5MTlhMTMiLCJjdXN0b206bG9jYXRpb24iOiJCYW5nYWxvcmUiLCJhdWQiOiIyaTNzM251ZzVqNzkxMDNoMTMyYnIxMzJscyIsImN1c3RvbTpjdXN0b21lcmlkIjoiMCIsImV2ZW50X2lkIjoiODRiNDRjMWEtYzZjMi00Zjk4LTg4ZmQtZjc1YzA4OWNkYmZhIiwidG9rZW5fdXNlIjoiaWQiLCJjdXN0b206cm9sZWlkIjoiNiIsImF1dGhfdGltZSI6MTY2NjI1MTc1NCwibmFtZSI6IkFzaWYiLCJjdXN0b206Y3VzdG9tZXJJZHNTdHJpbmciOiIwIiwiZXhwIjoxNjY2MjU1MzU0LCJjdXN0b206cGhvbmVudW1iZXIiOiI4NTQ2MzQ1NTYyIiwiaWF0IjoxNjY2MjUxNzU0LCJlbWFpbCI6ImFzaWZAYW1hZ2kuY29tIn0.O407_R7GbXjURUSkvV77X2F7IMQAoYBamJNGgDYBZAhVUi4ymV_2_ly5JicOIJziJpsju-Mw4EbNWfyS_xJ8uodLRTuz6dWeXaCGLlZSliapb3if8HMX26BR4FIs9nqdp0ezhcEaCbA1dRc2mT82JVpNGXJcEVlvSWXAGRmdNXBVAD0HHVqWaawdGJNCcNAgL9YscIWlfOuFID3lQ_0dy8eox_YGjwVLOoP4KV_jVIQLqXq0I85Q9MO7fkNEaHlmg504DqtvsX3u6s9_UeXk9I9zo3Cmfjd6TwBFoX0OssL9rpw0QtOoSbkO5oWbAuB9iS7pqcMMt3dgAgxzu3x_Rg";
	Response customer = given().headers("Authorization",token)
			.when().get("https://wbsvv9s8xh.execute-api.us-east-1.amazonaws.com/qa/config/customer");
	customer.then().log().all();
	List<String> resu = customer.jsonPath().getList("customer");
	
	for (int i = 0; i < resu.size(); i++) {
		String asd = customer.jsonPath().get("["+i+"].customer");
		System.out.println(asd);
//					if(asd.equalsIgnoreCase("samsung")) {
//						System.out.println(customer.jsonPath().get("results["+i+"].id"));
//				}
			}
	
	
}
@Test
public void dlete2() {
	String token = "eyJraWQiOiJwNEl3Y3d5d1NJMmFiZTdMUkp1bGpFeGszcE5OZHdsU0hmSlwvZjhhZ29SVT0iLCJhbGciOiJSUzI1NiJ9.eyJjdXN0b206YWN0aXZlc3RhdHVzIjoiYWN0aXZlIiwic3ViIjoiZDgwYTRhOGUtN2FlZC00N2FjLWFmMzItMGYzNDNlOWE2MjdjIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX3FoVkU0RTVYNSIsImNvZ25pdG86dXNlcm5hbWUiOiJkODBhNGE4ZS03YWVkLTQ3YWMtYWYzMi0wZjM0M2U5YTYyN2MiLCJjdXN0b206bG9jYXRpb24iOiJCYW5nbHIiLCJvcmlnaW5fanRpIjoiNWZkMWZlMDUtODFmMi00ZDRkLWJmYzctYTJlNDI0ZWY1MGZmIiwiYXVkIjoiMzdxMm5oZmhiNHBxOTlhc2FpYmhzOWU4NXUiLCJjdXN0b206Y3VzdG9tZXJpZCI6IjQ1NCIsImV2ZW50X2lkIjoiZGY5MTUyYmItNTg5ZC00OTYxLWIwMWMtNmNiZDhjYjIxZjYyIiwidG9rZW5fdXNlIjoiaWQiLCJjdXN0b206cm9sZWlkIjoiNyIsImF1dGhfdGltZSI6MTY2NTY2NTk0MSwibmFtZSI6IkFzaWYiLCJjdXN0b206Y3VzdG9tZXJJZHNTdHJpbmciOiI0NjQsNDUyLDQ1NCw0NTciLCJleHAiOjE2NjU2Njk1NDEsImN1c3RvbTpwaG9uZW51bWJlciI6Ijk5OTk5OTk5OTkiLCJpYXQiOjE2NjU2NjU5NDEsImp0aSI6ImI1ZDM5NDcxLWNjODQtNDkxYi1hOTRmLWVjM2M4ZjcxMWQ4YiIsImVtYWlsIjoiYXNpZkBhbWFnaS5jb20ifQ.KnR1VSSLJRdviyKJCXmavTypScTXbb6-JzXlPkjugL6wqMKf1A9fzRfCfjjubrnb8-2PQecuTBqQgu_vtQPE-B3pe_B8riCuKxLmrRCAafy9oUCjGX12-5agOar8ojoFo6kXxMQQTDh2YAaHX0e26scx544pzLaGf-KB4Xz7kFNbmjNzv713SfOb2rItOoe2-RHJT52F72bChsYzTNSXHAOpZa3sa7AvmN4U0p9zs-WJV6atrFMjW1RTg0xmzD973grTE79kx-p45Eaf513ifg1QSIoSrmQg1To2tYfmlMRBETLjRi9aTbastjK7KFbneRiOxTd0QIKy7e0Nzi9RJA";
	Response customer = given().headers("Authorization",token)
			.when().get("https://p5npjxodoe.execute-api.us-east-2.amazonaws.com/staging/config/customer");
	customer.then().log().all();
	List<String> resu = customer.jsonPath().getList("customer");
	
	for (int i = 0; i < resu.size(); i++) {
		String asd = customer.jsonPath().get("["+i+"].customer");
		System.out.println(asd);
//					if(asd.equalsIgnoreCase("samsung")) {
//						System.out.println(customer.jsonPath().get("results["+i+"].id"));
//				}
			}
	
	
}
@Test
public void dlete3() {
	String a[] = {"Blueia","Fasudios"};
	String token = "eyJraWQiOiJwNEl3Y3d5d1NJMmFiZTdMUkp1bGpFeGszcE5OZHdsU0hmSlwvZjhhZ29SVT0iLCJhbGciOiJSUzI1NiJ9.eyJjdXN0b206YWN0aXZlc3RhdHVzIjoiYWN0aXZlIiwic3ViIjoiZDgwYTRhOGUtN2FlZC00N2FjLWFmMzItMGYzNDNlOWE2MjdjIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX3FoVkU0RTVYNSIsImNvZ25pdG86dXNlcm5hbWUiOiJkODBhNGE4ZS03YWVkLTQ3YWMtYWYzMi0wZjM0M2U5YTYyN2MiLCJjdXN0b206bG9jYXRpb24iOiJCYW5nbHIiLCJvcmlnaW5fanRpIjoiNzlkYzlkYjgtYjFmZS00MzQwLWFhMDAtYzM1YmQwYTUxMWZjIiwiYXVkIjoiMzdxMm5oZmhiNHBxOTlhc2FpYmhzOWU4NXUiLCJjdXN0b206Y3VzdG9tZXJpZCI6IjQ1NCIsImV2ZW50X2lkIjoiMGI1YWY0OTktNDYxNS00YzE4LTk0ZTQtYjQ5NWQ4NmQ5ZWZhIiwidG9rZW5fdXNlIjoiaWQiLCJjdXN0b206cm9sZWlkIjoiNyIsImF1dGhfdGltZSI6MTY2NTc1NDI1NywibmFtZSI6IkFzaWYiLCJjdXN0b206Y3VzdG9tZXJJZHNTdHJpbmciOiI0NjQsNDUyLDQ1NCw0NTciLCJleHAiOjE2NjU3NTc4NTcsImN1c3RvbTpwaG9uZW51bWJlciI6Ijk5OTk5OTk5OTkiLCJpYXQiOjE2NjU3NTQyNTcsImp0aSI6IjQ0YTVkZTYyLWJkOWMtNGJmMi1hNWE2LTMwZjAzOGVhMmRmYyIsImVtYWlsIjoiYXNpZkBhbWFnaS5jb20ifQ.M8xVhyivjWKR5oD9wf4LC-UpHSbVNtAhw0Vex38iXu6UuY-d2fPo7UFsQQrjEYhHsS3U-k8wUR0ZDZRZ1XqdOUUIxLPCs5WMRKIVguJHM16PhO4idv27T4K4MPOzYGyAprI-ZDz6C_ZvAGhyZSOd46cRjnqg6lJ-cV8cyY2IyzKyuretSZ_Za6r5q_U2wy7lHOjxSKNQAjNspnM9D1ub4tCHDsUHSLljXv6-RplXEPeaqbmiVppZqPk5lIMClv-dZsGCfR5RM_0tcinBGzUBBtqi1an0fvLChJwBs39RWuC74rFcZUp9cE2q06Uj3CwX28Q5g9iJf92wmmuqiSXr_w";
	for(String asdf :a){
		System.out.println("    \"customer\": \""+asdf+"\",\n");
			Response customer = given().headers("Authorization",token).body("{\n"
					+ "    \"customer\": \""+asdf+"\",\n"
					+ "    \"numberOfChannels\": \"26\",\n"
					+ "    \"whiteListedDomains\": [\n"
					+ "        \"test.amagi.com\"\n"
					+ "    ],\n"
					+ "    \"status\": \"active\",\n"
					+ "    \"lastUpdated\": \"Wed Sep 28 2022 10:57:07 GMT+0530 (India Standard Time)\",\n"
					+ "    \"createdDate\": \"Wed Sep 28 2022 10:57:07 GMT+0530 (India Standard Time)\",\n"
					+ "    \"salesforce_config\": \"{}\",\n"
					+ "    \"custom_config\": \"{\\\"do main\\\":\\\"test.amagi.tv\\\",\\\"commoningest\\\":false,\\\"source\\\":\\\"OnDemand\\\"}\"\n"
					+ "}")
					.when().post("http://34.236.189.23:31300/config/customer/"+asdf);
			customer.then().log().all();
	}
}
}
