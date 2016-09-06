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
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@Table(name="supplier")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_id")
	private Long supplierId;

	@Column(name="alternate_phone")
	private String alternatePhone;

	private String commnets;

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

	@Column(name="supplier_code")
	private String supplierCode;

	@Column(name="supplier_name")
	private String supplierName;

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
	@OneToMany(mappedBy="supplier")
	private List<BusinessRegistration> businessRegistrations;

	//bi-directional many-to-one association to SuppPaymentRegistration
	@OneToMany(mappedBy="supplier")
	private List<SuppPaymentRegistration> suppPaymentRegistrations;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;

	//bi-directional many-to-one association to SupplierAddress
	@OneToMany(mappedBy="supplier")
	private List<SupplierAddress> supplierAddresses;

	//bi-directional many-to-one association to SupplierAltCode
	@OneToMany(mappedBy="supplier")
	private List<SupplierAltCode> supplierAltCodes;

	//bi-directional many-to-one association to SupplierClientContact
	@OneToMany(mappedBy="supplier")
	private List<SupplierClientContact> supplierClientContacts;

	//bi-directional many-to-one association to SupplierContact
	@OneToMany(mappedBy="supplier")
	private List<SupplierContact> supplierContacts;

	//bi-directional many-to-one association to SupplierInsurance
	@OneToMany(mappedBy="supplier")
	private List<SupplierInsurance> supplierInsurances;

	//bi-directional many-to-one association to SupplierOrganicCert
	@OneToMany(mappedBy="supplier")
	private List<SupplierOrganicCert> supplierOrganicCerts;

	//bi-directional many-to-one association to SupplierOthrCert
	@OneToMany(mappedBy="supplier")
	private List<SupplierOthrCert> supplierOthrCerts;

	//bi-directional many-to-one association to SupplierQaStatus
	@OneToMany(mappedBy="supplier")
	private List<SupplierQaStatus> supplierQaStatuses;

	//bi-directional many-to-one association to SupplierSite
	@OneToMany(mappedBy="supplier")
	private List<SupplierSite> supplierSites;

	//bi-directional many-to-one association to SupplierSpecification
	@OneToMany(mappedBy="supplier")
	private List<SupplierSpecification> supplierSpecifications;

	//bi-directional many-to-one association to UserMapping
	@OneToMany(mappedBy="supplier")
	private List<UserMapping> userMappings;

	public Supplier() {
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
		businessRegistration.setSupplier(this);

		return businessRegistration;
	}

	public BusinessRegistration removeBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().remove(businessRegistration);
		businessRegistration.setSupplier(null);

		return businessRegistration;
	}

	public List<SuppPaymentRegistration> getSuppPaymentRegistrations() {
		return this.suppPaymentRegistrations;
	}

	public void setSuppPaymentRegistrations(List<SuppPaymentRegistration> suppPaymentRegistrations) {
		this.suppPaymentRegistrations = suppPaymentRegistrations;
	}

	public SuppPaymentRegistration addSuppPaymentRegistration(SuppPaymentRegistration suppPaymentRegistration) {
		getSuppPaymentRegistrations().add(suppPaymentRegistration);
		suppPaymentRegistration.setSupplier(this);

		return suppPaymentRegistration;
	}

	public SuppPaymentRegistration removeSuppPaymentRegistration(SuppPaymentRegistration suppPaymentRegistration) {
		getSuppPaymentRegistrations().remove(suppPaymentRegistration);
		suppPaymentRegistration.setSupplier(null);

		return suppPaymentRegistration;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<SupplierAddress> getSupplierAddresses() {
		return this.supplierAddresses;
	}

	public void setSupplierAddresses(List<SupplierAddress> supplierAddresses) {
		this.supplierAddresses = supplierAddresses;
	}

	public SupplierAddress addSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().add(supplierAddress);
		supplierAddress.setSupplier(this);

		return supplierAddress;
	}

	public SupplierAddress removeSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().remove(supplierAddress);
		supplierAddress.setSupplier(null);

		return supplierAddress;
	}

	public List<SupplierAltCode> getSupplierAltCodes() {
		return this.supplierAltCodes;
	}

	public void setSupplierAltCodes(List<SupplierAltCode> supplierAltCodes) {
		this.supplierAltCodes = supplierAltCodes;
	}

	public SupplierAltCode addSupplierAltCode(SupplierAltCode supplierAltCode) {
		getSupplierAltCodes().add(supplierAltCode);
		supplierAltCode.setSupplier(this);

		return supplierAltCode;
	}

	public SupplierAltCode removeSupplierAltCode(SupplierAltCode supplierAltCode) {
		getSupplierAltCodes().remove(supplierAltCode);
		supplierAltCode.setSupplier(null);

		return supplierAltCode;
	}

	public List<SupplierClientContact> getSupplierClientContacts() {
		return this.supplierClientContacts;
	}

	public void setSupplierClientContacts(List<SupplierClientContact> supplierClientContacts) {
		this.supplierClientContacts = supplierClientContacts;
	}

	public SupplierClientContact addSupplierClientContact(SupplierClientContact supplierClientContact) {
		getSupplierClientContacts().add(supplierClientContact);
		supplierClientContact.setSupplier(this);

		return supplierClientContact;
	}

	public SupplierClientContact removeSupplierClientContact(SupplierClientContact supplierClientContact) {
		getSupplierClientContacts().remove(supplierClientContact);
		supplierClientContact.setSupplier(null);

		return supplierClientContact;
	}

	public List<SupplierContact> getSupplierContacts() {
		return this.supplierContacts;
	}

	public void setSupplierContacts(List<SupplierContact> supplierContacts) {
		this.supplierContacts = supplierContacts;
	}

	public SupplierContact addSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().add(supplierContact);
		supplierContact.setSupplier(this);

		return supplierContact;
	}

	public SupplierContact removeSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().remove(supplierContact);
		supplierContact.setSupplier(null);

		return supplierContact;
	}

	public List<SupplierInsurance> getSupplierInsurances() {
		return this.supplierInsurances;
	}

	public void setSupplierInsurances(List<SupplierInsurance> supplierInsurances) {
		this.supplierInsurances = supplierInsurances;
	}

	public SupplierInsurance addSupplierInsurance(SupplierInsurance supplierInsurance) {
		getSupplierInsurances().add(supplierInsurance);
		supplierInsurance.setSupplier(this);

		return supplierInsurance;
	}

	public SupplierInsurance removeSupplierInsurance(SupplierInsurance supplierInsurance) {
		getSupplierInsurances().remove(supplierInsurance);
		supplierInsurance.setSupplier(null);

		return supplierInsurance;
	}

	public List<SupplierOrganicCert> getSupplierOrganicCerts() {
		return this.supplierOrganicCerts;
	}

	public void setSupplierOrganicCerts(List<SupplierOrganicCert> supplierOrganicCerts) {
		this.supplierOrganicCerts = supplierOrganicCerts;
	}

	public SupplierOrganicCert addSupplierOrganicCert(SupplierOrganicCert supplierOrganicCert) {
		getSupplierOrganicCerts().add(supplierOrganicCert);
		supplierOrganicCert.setSupplier(this);

		return supplierOrganicCert;
	}

	public SupplierOrganicCert removeSupplierOrganicCert(SupplierOrganicCert supplierOrganicCert) {
		getSupplierOrganicCerts().remove(supplierOrganicCert);
		supplierOrganicCert.setSupplier(null);

		return supplierOrganicCert;
	}

	public List<SupplierOthrCert> getSupplierOthrCerts() {
		return this.supplierOthrCerts;
	}

	public void setSupplierOthrCerts(List<SupplierOthrCert> supplierOthrCerts) {
		this.supplierOthrCerts = supplierOthrCerts;
	}

	public SupplierOthrCert addSupplierOthrCert(SupplierOthrCert supplierOthrCert) {
		getSupplierOthrCerts().add(supplierOthrCert);
		supplierOthrCert.setSupplier(this);

		return supplierOthrCert;
	}

	public SupplierOthrCert removeSupplierOthrCert(SupplierOthrCert supplierOthrCert) {
		getSupplierOthrCerts().remove(supplierOthrCert);
		supplierOthrCert.setSupplier(null);

		return supplierOthrCert;
	}

	public List<SupplierQaStatus> getSupplierQaStatuses() {
		return this.supplierQaStatuses;
	}

	public void setSupplierQaStatuses(List<SupplierQaStatus> supplierQaStatuses) {
		this.supplierQaStatuses = supplierQaStatuses;
	}

	public SupplierQaStatus addSupplierQaStatus(SupplierQaStatus supplierQaStatus) {
		getSupplierQaStatuses().add(supplierQaStatus);
		supplierQaStatus.setSupplier(this);

		return supplierQaStatus;
	}

	public SupplierQaStatus removeSupplierQaStatus(SupplierQaStatus supplierQaStatus) {
		getSupplierQaStatuses().remove(supplierQaStatus);
		supplierQaStatus.setSupplier(null);

		return supplierQaStatus;
	}

	public List<SupplierSite> getSupplierSites() {
		return this.supplierSites;
	}

	public void setSupplierSites(List<SupplierSite> supplierSites) {
		this.supplierSites = supplierSites;
	}

	public SupplierSite addSupplierSite(SupplierSite supplierSite) {
		getSupplierSites().add(supplierSite);
		supplierSite.setSupplier(this);

		return supplierSite;
	}

	public SupplierSite removeSupplierSite(SupplierSite supplierSite) {
		getSupplierSites().remove(supplierSite);
		supplierSite.setSupplier(null);

		return supplierSite;
	}

	public List<SupplierSpecification> getSupplierSpecifications() {
		return this.supplierSpecifications;
	}

	public void setSupplierSpecifications(List<SupplierSpecification> supplierSpecifications) {
		this.supplierSpecifications = supplierSpecifications;
	}

	public SupplierSpecification addSupplierSpecification(SupplierSpecification supplierSpecification) {
		getSupplierSpecifications().add(supplierSpecification);
		supplierSpecification.setSupplier(this);

		return supplierSpecification;
	}

	public SupplierSpecification removeSupplierSpecification(SupplierSpecification supplierSpecification) {
		getSupplierSpecifications().remove(supplierSpecification);
		supplierSpecification.setSupplier(null);

		return supplierSpecification;
	}

	public List<UserMapping> getUserMappings() {
		return this.userMappings;
	}

	public void setUserMappings(List<UserMapping> userMappings) {
		this.userMappings = userMappings;
	}

	public UserMapping addUserMapping(UserMapping userMapping) {
		getUserMappings().add(userMapping);
		userMapping.setSupplier(this);

		return userMapping;
	}

	public UserMapping removeUserMapping(UserMapping userMapping) {
		getUserMappings().remove(userMapping);
		userMapping.setSupplier(null);

		return userMapping;
	}

}