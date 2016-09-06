package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the client_sites database table.
 * 
 */
@Entity
@Table(name="client_sites")
@NamedQueries(
        {
            @NamedQuery(name="ClientSite.findAll", query="SELECT c FROM ClientSite c"),
            @NamedQuery(
            name = "ClientSite.findByClient",
            query = "from ClientSite site where site.client = :client"
            )
        }
    ) 
public class ClientSite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_sites_id")
	private Long clientSitesId;

	private String address1;

	private String address2;

	private String address3;

	private String city;

	private String comments;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="country_id")
	private Long countryId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String fax;

	@Column(name="hours_closing")
	private String hoursClosing;

	@Column(name="parent_code")
	private String parentCode;

	@Column(name="parent_name")
	private String parentName;

	@Column(name="primary_phone")
	private String primaryPhone;

	@Column(name="site_code")
	private String siteCode;

	@Column(name="site_name")
	private String siteName;

	@Column(name="state_id")
	private Long stateId;

	@Column(name="timezone_id")
	private Long timezoneId;

	@Column(name="updated_by")
	private Long updatedBy;
  
	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="web_address")
	private String webAddress;

	@Column(name="zip_code")
	private int zipCode;
	
	//bi-directional many-to-one association to ClientContact
	@JsonIgnore
	@OneToMany(mappedBy="clientSite",fetch = FetchType.LAZY)
	private List<ClientContact> clientContacts;
	
     //bi-directional many-to-one association to ClientSiteDocument
	@JsonIgnore
	@OneToMany(mappedBy="clientSite",fetch = FetchType.LAZY)
	private List<ClientSiteDocument> clientSiteDocuments;

	//bi-directional many-to-one association to ClientSiteFacility
	@JsonIgnore
	@OneToMany(mappedBy="clientSite",fetch = FetchType.LAZY)
	private List<ClientSiteFacility> clientSiteFacilities;
/*
	//bi-directional many-to-one association to ClientSiteNotification
	@OneToMany(mappedBy="clientSite")
	private List<ClientSiteNotification> clientSiteNotifications;
*/
	//bi-directional many-to-one association to Client
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;

	public ClientSite() {
	}

	public Long getClientSitesId() {
		return this.clientSitesId;
	}

	public void setClientSitesId(Long clientSitesId) {
		this.clientSitesId = clientSitesId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHoursClosing() {
		return this.hoursClosing;
	}

	public void setHoursClosing(String hoursClosing) {
		this.hoursClosing = hoursClosing;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPrimaryPhone() {
		return this.primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSiteCode() {
		return this.siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getTimezoneId() {
		return this.timezoneId;
	}

	public void setTimezoneId(Long timezoneId) {
		this.timezoneId = timezoneId;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getWebAddress() {
		return this.webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public List<ClientContact> getClientContacts() {
		return this.clientContacts;
	}

	public void setClientContacts(List<ClientContact> clientContacts) {
		this.clientContacts = clientContacts;
	}

	public ClientContact addClientContact(ClientContact clientContact) {
		getClientContacts().add(clientContact);
		clientContact.setClientSite(this);

		return clientContact;
	}

	public ClientContact removeClientContact(ClientContact clientContact) {
		getClientContacts().remove(clientContact);
		clientContact.setClientSite(null);

		return clientContact;
	}

	public List<ClientSiteDocument> getClientSiteDocuments() {
		return this.clientSiteDocuments;
	}

	public void setClientSiteDocuments(List<ClientSiteDocument> clientSiteDocuments) {
		this.clientSiteDocuments = clientSiteDocuments;
	}

	public ClientSiteDocument addClientSiteDocument(ClientSiteDocument clientSiteDocument) {
		getClientSiteDocuments().add(clientSiteDocument);
		clientSiteDocument.setClientSite(this);

		return clientSiteDocument;
	}

	public ClientSiteDocument removeClientSiteDocument(ClientSiteDocument clientSiteDocument) {
		getClientSiteDocuments().remove(clientSiteDocument);
		clientSiteDocument.setClientSite(null);

		return clientSiteDocument;
	}

	public List<ClientSiteFacility> getClientSiteFacilities() {
		return this.clientSiteFacilities;
	}

	public void setClientSiteFacilities(List<ClientSiteFacility> clientSiteFacilities) {
		this.clientSiteFacilities = clientSiteFacilities;
	}

	public ClientSiteFacility addClientSiteFacility(ClientSiteFacility clientSiteFacility) {
		getClientSiteFacilities().add(clientSiteFacility);
		clientSiteFacility.setClientSite(this);

		return clientSiteFacility;
	}

	public ClientSiteFacility removeClientSiteFacility(ClientSiteFacility clientSiteFacility) {
		getClientSiteFacilities().remove(clientSiteFacility);
		clientSiteFacility.setClientSite(null);

		return clientSiteFacility;
	}
/*
	public List<ClientSiteNotification> getClientSiteNotifications() {
		return this.clientSiteNotifications;
	}

	public void setClientSiteNotifications(List<ClientSiteNotification> clientSiteNotifications) {
		this.clientSiteNotifications = clientSiteNotifications;
	}
*/
/*	public ClientSiteNotification addClientSiteNotification(ClientSiteNotification clientSiteNotification) {
		getClientSiteNotifications().add(clientSiteNotification);
		clientSiteNotification.setClientSite(this);

		return clientSiteNotification;
	}

	public ClientSiteNotification removeClientSiteNotification(ClientSiteNotification clientSiteNotification) {
		getClientSiteNotifications().remove(clientSiteNotification);
		clientSiteNotification.setClientSite(null);

		return clientSiteNotification;
	}*/

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}