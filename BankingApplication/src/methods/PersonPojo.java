package methods;

public class PersonPojo extends CustomerPojo{
	private String name;
	private String emailId;
	private long mobileNumber;
	private String identityToVerify;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getIdentityToVerify() {
		return identityToVerify;
	}
	public void setIdentityToVerify(String identityToVerify) {
		this.identityToVerify = identityToVerify;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
