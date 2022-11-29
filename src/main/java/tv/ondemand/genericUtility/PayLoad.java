package tv.ondemand.genericUtility;

public class PayLoad {
	public static String contentPartner(String contentPartner) {
		String customerDetails = "{\n"
				+ "    \"customer\": \"TestCust\",\n"
				+ "    \"numberOfChannels\": \"3\",\n"
				+ "    \"whiteListedDomains\": [],\n"
				+ "    \"status\": \"active\"\n"
				+ "}";
		return customerDetails;
	}
}
