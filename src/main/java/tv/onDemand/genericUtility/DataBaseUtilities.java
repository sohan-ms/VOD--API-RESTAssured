package tv.onDemand.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilities {
	static Connection con = null;
	static ResultSet result = null;
	static Driver driver;
	
	public void ConnectToDB() throws SQLException{
		try {
			driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:postgresql://vod-delivery-dev.cbh5lctsddkt.us-east-1.rds.amazonaws.com:5432/vod_delivery_dev", "root", "Passw0rd2020");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeDB() throws SQLException {
		con.close();
		
	}
	public void executeQuery(String query) {
		try {
			con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	
	public ArrayList<String> getListOfDataFromDB(String query, int columnIndex) throws SQLException {
		String value = null;
		ArrayList<String> al = new ArrayList<String>();
		result = con.createStatement().executeQuery(query);
		while(result.next()) {
			value = result.getString(columnIndex);
			al.add(value);
			
		}
		return al;
	}
	
	public String getDataFromDBAndVerify(String query, int columnName, String expData) throws SQLException{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) {
			try {
				if(result.getString(columnName).equalsIgnoreCase(expData)) {
					flag = true;
					break;
				}
			} catch (Exception e) {
			}
		}
		if(flag) {
			System.out.println(expData + " Data verified in dataBase");
			Assert.assertTrue(true, "Data verified in dataBase");
			return expData;
		}
		else {
			System.out.println(expData + " Data not verified");
			Assert.assertTrue(false, "Data not verified");;
			return expData;
		}
	}
}
