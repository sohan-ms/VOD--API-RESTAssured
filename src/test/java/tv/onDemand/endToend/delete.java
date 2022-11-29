package tv.onDemand.endToend;

import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import tv.ondemand.genericUtility.API_BaseClass;

public class delete extends API_BaseClass{
	@Test
	public void dld() throws Throwable {
		String query2 = "select * from \"Configuration\".customer c";
//		dLib.getDataFromDBAndVerify(query2, 1, "AutoCust");
		ArrayList<String> a = dLib.getListOfDataFromDB(query2, 2);
		for(String s:a) {
			System.out.println(s);
		}
	}
	
}
