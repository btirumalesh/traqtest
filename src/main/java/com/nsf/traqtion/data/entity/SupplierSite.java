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
 * The persistent class for the supplier_sites database table.
 * 
 */
@Entity
@Table(name="supplier_sites")
@NamedQuery(name="SupplierSite.findAll", query="SELECT s FROM SupplierSite s")
public class SupplierSite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_sites_id")
	private Long supplierSitesId;

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

	@Column(name="primary_phone")
	private String primaryPhone;

	@Column(name="same_as_corp_flag")
	private String sameAsCorpFlag;

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

	@Column(name="zip_code")
	private int zipCode;

	//bi-directional many-to-one association to SuppSiteAltCode
	@OneToMany(mappedBy="supplierSite")
	private List<SuppSiteAltCode> suppSiteAltCodes;

	//bi-directional many-to-one association to SuppSiteAttachment
	@OneToMany(mappedBy="supplierSite")
	private List<SuppSiteAttachment> suppSiteAttachments;

	//bi-directional many-to-one association to SuppSiteInsurance
	@OneToMany(mappedBy="supplierSite")
	private List<SuppSiteInsurance> suppSiteInsurances;

	//bi-directional many-to-one association to SuppSiteOrganicCert
	@OneToMany(mappedBy="supplierSite")
	private List<SuppSiteOrganicCert> suppSiteOrganicCerts;

	//bi-directional many-to-one association to SuppSiteOthrCert
	@OneToMany(mappedBy="supplierSite")
	private List<SuppSiteOthrCert> suppSiteOthrCerts;

	//bi-directional many-to-one association to SuppSiteQaStatus
	@OneToMany(mappedBy="supplierSite")
	private List<SuppSiteQaStatus> suppSiteQaStatuses;

	//bi-directional many-to-one association to SupplierContact
	@OneToMany(mappedBy="supplierSite")
	private List<SupplierContact> supplierContacts;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	//bi-directional many-to-one association to UserSuppSite
	@OneToMany(mappedBy="supplierSite")
	private List<UserSuppSite> userSuppSites;

	public SupplierSite() {
	}

	public Long getSupplierSitesId() {
		return this.supplierSitesId;
	}

	public void setSupplierSitesId(Long supplierSitesId) {
		this.supplierSitesId = supplierSitesId;
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

	public String getPrimaryPhone() {
		return this.primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSameAsCorpFlag() {
		return this.sameAsCorpFlag;
	}

	public void setSameAsCorpFlag(String sameAsCorpFlag) {
		this.sameAsCorpFlag = sameAsCorpFlag;
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

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public List<SuppSiteAltCode> getSuppSiteAltCodes() {
		return this.suppSiteAltCodes;
	}

	public void setSuppSiteAltCodes(List<SuppSiteAltCode> suppSiteAltCodes) {
		this.suppSiteAltCodes = suppSiteAltCodes;
	}

	public SuppSiteAltCode addSuppSiteAltCode(SuppSiteAltCode suppSiteAltCode) {
		getSuppSiteAltCodes().add(suppSiteAltCode);
		suppSiteAltCode.setSupplierSite(this);

		return suppSiteAltCode;
	}

	public SuppSiteAltCode removeSuppSiteAltCode(SuppSiteAltCode suppSiteAltCode) {
		getSuppSiteAltCodes().remove(suppSiteAltCode);
		suppSiteAltCode.setSupplierSite(null);

		return suppSiteAltCode;
	}

	public List<SuppSiteAttachment> getSuppSiteAttachments() {
		return this.suppSiteAttachments;
	}

	public void setSuppSiteAttachments(List<SuppSiteAttachment> suppSiteAttachments) {
		this.suppSiteAttachments = suppSiteAttachments;
	}

	public SuppSiteAttachment addSuppSiteAttachment(SuppSiteAttachment suppSiteAttachment) {
		getSuppSiteAttachments().add(suppSiteAttachment);
		suppSiteAttachment.setSupplierSite(this);

		return suppSiteAttachment;
	}

	public SuppSiteAttachment removeSuppSiteAttachment(SuppSiteAttachment suppSiteAttachment) {
		getSuppSiteAttachments().remove(suppSiteAttachment);
		suppSiteAttachment.setSupplierSite(null);

		return suppSiteAttachment;
	}

	public List<SuppSiteInsurance> getSuppSiteInsurances() {
		return this.suppSiteInsurances;
	}

	public void setSuppSiteInsurances(List<SuppSiteInsurance> suppSiteInsurances) {
		this.suppSiteInsurances = suppSiteInsurances;
	}

	public SuppSiteInsurance addSuppSiteInsurance(SuppSiteInsurance suppSiteInsurance) {
		getSuppSiteInsurances().add(suppSiteInsurance);
		suppSiteInsurance.setSupplierSite(this);

		return suppSiteInsurance;
	}

	public SuppSiteInsurance removeSuppSiteInsurance(SuppSiteInsurance suppSiteInsurance) {
		getSuppSiteInsurances().remove(suppSiteInsurance);
		suppSiteInsurance.setSupplierSite(null);

		return suppSiteInsurance;
	}

	public List<SuppSiteOrganicCert> getSuppSiteOrganicCerts() {
		return this.suppSiteOrganicCerts;
	}

	public void setSuppSiteOrganicCerts(List<SuppSiteOrganicCert> suppSiteOrganicCerts) {
		this.suppSiteOrganicCerts = suppSiteOrganicCerts;
	}

	public SuppSiteOrganicCert addSuppSiteOrganicCert(SuppSiteOrganicCert suppSiteOrganicCert) {
		getSuppSiteOrganicCerts().add(suppSiteOrganicCert);
		suppSiteOrganicCert.setSupplierSite(this);

		return suppSiteOrganicCert;
	}

	public SuppSiteOrganicCert removeSuppSiteOrganicCert(SuppSiteOrganicCert suppSiteOrganicCert) {
		getSuppSiteOrganicCerts().remove(suppSiteOrganicCert);
		suppSiteOrganicCert.setSupplierSite(null);

		return suppSiteOrganicCert;
	}

	public List<SuppSiteOthrCert> getSuppSiteOthrCerts() {
		return this.suppSiteOthrCerts;
	}

	public void setSuppSiteOthrCerts(List<SuppSiteOthrCert> suppSiteOthrCerts) {
		this.suppSiteOthrCerts = suppSiteOthrCerts;
	}

	public SuppSiteOthrCert addSuppSiteOthrCert(SuppSiteOthrCert suppSiteOthrCert) {
		getSuppSiteOthrCerts().add(suppSiteOthrCert);
		suppSiteOthrCert.setSupplierSite(this);

		return suppSiteOthrCert;
	}

	public SuppSiteOthrCert removeSuppSiteOthrCert(SuppSiteOthrCert suppSiteOthrCert) {
		getSuppSiteOthrCerts().remove(suppSiteOthrCert);
		suppSiteOthrCert.setSupplierSite(null);

		return suppSiteOthrCert;
	}

	public List<SuppSiteQaStatus> getSuppSiteQaStatuses() {
		return this.suppSiteQaStatuses;
	}

	public void setSuppSiteQaStatuses(List<SuppSiteQaStatus> suppSiteQaStatuses) {
		this.suppSiteQaStatuses = suppSiteQaStatuses;
	}

	public SuppSiteQaStatus addSuppSiteQaStatus(SuppSiteQaStatus suppSiteQaStatus) {
		getSuppSiteQaStatuses().add(suppSiteQaStatus);
		suppSiteQaStatus.setSupplierSite(this);

		return suppSiteQaStatus;
	}

	public SuppSiteQaStatus removeSuppSiteQaStatus(SuppSiteQaStatus suppSiteQaStatus) {
		getSuppSiteQaStatuses().remove(suppSiteQaStatus);
		suppSiteQaStatus.setSupplierSite(null);

		return suppSiteQaStatus;
	}

	public List<SupplierContact> getSupplierContacts() {
		return this.supplierContacts;
	}

	public void setSupplierContacts(List<SupplierContact> supplierContacts) {
		this.supplierContacts = supplierContacts;
	}

	public SupplierContact addSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().add(supplierContact);
		supplierContact.setSupplierSite(this);

		return supplierContact;
	}

	public SupplierContact removeSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().remove(supplierContact);
		supplierContact.setSupplierSite(null);

		return supplierContact;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<UserSuppSite> getUserSuppSites() {
		return this.userSuppSites;
	}

	public void setUserSuppSites(List<UserSuppSite> userSuppSites) {
		this.userSuppSites = userSuppSites;
	}

	public UserSuppSite addUserSuppSite(UserSuppSite userSuppSite) {
		getUserSuppSites().add(userSuppSite);
		userSuppSite.setSupplierSite(this);

		return userSuppSite;
	}

	public UserSuppSite removeUserSuppSite(UserSuppSite userSuppSite) {
		getUserSuppSites().remove(userSuppSite);
		userSuppSite.setSupplierSite(null);

		return userSuppSite;
	}

}