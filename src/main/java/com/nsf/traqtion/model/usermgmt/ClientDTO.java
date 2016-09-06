package com.nsf.traqtion.model.usermgmt;

public class ClientDTO {

	private Long clientId;
	private String businessGroup;
	private String clientCategoryName;
	private String clientCode;
	private String clientContactName;
	private String clientContactType;
	private String clientName;
	private String contactEmail;
	private String emailAddress;
	private String language;
	private String paymentPlan;
	private String store;
	private String timeZone;
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getBusinessGroup() {
		return businessGroup;
	}
	public void setBusinessGroup(String businessGroup) {
		this.businessGroup = businessGroup;
	}
	public String getClientCategoryName() {
		return clientCategoryName;
	}
	public void setClientCategoryName(String clientCategoryName) {
		this.clientCategoryName = clientCategoryName;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientContactName() {
		return clientContactName;
	}
	public void setClientContactName(String clientContactName) {
		this.clientContactName = clientContactName;
	}
	public String getClientContactType() {
		return clientContactType;
	}
	public void setClientContactType(String clientContactType) {
		this.clientContactType = clientContactType;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPaymentPlan() {
		return paymentPlan;
	}
	public void setPaymentPlan(String paymentPlan) {
		this.paymentPlan = paymentPlan;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", businessGroup=" + businessGroup + ", clientCategoryName="
				+ clientCategoryName + ", clientCode=" + clientCode + ", clientContactName=" + clientContactName
				+ ", clientContactType=" + clientContactType + ", clientName=" + clientName + ", contactEmail="
				+ contactEmail + ", emailAddress=" + emailAddress + ", language=" + language + ", paymentPlan="
				+ paymentPlan + ", store=" + store + ", timeZone=" + timeZone + "]";
	}
	
	
}