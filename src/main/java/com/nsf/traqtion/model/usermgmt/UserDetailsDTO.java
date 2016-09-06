package com.nsf.traqtion.model.usermgmt;

import java.io.Serializable;
import java.util.List;

import com.nsf.traqtion.model.common.LookupDTO;
import com.nsf.traqtion.model.common.UserBusinessCategoryDTO;


public class UserDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8431295024038498321L;
	
	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String middleName;
	private String emailId;
	private LookupDTO companyType;
	private LookupDTO jobTitle;
	private String jobTitleTxt;
	private LookupDTO language;
	private String mobilePhone;
	private String workPhone;
	private LookupDTO status;
	private List<LookupDTO> categoriesList;
	private List<LookupDTO> businessList;
	private List<UserBusinessCategoryDTO> businessCategoryList;
	private String assignTemporaryFrom;
	private String assignTemporaryTo;
	private LookupDTO serviceProvider;
	private LookupDTO supplier;
	private List<LookupDTO> rolesList;
	private List<String> permissionList;
	private ClientDTO client;
	private List<LookupDTO> userSpTypes;
	private List<LookupDTO> userSuppSites;
	
	
	// TODO supplier Sites list
	// TODO Service Provider Types List
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
	public LookupDTO getCompanyType() {
		return companyType;
	}
	public void setCompanyType(LookupDTO companyType) {
		this.companyType = companyType;
	}
	public LookupDTO getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(LookupDTO jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobTitleTxt() {
		return jobTitleTxt;
	}
	public void setJobTitleTxt(String jobTitleTxt) {
		this.jobTitleTxt = jobTitleTxt;
	}
	public LookupDTO getLanguage() {
		return language;
	}
	public void setLanguage(LookupDTO language) {
		this.language = language;
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
	public LookupDTO getStatus() {
		return status;
	}
	public void setStatus(LookupDTO status) {
		this.status = status;
	}
	public List<LookupDTO> getCategoriesList() {
		return categoriesList;
	}
	public void setCategoriesList(List<LookupDTO> categoriesList) {
		this.categoriesList = categoriesList;
	}
	public List<LookupDTO> getBusinessList() {
		return businessList;
	}
	public void setBusinessList(List<LookupDTO> businessList) {
		this.businessList = businessList;
	}
	
	
	public String getAssignTemporaryFrom() {
		return assignTemporaryFrom;
	}
	public void setAssignTemporaryFrom(String assignTemporaryFrom) {
		this.assignTemporaryFrom = assignTemporaryFrom;
	}
	public String getAssignTemporaryTo() {
		return assignTemporaryTo;
	}
	public void setAssignTemporaryTo(String assignTemporaryTo) {
		this.assignTemporaryTo = assignTemporaryTo;
	}
	public LookupDTO getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(LookupDTO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public LookupDTO getSupplier() {
		return supplier;
	}
	public void setSupplier(LookupDTO supplier) {
		this.supplier = supplier;
	}
	public List<LookupDTO> getRolesList() {
		return rolesList;
	}
	public void setRolesList(List<LookupDTO> rolesList) {
		this.rolesList = rolesList;
	}
	public List<String> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}	
	
	
	public List<LookupDTO> getUserSpTypes() {
		return userSpTypes;
	}
	public void setUserSpTypes(List<LookupDTO> userSpTypes) {
		this.userSpTypes = userSpTypes;
	}
	public List<LookupDTO> getUserSuppSites() {
		return userSuppSites;
	}
	public void setUserSuppSites(List<LookupDTO> userSuppSites) {
		this.userSuppSites = userSuppSites;
	}
	public List<UserBusinessCategoryDTO> getBusinessCategoryList() {
		return businessCategoryList;
	}
	public void setBusinessCategoryList(List<UserBusinessCategoryDTO> businessCategoryList) {
		this.businessCategoryList = businessCategoryList;
	}
	@Override
	public String toString() {
		return "UserDetailsDTO [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", middleName=" + middleName + ", emailId=" + emailId + ", companyType="
				+ companyType + ", jobTitle=" + jobTitle + ", jobTitleTxt=" + jobTitleTxt + ", language=" + language
				+ ", mobilePhone=" + mobilePhone + ", workPhone=" + workPhone + ", status=" + status
				+ ", categoriesList=" + categoriesList + ", businessList=" + businessList + ", businessCategoryList="
				+ businessCategoryList + ", assignTemporaryFrom=" + assignTemporaryFrom + ", assignTemporaryTo="
				+ assignTemporaryTo + ", serviceProvider=" + serviceProvider + ", supplier=" + supplier + ", rolesList="
				+ rolesList + ", permissionList=" + permissionList + ", client=" + client + ", userSpTypes="
				+ userSpTypes + ", userSuppSites=" + userSuppSites + "]";
	}
	
	
	

	
	
	
}