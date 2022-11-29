package tv.ondemand.pojoUtility;

public class ContentPartner {
	private String customer;
	private String numberOfChannels;
	private String whiteListedDomains;
	private String status;

	public ContentPartner(String customer, String numberOfChannels, String whiteListedDomains, String status) {
		this.customer = customer;
		this.numberOfChannels = numberOfChannels;
		this.whiteListedDomains = whiteListedDomains;
		this.status = status;
		
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getNumberOfChannels() {
		return numberOfChannels;
	}

	public void setNumberOfChannels(String numberOfChannels) {
		this.numberOfChannels = numberOfChannels;
	}

	public String getWhiteListedDomains() {
		return whiteListedDomains;
	}

	public void setWhiteListedDomains(String whiteListedDomains) {
		this.whiteListedDomains = whiteListedDomains;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
