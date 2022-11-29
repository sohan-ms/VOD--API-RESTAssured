package tv.ondemand.pojoUtility;

public class CustomConfig {
	private String domain;
	private String commoningest;
	private String source;
	
	public CustomConfig(String domain, String commoningest, String source) {
		this.domain = domain;
		this.commoningest = commoningest;
		this.source = source;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getCommoningest() {
		return commoningest;
	}
	public void setCommoningest(String commoningest) {
		this.commoningest = commoningest;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
