package com.nsf.traqtion.model.clientmgmt;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientSiteDocument;
import com.nsf.traqtion.data.entity.ClientSiteFacility;
import com.nsf.traqtion.data.entity.ClientSiteNotification;

public class ClientSiteDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long clientSitesId;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String comments;
	private String contactEmail;
	private Long countryId;
	private Long createdBy;
	private Timestamp creationDate;
	private String fax;
	private String hoursClosing;
	private String parentCode;
	private String parentName;
	private String primaryPhone;
	private String siteCode;
	private String siteName;
	private Long stateId;
	private Long timezoneId;
	private Long updatedBy;
	private Timestamp updatedDate;
	private String webAddress;
	private int zipCode;
	private List<ClientContact> clientContacts;
	private List<ClientSiteDocument> clientSiteDocuments;
	private List<ClientSiteFacility> clientSiteFacilities;
	private List<ClientSiteNotification> clientSiteNotifications;
	private Client client;
	public Long getClientSitesId() {
		return clientSitesId;
	}
	public void setClientSitesId(Long clientSitesId) {
		this.clientSitesId = clientSitesId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getHoursClosing() {
		return hoursClosing;
	}
	public void setHoursClosing(String hoursClosing) {
		this.hoursClosing = hoursClosing;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public Long getTimezoneId() {
		return timezoneId;
	}
	public void setTimezoneId(Long timezoneId) {
		this.timezoneId = timezoneId;
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
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public List<ClientContact> getClientContacts() {
		return clientContacts;
	}
	public void setClientContacts(List<ClientContact> clientContacts) {
		this.clientContacts = clientContacts;
	}
	public List<ClientSiteDocument> getClientSiteDocuments() {
		return clientSiteDocuments;
	}
	public void setClientSiteDocuments(List<ClientSiteDocument> clientSiteDocuments) {
		this.clientSiteDocuments = clientSiteDocuments;
	}
	public List<ClientSiteFacility> getClientSiteFacilities() {
		return clientSiteFacilities;
	}
	public void setClientSiteFacilities(List<ClientSiteFacility> clientSiteFacilities) {
		this.clientSiteFacilities = clientSiteFacilities;
	}
	public List<ClientSiteNotification> getClientSiteNotifications() {
		return clientSiteNotifications;
	}
	public void setClientSiteNotifications(List<ClientSiteNotification> clientSiteNotifications) {
		this.clientSiteNotifications = clientSiteNotifications;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
