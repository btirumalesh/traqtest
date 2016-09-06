package com.nsf.traqtion.model.usermgmt;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.nsf.traqtion.model.common.LookupDTO;

public class UserMappingDTO{

	private Long userMappingId;
	private String activeFlag;
	private Date assignTemporaryFrom;
	private Date assignTemporaryTo;
	private Timestamp lastLoginDate;
	private String primaryContactFlag;
	private String reason;
	private LookupDTO status;
	private String temporaryAccessFlag;
	private Long updatedBy;
	private Timestamp updatedDate;
	private List<LookupDTO> userBusinessCategories;
	private UserDTO user;
	private ClientDTO client;
	private LookupDTO companyType;
	private LookupDTO supplier;
	private LookupDTO serviceProvider;
	private List<LookupDTO> userRoles;
	private List<LookupDTO> userSpTypes;
	private List<LookupDTO> userSuppSites;

	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	public Long getUserMappingId() {
		return userMappingId;
	}
	public void setUserMappingId(Long userMappingId) {
		this.userMappingId = userMappingId;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getAssignTemporaryFrom() {
		return assignTemporaryFrom;
	}
	public void setAssignTemporaryFrom(Date assignTemporaryFrom) {
		this.assignTemporaryFrom = assignTemporaryFrom;
	}
	public Date getAssignTemporaryTo() {
		return assignTemporaryTo;
	}
	public void setAssignTemporaryTo(Date assignTemporaryTo) {
		this.assignTemporaryTo = assignTemporaryTo;
	}
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getPrimaryContactFlag() {
		return primaryContactFlag;
	}
	public void setPrimaryContactFlag(String primaryContactFlag) {
		this.primaryContactFlag = primaryContactFlag;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LookupDTO getStatus() {
		return status;
	}
	public void setStatus(LookupDTO status) {
		this.status = status;
	}
	public String getTemporaryAccessFlag() {
		return temporaryAccessFlag;
	}
	public void setTemporaryAccessFlag(String temporaryAccessFlag) {
		this.temporaryAccessFlag = temporaryAccessFlag;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public List<LookupDTO> getUserBusinessCategories() {
		return userBusinessCategories;
	}
	public void setUserBusinessCategories(List<LookupDTO> userBusinessCategories) {
		this.userBusinessCategories = userBusinessCategories;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	public LookupDTO getCompanyType() {
		return companyType;
	}
	public void setCompanyType(LookupDTO companyType) {
		this.companyType = companyType;
	}
	public LookupDTO getSupplier() {
		return supplier;
	}
	public void setSupplier(LookupDTO supplier) {
		this.supplier = supplier;
	}
	public LookupDTO getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(LookupDTO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public List<LookupDTO> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<LookupDTO> userRoles) {
		this.userRoles = userRoles;
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
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	public String getAttribute5() {
		return attribute5;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	

}