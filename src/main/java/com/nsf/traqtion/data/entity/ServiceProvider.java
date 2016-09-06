package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the service_providers database table.
 * 
 */
@Entity
@Table(name="service_providers")
@NamedQuery(name="ServiceProvider.findAll", query="SELECT s FROM ServiceProvider s")
public class ServiceProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_providers_id")
	private Long serviceProvidersId;

	@Column(name="alternate_phone")
	private String alternatePhone;

	private String commnets;

	@Column(name="company_name")
	private String companyName;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String fax;

	@Column(name="government_id")
	private String governmentId;

	@Column(name="group_flag")
	private String groupFlag;

	@Column(name="group_id")
	private Long groupId;

	private String healthmark;

	@Column(name="hours_closing")
	private String hoursClosing;

	@Column(name="npd_flag")
	private String npdFlag;

	@Column(name="nsf_supplier_code")
	private String nsfSupplierCode;

	@Column(name="primary_phone")
	private String primaryPhone;

	@Column(name="service_provider_code")
	private String serviceProviderCode;

	@Column(name="status_id")
	private Long statusId;

	@Column(name="tech_approve_flag")
	private String techApproveFlag;

	@Column(name="timezone_id")
	private Long timezoneId;

	@Column(name="toll_free_phone")
	private String tollFreePhone;

	@Column(name="traq_language_id")
	private Long traqLanguageId;

	@Column(name="traqtion_code")
	private String traqtionCode;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="web_address")
	private String webAddress;

	//bi-directional many-to-one association to BusinessRegistration
	@OneToMany(mappedBy="serviceProvider")
	private List<BusinessRegistration> businessRegistrations;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to SpAddress
	@OneToMany(mappedBy="serviceProvider")
	private List<SpAddress> spAddresses;

	//bi-directional many-to-one association to SpAltCode
	@OneToMany(mappedBy="serviceProvider")
	private List<SpAltCode> spAltCodes;

	//bi-directional many-to-one association to SpAttachment
	@OneToMany(mappedBy="serviceProvider")
	private List<SpAttachment> spAttachments;

	//bi-directional many-to-one association to SpClientContact
	@OneToMany(mappedBy="serviceProvider")
	private List<SpClientContact> spClientContacts;

	//bi-directional many-to-one association to SpContact
	@OneToMany(mappedBy="serviceProvider")
	private List<SpContact> spContacts;

	//bi-directional many-to-one association to SpInsurance
	@OneToMany(mappedBy="serviceProvider")
	private List<SpInsurance> spInsurances;

	//bi-directional many-to-one association to SpOrganicCert
	@OneToMany(mappedBy="serviceProvider")
	private List<SpOrganicCert> spOrganicCerts;

	//bi-directional many-to-one association to SpOthrCert
	@OneToMany(mappedBy="serviceProvider")
	private List<SpOthrCert> spOthrCerts;

	//bi-directional many-to-one association to SpQaStatus
	@OneToMany(mappedBy="serviceProvider")
	private List<SpQaStatus> spQaStatuses;

	//bi-directional many-to-one association to UserMapping
	@OneToMany(mappedBy="serviceProvider")
	private List<UserMapping> userMappings;

	public ServiceProvider() {
	}

	public Long getServiceProvidersId() {
		return this.serviceProvidersId;
	}

	public void setServiceProvidersId(Long serviceProvidersId) {
		this.serviceProvidersId = serviceProvidersId;
	}

	public String getAlternatePhone() {
		return this.alternatePhone;
	}

	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}

	public String getCommnets() {
		return this.commnets;
	}

	public void setCommnets(String commnets) {
		this.commnets = commnets;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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

	public String getGovernmentId() {
		return this.governmentId;
	}

	public void setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
	}

	public String getGroupFlag() {
		return this.groupFlag;
	}

	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getHealthmark() {
		return this.healthmark;
	}

	public void setHealthmark(String healthmark) {
		this.healthmark = healthmark;
	}

	public String getHoursClosing() {
		return this.hoursClosing;
	}

	public void setHoursClosing(String hoursClosing) {
		this.hoursClosing = hoursClosing;
	}

	public String getNpdFlag() {
		return this.npdFlag;
	}

	public void setNpdFlag(String npdFlag) {
		this.npdFlag = npdFlag;
	}

	public String getNsfSupplierCode() {
		return this.nsfSupplierCode;
	}

	public void setNsfSupplierCode(String nsfSupplierCode) {
		this.nsfSupplierCode = nsfSupplierCode;
	}

	public String getPrimaryPhone() {
		return this.primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getServiceProviderCode() {
		return this.serviceProviderCode;
	}

	public void setServiceProviderCode(String serviceProviderCode) {
		this.serviceProviderCode = serviceProviderCode;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getTechApproveFlag() {
		return this.techApproveFlag;
	}

	public void setTechApproveFlag(String techApproveFlag) {
		this.techApproveFlag = techApproveFlag;
	}

	public Long getTimezoneId() {
		return this.timezoneId;
	}

	public void setTimezoneId(Long timezoneId) {
		this.timezoneId = timezoneId;
	}

	public String getTollFreePhone() {
		return this.tollFreePhone;
	}

	public void setTollFreePhone(String tollFreePhone) {
		this.tollFreePhone = tollFreePhone;
	}

	public Long getTraqLanguageId() {
		return this.traqLanguageId;
	}

	public void setTraqLanguageId(Long traqLanguageId) {
		this.traqLanguageId = traqLanguageId;
	}

	public String getTraqtionCode() {
		return this.traqtionCode;
	}

	public void setTraqtionCode(String traqtionCode) {
		this.traqtionCode = traqtionCode;
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

	public List<BusinessRegistration> getBusinessRegistrations() {
		return this.businessRegistrations;
	}

	public void setBusinessRegistrations(List<BusinessRegistration> businessRegistrations) {
		this.businessRegistrations = businessRegistrations;
	}

	public BusinessRegistration addBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().add(businessRegistration);
		businessRegistration.setServiceProvider(this);

		return businessRegistration;
	}

	public BusinessRegistration removeBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().remove(businessRegistration);
		businessRegistration.setServiceProvider(null);

		return businessRegistration;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SpAddress> getSpAddresses() {
		return this.spAddresses;
	}

	public void setSpAddresses(List<SpAddress> spAddresses) {
		this.spAddresses = spAddresses;
	}

	public SpAddress addSpAddress(SpAddress spAddress) {
		getSpAddresses().add(spAddress);
		spAddress.setServiceProvider(this);

		return spAddress;
	}

	public SpAddress removeSpAddress(SpAddress spAddress) {
		getSpAddresses().remove(spAddress);
		spAddress.setServiceProvider(null);

		return spAddress;
	}

	public List<SpAltCode> getSpAltCodes() {
		return this.spAltCodes;
	}

	public void setSpAltCodes(List<SpAltCode> spAltCodes) {
		this.spAltCodes = spAltCodes;
	}

	public SpAltCode addSpAltCode(SpAltCode spAltCode) {
		getSpAltCodes().add(spAltCode);
		spAltCode.setServiceProvider(this);

		return spAltCode;
	}

	public SpAltCode removeSpAltCode(SpAltCode spAltCode) {
		getSpAltCodes().remove(spAltCode);
		spAltCode.setServiceProvider(null);

		return spAltCode;
	}

	public List<SpAttachment> getSpAttachments() {
		return this.spAttachments;
	}

	public void setSpAttachments(List<SpAttachment> spAttachments) {
		this.spAttachments = spAttachments;
	}

	public SpAttachment addSpAttachment(SpAttachment spAttachment) {
		getSpAttachments().add(spAttachment);
		spAttachment.setServiceProvider(this);

		return spAttachment;
	}

	public SpAttachment removeSpAttachment(SpAttachment spAttachment) {
		getSpAttachments().remove(spAttachment);
		spAttachment.setServiceProvider(null);

		return spAttachment;
	}

	public List<SpClientContact> getSpClientContacts() {
		return this.spClientContacts;
	}

	public void setSpClientContacts(List<SpClientContact> spClientContacts) {
		this.spClientContacts = spClientContacts;
	}

	public SpClientContact addSpClientContact(SpClientContact spClientContact) {
		getSpClientContacts().add(spClientContact);
		spClientContact.setServiceProvider(this);

		return spClientContact;
	}

	public SpClientContact removeSpClientContact(SpClientContact spClientContact) {
		getSpClientContacts().remove(spClientContact);
		spClientContact.setServiceProvider(null);

		return spClientContact;
	}

	public List<SpContact> getSpContacts() {
		return this.spContacts;
	}

	public void setSpContacts(List<SpContact> spContacts) {
		this.spContacts = spContacts;
	}

	public SpContact addSpContact(SpContact spContact) {
		getSpContacts().add(spContact);
		spContact.setServiceProvider(this);

		return spContact;
	}

	public SpContact removeSpContact(SpContact spContact) {
		getSpContacts().remove(spContact);
		spContact.setServiceProvider(null);

		return spContact;
	}

	public List<SpInsurance> getSpInsurances() {
		return this.spInsurances;
	}

	public void setSpInsurances(List<SpInsurance> spInsurances) {
		this.spInsurances = spInsurances;
	}

	public SpInsurance addSpInsurance(SpInsurance spInsurance) {
		getSpInsurances().add(spInsurance);
		spInsurance.setServiceProvider(this);

		return spInsurance;
	}

	public SpInsurance removeSpInsurance(SpInsurance spInsurance) {
		getSpInsurances().remove(spInsurance);
		spInsurance.setServiceProvider(null);

		return spInsurance;
	}

	public List<SpOrganicCert> getSpOrganicCerts() {
		return this.spOrganicCerts;
	}

	public void setSpOrganicCerts(List<SpOrganicCert> spOrganicCerts) {
		this.spOrganicCerts = spOrganicCerts;
	}

	public SpOrganicCert addSpOrganicCert(SpOrganicCert spOrganicCert) {
		getSpOrganicCerts().add(spOrganicCert);
		spOrganicCert.setServiceProvider(this);

		return spOrganicCert;
	}

	public SpOrganicCert removeSpOrganicCert(SpOrganicCert spOrganicCert) {
		getSpOrganicCerts().remove(spOrganicCert);
		spOrganicCert.setServiceProvider(null);

		return spOrganicCert;
	}

	public List<SpOthrCert> getSpOthrCerts() {
		return this.spOthrCerts;
	}

	public void setSpOthrCerts(List<SpOthrCert> spOthrCerts) {
		this.spOthrCerts = spOthrCerts;
	}

	public SpOthrCert addSpOthrCert(SpOthrCert spOthrCert) {
		getSpOthrCerts().add(spOthrCert);
		spOthrCert.setServiceProvider(this);

		return spOthrCert;
	}

	public SpOthrCert removeSpOthrCert(SpOthrCert spOthrCert) {
		getSpOthrCerts().remove(spOthrCert);
		spOthrCert.setServiceProvider(null);

		return spOthrCert;
	}

	public List<SpQaStatus> getSpQaStatuses() {
		return this.spQaStatuses;
	}

	public void setSpQaStatuses(List<SpQaStatus> spQaStatuses) {
		this.spQaStatuses = spQaStatuses;
	}

	public SpQaStatus addSpQaStatus(SpQaStatus spQaStatus) {
		getSpQaStatuses().add(spQaStatus);
		spQaStatus.setServiceProvider(this);

		return spQaStatus;
	}

	public SpQaStatus removeSpQaStatus(SpQaStatus spQaStatus) {
		getSpQaStatuses().remove(spQaStatus);
		spQaStatus.setServiceProvider(null);

		return spQaStatus;
	}

	public List<UserMapping> getUserMappings() {
		return this.userMappings;
	}

	public void setUserMappings(List<UserMapping> userMappings) {
		this.userMappings = userMappings;
	}

	public UserMapping addUserMapping(UserMapping userMapping) {
		getUserMappings().add(userMapping);
		userMapping.setServiceProvider(this);

		return userMapping;
	}

	public UserMapping removeUserMapping(UserMapping userMapping) {
		getUserMappings().remove(userMapping);
		userMapping.setServiceProvider(null);

		return userMapping;
	}

}