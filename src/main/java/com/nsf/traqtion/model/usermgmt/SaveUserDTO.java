package com.nsf.traqtion.model.usermgmt;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class SaveUserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1843912615195617990L;
	/**
	 * 
	 */
	
	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String middleName;
	private String emailId;
	private Long companyTypeId;
	private Long jobTitleId;
	private String jobTitleTxt;
	private Long languageId;
	private String mobilePhone;
	private String workPhone;
	private String statusCodes;
	private List<Long> categoriesList;
	private List<Long> businessList;
	private Timestamp assignTemporaryFrom;
	private Timestamp assignTemporaryTo;
	private Long serviceProviderId;
	private Long supplierId;
	private List<Long> rolesList;
	private Long clientId;
	private List<Long> supplierfacilityList;
	private List<Long> serviceProviderList;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getCompanyTypeId() {
		return companyTypeId;
	}
	public void setCompanyTypeId(Long companyTypeId) {
		this.companyTypeId = companyTypeId;
	}
	public Long getJobTitleId() {
		return jobTitleId;
	}
	public void setJobTitleId(Long jobTitleId) {
		this.jobTitleId = jobTitleId;
	}
	public String getJobTitleTxt() {
		return jobTitleTxt;
	}
	public void setJobTitleTxt(String jobTitleTxt) {
		this.jobTitleTxt = jobTitleTxt;
	}
	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getStatusCodes() {
		return statusCodes;
	}
	public void setStatusCodes(String statusCodes) {
		this.statusCodes = statusCodes;
	}
	public List<Long> getCategoriesList() {
		return categoriesList;
	}
	public void setCategoriesList(List<Long> categoriesList) {
		this.categoriesList = categoriesList;
	}
	public List<Long> getBusinessList() {
		return businessList;
	}
	public void setBusinessList(List<Long> businessList) {
		this.businessList = businessList;
	}
	public Timestamp getAssignTemporaryFrom() {
		return assignTemporaryFrom;
	}
	public void setAssignTemporaryFrom(Timestamp assignTemporaryFrom) {
		this.assignTemporaryFrom = assignTemporaryFrom;
	}
	public Timestamp getAssignTemporaryTo() {
		return assignTemporaryTo;
	}
	public void setAssignTemporaryTo(Timestamp assignTemporaryTo) {
		this.assignTemporaryTo = assignTemporaryTo;
	}
	public Long getServiceProviderId() {
		return serviceProviderId;
	}
	public void setServiceProviderId(Long serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public List<Long> getRolesList() {
		return rolesList;
	}
	public void setRolesList(List<Long> rolesList) {
		this.rolesList = rolesList;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public List<Long> getSupplierfacilityList() {
		return supplierfacilityList;
	}
	public void setSupplierfacilityList(List<Long> supplierfacilityList) {
		this.supplierfacilityList = supplierfacilityList;
	}
	public List<Long> getServiceProviderList() {
		return serviceProviderList;
	}
	public void setServiceProviderList(List<Long> serviceProviderList) {
		this.serviceProviderList = serviceProviderList;
	}
	@Override
	public String toString() {
		return "SaveUserDTO [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", middleName=" + middleName + ", emailId=" + emailId + ", companyTypeId=" + companyTypeId
				+ ", jobTitleId=" + jobTitleId + ", jobTitleTxt=" + jobTitleTxt + ", languageId=" + languageId
				+ ", mobilePhone=" + mobilePhone + ", workPhone=" + workPhone + ", statusCodes=" + statusCodes
				+ ", categoriesList=" + categoriesList + ", businessList=" + businessList + ", assignTemporaryFrom="
				+ assignTemporaryFrom + ", assignTemporaryTo=" + assignTemporaryTo + ", serviceProviderId="
				+ serviceProviderId + ", supplierId=" + supplierId + ", rolesList=" + rolesList + ", clientId="
				+ clientId + ", supplierfacilityList=" + supplierfacilityList + ", serviceProviderList="
				+ serviceProviderList + "]";
	}

	
}