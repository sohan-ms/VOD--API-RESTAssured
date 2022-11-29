package tv.ondemand.pojoUtility;

public class UserDetails {
	private String email;
	private String name;
	private String location;
	private String roleid;
	private String activestatus;
	private String phonenumber;
	private String customerid;
	private String customerIdsString;
	public UserDetails(String email, String name, String location, String roleid, String activestatus, String phonenumber, String customerid, String customerIdsString) {
		this.email = email;
		this.name = name;
		this.location = location;
		this.roleid = roleid;
		this.activestatus = activestatus;
		this.phonenumber = phonenumber;
		this.customerid = customerid;
		this.customerIdsString = customerIdsString;

	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getActivestatus() {
		return activestatus;
	}
	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomerIdsString() {
		return customerIdsString;
	}
	public void setCustomerIdsString(String customerIdsString) {
		this.customerIdsString = customerIdsString;
	}
}
