package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.FetchProfile.FetchOverride;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the client database table.
 * 
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private Long clientId;

	@Column(name="alternate_phone")
	private String alternatePhone;

	private String attribute1;

	private String attribute2;

	private String attribute3;

	private String attribute4;

	private String attribute5;

	private String attribute6;

	private String attribute7;

	private String attribute8;

	private String attribute9;

	@Column(name="business_group")
	private String businessGroup;

	private String commnets;

	@Column(name="company_code")
	private String companyCode;

	@Column(name="company_name")
	private String companyName;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="corporate_parent_name")
	private String corporateParentName;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="email_address")
	private String emailAddress;

	private String fax;

	@Column(name="payment_plan")
	private String paymentPlan;

	@Column(name="primary_phone")
	private String primaryPhone;

	@Column(name="self_reg_link")
	private String selfRegLink;

	private String store;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="web_address")
	private String webAddress;

	//bi-directional many-to-one association to BusinessRegistration
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<BusinessRegistration> businessRegistrations;

	//bi-directional many-to-one association to Language
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="languages_id")
	private Language language;

	//bi-directional many-to-one association to Timezone
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="timezone_id")
	private Timezone timezone;

	//bi-directional many-to-one association to ClientAddress
	
	@JsonManagedReference
	@OneToOne(mappedBy="client",cascade = CascadeType.ALL, optional = true, 
	    fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="client_id",referencedColumnName="client_id",
	        insertable = false, updatable = true)
	//@Column(insertable = true, updatable = true)
	private ClientAddress clientAddresses;

	//bi-directional many-to-one association to ClientBusiness
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientBusiness> clientBusinesses;

	//bi-directional many-to-one association to ClientBusinessCategory
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientBusinessCategory> clientBusinessCategories;

	//bi-directional many-to-one association to ClientCategory
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientCategory> clientCategories;

	//bi-directional many-to-one association to ClientContact
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientContact> clientContacts;

	//bi-directional many-to-one association to ClientDocument
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientDocument> clientDocuments;

	//bi-directional many-to-one association to ClientDocumentType
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientDocumentType> clientDocumentTypes;

	//bi-directional many-to-one association to ClientEmailTemplate
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientEmailTemplate> clientEmailTemplates;

	//bi-directional many-to-one association to ClientFacilityType
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientFacilityType> clientFacilityTypes;

	//bi-directional many-to-one association to ClientLanguage
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientLanguage> clientLanguages;

	//bi-directional many-to-one association to ClientRegQuestion
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientRegQuestion> clientRegQuestions;

	//bi-directional many-to-one association to ClientSite
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientSite> clientSites;

	//bi-directional many-to-one association to ClientSpecType
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ClientSpecType> clientSpecTypes;

	//bi-directional many-to-one association to PrimarySpecification
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<PrimarySpecification> primarySpecifications;

	//bi-directional many-to-one association to ProductClientAssociation
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ProductClientAssociation> productClientAssociations;

	//bi-directional many-to-one association to ServiceProvider
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<ServiceProvider> serviceProviders;

	//bi-directional many-to-one association to SuppPaymentRegistration
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<SuppPaymentRegistration> suppPaymentRegistrations;

	//bi-directional many-to-one association to Supplier
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<Supplier> suppliers;

	//bi-directional many-to-one association to UserBusinessCategory
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<UserBusinessCategory> userBusinessCategories;

	//bi-directional many-to-one association to UserMapping
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	private List<UserMapping> userMappings;

	public Client() {
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getAlternatePhone() {
		return this.alternatePhone;
	}

	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return this.attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return this.attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return this.attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getBusinessGroup() {
		return this.businessGroup;
	}

	public void setBusinessGroup(String businessGroup) {
		this.businessGroup = businessGroup;
	}

	public String getCommnets() {
		return this.commnets;
	}

	public void setCommnets(String commnets) {
		this.commnets = commnets;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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

	public String getCorporateParentName() {
		return this.corporateParentName;
	}

	public void setCorporateParentName(String corporateParentName) {
		this.corporateParentName = corporateParentName;
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

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPaymentPlan() {
		return this.paymentPlan;
	}

	public void setPaymentPlan(String paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public String getPrimaryPhone() {
		return this.primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSelfRegLink() {
		return this.selfRegLink;
	}

	public void setSelfRegLink(String selfRegLink) {
		this.selfRegLink = selfRegLink;
	}

	public String getStore() {
		return this.store;
	}

	public void setStore(String store) {
		this.store = store;
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
		businessRegistration.setClient(this);

		return businessRegistration;
	}

	public BusinessRegistration removeBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().remove(businessRegistration);
		businessRegistration.setClient(null);

		return businessRegistration;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Timezone getTimezone() {
		return this.timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}

	public ClientAddress getClientAddresses() {
		return this.clientAddresses;
	}

	public void setClientAddresses(ClientAddress clientAddresses) {
		this.clientAddresses = clientAddresses;
	}

	public ClientAddress addClientAddress(ClientAddress clientAddress) {
		//getClientAddresses().add(clientAddress);
		clientAddress.setClient(this);
		return clientAddress;
	}

	public ClientAddress removeClientAddress(ClientAddress clientAddress) {
		//getClientAddresses().remove(clientAddress);
		clientAddress.setClient(null);
		return clientAddress;
	}

	public List<ClientBusiness> getClientBusinesses() {
		return this.clientBusinesses;
	}

	public void setClientBusinesses(List<ClientBusiness> clientBusinesses) {
		this.clientBusinesses = clientBusinesses;
	}

	public ClientBusiness addClientBusiness(ClientBusiness clientBusiness) {
		getClientBusinesses().add(clientBusiness);
		clientBusiness.setClient(this);

		return clientBusiness;
	}

	public ClientBusiness removeClientBusiness(ClientBusiness clientBusiness) {
		getClientBusinesses().remove(clientBusiness);
		clientBusiness.setClient(null);

		return clientBusiness;
	}

	public List<ClientBusinessCategory> getClientBusinessCategories() {
		return this.clientBusinessCategories;
	}

	public void setClientBusinessCategories(List<ClientBusinessCategory> clientBusinessCategories) {
		this.clientBusinessCategories = clientBusinessCategories;
	}

	public ClientBusinessCategory addClientBusinessCategory(ClientBusinessCategory clientBusinessCategory) {
		getClientBusinessCategories().add(clientBusinessCategory);
		clientBusinessCategory.setClient(this);

		return clientBusinessCategory;
	}

	public ClientBusinessCategory removeClientBusinessCategory(ClientBusinessCategory clientBusinessCategory) {
		getClientBusinessCategories().remove(clientBusinessCategory);
		clientBusinessCategory.setClient(null);

		return clientBusinessCategory;
	}

	public List<ClientCategory> getClientCategories() {
		return this.clientCategories;
	}

	public void setClientCategories(List<ClientCategory> clientCategories) {
		this.clientCategories = clientCategories;
	}

	public ClientCategory addClientCategory(ClientCategory clientCategory) {
		getClientCategories().add(clientCategory);
		clientCategory.setClient(this);

		return clientCategory;
	}

	public ClientCategory removeClientCategory(ClientCategory clientCategory) {
		getClientCategories().remove(clientCategory);
		clientCategory.setClient(null);

		return clientCategory;
	}

	public List<ClientContact> getClientContacts() {
		return this.clientContacts;
	}

	public void setClientContacts(List<ClientContact> clientContacts) {
		this.clientContacts = clientContacts;
	}

	public ClientContact addClientContact(ClientContact clientContact) {
		getClientContacts().add(clientContact);
		clientContact.setClient(this);

		return clientContact;
	}

	public ClientContact removeClientContact(ClientContact clientContact) {
		getClientContacts().remove(clientContact);
		clientContact.setClient(null);

		return clientContact;
	}

	public List<ClientDocument> getClientDocuments() {
		return this.clientDocuments;
	}

	public void setClientDocuments(List<ClientDocument> clientDocuments) {
		this.clientDocuments = clientDocuments;
	}

	public ClientDocument addClientDocument(ClientDocument clientDocument) {
		getClientDocuments().add(clientDocument);
		clientDocument.setClient(this);

		return clientDocument;
	}

	public ClientDocument removeClientDocument(ClientDocument clientDocument) {
		getClientDocuments().remove(clientDocument);
		clientDocument.setClient(null);

		return clientDocument;
	}

	public List<ClientDocumentType> getClientDocumentTypes() {
		return this.clientDocumentTypes;
	}

	public void setClientDocumentTypes(List<ClientDocumentType> clientDocumentTypes) {
		this.clientDocumentTypes = clientDocumentTypes;
	}

	public ClientDocumentType addClientDocumentType(ClientDocumentType clientDocumentType) {
		getClientDocumentTypes().add(clientDocumentType);
		clientDocumentType.setClient(this);

		return clientDocumentType;
	}

	public ClientDocumentType removeClientDocumentType(ClientDocumentType clientDocumentType) {
		getClientDocumentTypes().remove(clientDocumentType);
		clientDocumentType.setClient(null);

		return clientDocumentType;
	}

	public List<ClientEmailTemplate> getClientEmailTemplates() {
		return this.clientEmailTemplates;
	}

	public void setClientEmailTemplates(List<ClientEmailTemplate> clientEmailTemplates) {
		this.clientEmailTemplates = clientEmailTemplates;
	}

	public ClientEmailTemplate addClientEmailTemplate(ClientEmailTemplate clientEmailTemplate) {
		getClientEmailTemplates().add(clientEmailTemplate);
		clientEmailTemplate.setClient(this);

		return clientEmailTemplate;
	}

	public ClientEmailTemplate removeClientEmailTemplate(ClientEmailTemplate clientEmailTemplate) {
		getClientEmailTemplates().remove(clientEmailTemplate);
		clientEmailTemplate.setClient(null);

		return clientEmailTemplate;
	}

	public List<ClientFacilityType> getClientFacilityTypes() {
		return this.clientFacilityTypes;
	}

	public void setClientFacilityTypes(List<ClientFacilityType> clientFacilityTypes) {
		this.clientFacilityTypes = clientFacilityTypes;
	}

	public ClientFacilityType addClientFacilityType(ClientFacilityType clientFacilityType) {
		getClientFacilityTypes().add(clientFacilityType);
		clientFacilityType.setClient(this);

		return clientFacilityType;
	}

	public ClientFacilityType removeClientFacilityType(ClientFacilityType clientFacilityType) {
		getClientFacilityTypes().remove(clientFacilityType);
		clientFacilityType.setClient(null);

		return clientFacilityType;
	}

	public List<ClientLanguage> getClientLanguages() {
		return this.clientLanguages;
	}

	public void setClientLanguages(List<ClientLanguage> clientLanguages) {
		this.clientLanguages = clientLanguages;
	}

	public ClientLanguage addClientLanguage(ClientLanguage clientLanguage) {
		getClientLanguages().add(clientLanguage);
		clientLanguage.setClient(this);

		return clientLanguage;
	}

	public ClientLanguage removeClientLanguage(ClientLanguage clientLanguage) {
		getClientLanguages().remove(clientLanguage);
		clientLanguage.setClient(null);

		return clientLanguage;
	}

	public List<ClientRegQuestion> getClientRegQuestions() {
		return this.clientRegQuestions;
	}

	public void setClientRegQuestions(List<ClientRegQuestion> clientRegQuestions) {
		this.clientRegQuestions = clientRegQuestions;
	}

	public ClientRegQuestion addClientRegQuestion(ClientRegQuestion clientRegQuestion) {
		getClientRegQuestions().add(clientRegQuestion);
		clientRegQuestion.setClient(this);

		return clientRegQuestion;
	}

	public ClientRegQuestion removeClientRegQuestion(ClientRegQuestion clientRegQuestion) {
		getClientRegQuestions().remove(clientRegQuestion);
		clientRegQuestion.setClient(null);

		return clientRegQuestion;
	}

	public List<ClientSite> getClientSites() {
		return this.clientSites;
	}

	public void setClientSites(List<ClientSite> clientSites) {
		this.clientSites = clientSites;
	}

	public ClientSite addClientSite(ClientSite clientSite) {
		getClientSites().add(clientSite);
		clientSite.setClient(this);

		return clientSite;
	}

	public ClientSite removeClientSite(ClientSite clientSite) {
		getClientSites().remove(clientSite);
		clientSite.setClient(null);

		return clientSite;
	}

	public List<ClientSpecType> getClientSpecTypes() {
		return this.clientSpecTypes;
	}

	public void setClientSpecTypes(List<ClientSpecType> clientSpecTypes) {
		this.clientSpecTypes = clientSpecTypes;
	}

	public ClientSpecType addClientSpecType(ClientSpecType clientSpecType) {
		getClientSpecTypes().add(clientSpecType);
		clientSpecType.setClient(this);

		return clientSpecType;
	}

	public ClientSpecType removeClientSpecType(ClientSpecType clientSpecType) {
		getClientSpecTypes().remove(clientSpecType);
		clientSpecType.setClient(null);

		return clientSpecType;
	}

	public List<PrimarySpecification> getPrimarySpecifications() {
		return this.primarySpecifications;
	}

	public void setPrimarySpecifications(List<PrimarySpecification> primarySpecifications) {
		this.primarySpecifications = primarySpecifications;
	}

	public PrimarySpecification addPrimarySpecification(PrimarySpecification primarySpecification) {
		getPrimarySpecifications().add(primarySpecification);
		primarySpecification.setClient(this);

		return primarySpecification;
	}

	public PrimarySpecification removePrimarySpecification(PrimarySpecification primarySpecification) {
		getPrimarySpecifications().remove(primarySpecification);
		primarySpecification.setClient(null);

		return primarySpecification;
	}

	public List<ProductClientAssociation> getProductClientAssociations() {
		return this.productClientAssociations;
	}

	public void setProductClientAssociations(List<ProductClientAssociation> productClientAssociations) {
		this.productClientAssociations = productClientAssociations;
	}

	public ProductClientAssociation addProductClientAssociation(ProductClientAssociation productClientAssociation) {
		getProductClientAssociations().add(productClientAssociation);
		productClientAssociation.setClient(this);

		return productClientAssociation;
	}

	public ProductClientAssociation removeProductClientAssociation(ProductClientAssociation productClientAssociation) {
		getProductClientAssociations().remove(productClientAssociation);
		productClientAssociation.setClient(null);

		return productClientAssociation;
	}

	public List<ServiceProvider> getServiceProviders() {
		return this.serviceProviders;
	}

	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		getServiceProviders().add(serviceProvider);
		serviceProvider.setClient(this);

		return serviceProvider;
	}

	public ServiceProvider removeServiceProvider(ServiceProvider serviceProvider) {
		getServiceProviders().remove(serviceProvider);
		serviceProvider.setClient(null);

		return serviceProvider;
	}

	public List<SuppPaymentRegistration> getSuppPaymentRegistrations() {
		return this.suppPaymentRegistrations;
	}

	public void setSuppPaymentRegistrations(List<SuppPaymentRegistration> suppPaymentRegistrations) {
		this.suppPaymentRegistrations = suppPaymentRegistrations;
	}

	public SuppPaymentRegistration addSuppPaymentRegistration(SuppPaymentRegistration suppPaymentRegistration) {
		getSuppPaymentRegistrations().add(suppPaymentRegistration);
		suppPaymentRegistration.setClient(this);

		return suppPaymentRegistration;
	}

	public SuppPaymentRegistration removeSuppPaymentRegistration(SuppPaymentRegistration suppPaymentRegistration) {
		getSuppPaymentRegistrations().remove(suppPaymentRegistration);
		suppPaymentRegistration.setClient(null);

		return suppPaymentRegistration;
	}

	public List<Supplier> getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier addSupplier(Supplier supplier) {
		getSuppliers().add(supplier);
		supplier.setClient(this);

		return supplier;
	}

	public Supplier removeSupplier(Supplier supplier) {
		getSuppliers().remove(supplier);
		supplier.setClient(null);

		return supplier;
	}

	public List<UserBusinessCategory> getUserBusinessCategories() {
		return this.userBusinessCategories;
	}

	public void setUserBusinessCategories(List<UserBusinessCategory> userBusinessCategories) {
		this.userBusinessCategories = userBusinessCategories;
	}

	public UserBusinessCategory addUserBusinessCategory(UserBusinessCategory userBusinessCategory) {
		getUserBusinessCategories().add(userBusinessCategory);
		userBusinessCategory.setClient(this);

		return userBusinessCategory;
	}

	public UserBusinessCategory removeUserBusinessCategory(UserBusinessCategory userBusinessCategory) {
		getUserBusinessCategories().remove(userBusinessCategory);
		userBusinessCategory.setClient(null);

		return userBusinessCategory;
	}

	public List<UserMapping> getUserMappings() {
		return this.userMappings;
	}

	public void setUserMappings(List<UserMapping> userMappings) {
		this.userMappings = userMappings;
	}

	public UserMapping addUserMapping(UserMapping userMapping) {
		getUserMappings().add(userMapping);
		userMapping.setClient(this);

		return userMapping;
	}

	public UserMapping removeUserMapping(UserMapping userMapping) {
		getUserMappings().remove(userMapping);
		userMapping.setClient(null);

		return userMapping;
	}

}