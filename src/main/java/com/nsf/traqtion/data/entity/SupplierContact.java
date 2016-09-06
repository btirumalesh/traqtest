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
 * The persistent class for the supplier_contact database table.
 * 
 */
@Entity
@Table(name="supplier_contact")
@NamedQuery(name="SupplierContact.findAll", query="SELECT s FROM SupplierContact s")
public class SupplierContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_contact_id")
	private String supplierContactId;

	@Column(name="alternate_phone")
	private String alternatePhone;

	private String attribute1;

	private String attribute2;

	private String attribute3;

	private String attribute4;

	private String attribute5;

	private String comments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="email_id")
	private String emailId;

	private String fax;

	@Column(name="first_name")
	private String firstName;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	private String prefix;

	@Column(name="primary_addr_flag")
	private String primaryAddrFlag;

	@Column(name="primary_phone")
	private String primaryPhone;

	@Column(name="traq_user_flag")
	private String traqUserFlag;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	//bi-directional many-to-one association to SupplierSite
	@ManyToOne
	@JoinColumn(name="supplier_sites_id")
	private SupplierSite supplierSite;

	//bi-directional many-to-one association to ContactType
	@ManyToOne
	@JoinColumn(name="contact_type_id")
	private ContactType contactType;

	//bi-directional many-to-one association to JobTitle
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitleBean;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to SupplierContactAddress
	@OneToMany(mappedBy="supplierContact")
	private List<SupplierContactAddress> supplierContactAddresses;

	//bi-directional many-to-one association to SupplierContactRole
	@OneToMany(mappedBy="supplierContact")
	private List<SupplierContactRole> supplierContactRoles;

	public SupplierContact() {
	}

	public String getSupplierContactId() {
		return this.supplierContactId;
	}

	public void setSupplierContactId(String supplierContactId) {
		this.supplierContactId = supplierContactId;
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPrimaryAddrFlag() {
		return this.primaryAddrFlag;
	}

	public void setPrimaryAddrFlag(String primaryAddrFlag) {
		this.primaryAddrFlag = primaryAddrFlag;
	}

	public String getPrimaryPhone() {
		return this.primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getTraqUserFlag() {
		return this.traqUserFlag;
	}

	public void setTraqUserFlag(String traqUserFlag) {
		this.traqUserFlag = traqUserFlag;
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

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public SupplierSite getSupplierSite() {
		return this.supplierSite;
	}

	public void setSupplierSite(SupplierSite supplierSite) {
		this.supplierSite = supplierSite;
	}

	public ContactType getContactType() {
		return this.contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public JobTitle getJobTitleBean() {
		return this.jobTitleBean;
	}

	public void setJobTitleBean(JobTitle jobTitleBean) {
		this.jobTitleBean = jobTitleBean;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<SupplierContactAddress> getSupplierContactAddresses() {
		return this.supplierContactAddresses;
	}

	public void setSupplierContactAddresses(List<SupplierContactAddress> supplierContactAddresses) {
		this.supplierContactAddresses = supplierContactAddresses;
	}

	public SupplierContactAddress addSupplierContactAddress(SupplierContactAddress supplierContactAddress) {
		getSupplierContactAddresses().add(supplierContactAddress);
		supplierContactAddress.setSupplierContact(this);

		return supplierContactAddress;
	}

	public SupplierContactAddress removeSupplierContactAddress(SupplierContactAddress supplierContactAddress) {
		getSupplierContactAddresses().remove(supplierContactAddress);
		supplierContactAddress.setSupplierContact(null);

		return supplierContactAddress;
	}

	public List<SupplierContactRole> getSupplierContactRoles() {
		return this.supplierContactRoles;
	}

	public void setSupplierContactRoles(List<SupplierContactRole> supplierContactRoles) {
		this.supplierContactRoles = supplierContactRoles;
	}

	public SupplierContactRole addSupplierContactRole(SupplierContactRole supplierContactRole) {
		getSupplierContactRoles().add(supplierContactRole);
		supplierContactRole.setSupplierContact(this);

		return supplierContactRole;
	}

	public SupplierContactRole removeSupplierContactRole(SupplierContactRole supplierContactRole) {
		getSupplierContactRoles().remove(supplierContactRole);
		supplierContactRole.setSupplierContact(null);

		return supplierContactRole;
	}

}