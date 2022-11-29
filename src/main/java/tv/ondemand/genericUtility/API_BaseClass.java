package tv.ondemand.genericUtility;

import io.restassured.RestAssured;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class API_BaseClass {
	public String customerName = "TestAutomateRun2";
	public DataBaseUtilities dLib = new DataBaseUtilities();
	public String token = Auth.generateToken();
	
	@BeforeSuite
	public void connectDB() throws Throwable{
		dLib.ConnectToDB();
		System.out.println("============DB connection successfull ===========");
	}
	
	@BeforeClass
	public void baseUri() {
		RestAssured.baseURI = IConstants.QA_URL;
	}
	
	@AfterSuite
	public void closeDBConnection() throws Throwable{
		dLib.closeDB();
		System.out.println("============DB 	connection closed	 ===========");
	}
	

}
