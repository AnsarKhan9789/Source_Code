package methods;

public class PersonPojo extends UserDetails{
		
	private long aadharCard;
	private String panCard;
	private String userStatus;
	public long getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(long aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
