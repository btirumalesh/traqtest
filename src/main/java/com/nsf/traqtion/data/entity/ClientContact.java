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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the client_contact database table.
 * 
 */
@Entity
@Table(name="client_contact")
@NamedQueries({@NamedQuery(name="ClientContact.findAll", query="SELECT c FROM ClientContact c"),
    @NamedQuery(name="ClientContact.findByClientId", 
    query="FROM ClientContact c where c.client.clientId = :clientId AND c.clientSite.clientSitesId is NULL"),
@NamedQuery(name="ClientContact.findBySiteId", 
query="FROM ClientContact c where c.client.clientId IS NOT NULL AND c.clientSite.clientSitesId = :siteId")
})
@org.hibernate.annotations.Entity(dynamicUpdate = true,dynamicInsert=true)
public class ClientContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_contact_id")
	private Long clientContactId;

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

	//bi-directional many-to-one association to Client
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientSite
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_sites_id")
	private ClientSite clientSite;

	//bi-directional many-to-one association to ContactType
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="contact_type_id")
	private ContactType contactType;

	//bi-directional many-to-one association to JobTitle
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitleBean;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to ClientContactAddress
	//@OneToOne(mappedBy="clientContact",fetch = FetchType.LAZY)
	@JsonManagedReference
	@OneToOne(mappedBy="clientContact",cascade = CascadeType.MERGE,
	        fetch = FetchType.EAGER)
	    @JoinColumn(name="client_contact_id",referencedColumnName="client_contact_id",
	            insertable = true, updatable = true,unique=true)
	private ClientContactAddress clientContactAddresses;

	//bi-directional many-to-one association to ClientContactRole
	@JsonIgnore
	@OneToMany(mappedBy="clientContact",fetch = FetchType.LAZY)
	private List<ClientContactRole> clientContactRoles;

	//bi-directional many-to-one association to SpClientContact
	@JsonIgnore
	@OneToMany(mappedBy="clientContact",fetch = FetchType.LAZY)
	private List<SpClientContact> spClientContacts;

	//bi-directional many-to-one association to SupplierClientContact
	@JsonIgnore
	@OneToMany(mappedBy="clientContact",fetch = FetchType.LAZY)
	private List<SupplierClientContact> supplierClientContacts;

	public ClientContact() {
	}

	public Long getClientContactId() {
		return this.clientContactId;
	}

	public void setClientContactId(Long clientContactId) {
		this.clientContactId = clientContactId;
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientSite getClientSite() {
		return this.clientSite;
	}

	public void setClientSite(ClientSite clientSite) {
		this.clientSite = clientSite;
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

	public ClientContactAddress getClientContactAddresses() {
		return this.clientContactAddresses;
	}

	public void setClientContactAddresses(ClientContactAddress clientContactAddresses) {
		this.clientContactAddresses = clientContactAddresses;
	}

	public ClientContactAddress addClientContactAddress(ClientContactAddress clientContactAddress) {
		//getClientContactAddresses().add(clientContactAddress);
		clientContactAddress.setClientContact(this);
		return clientContactAddress;
	}

	public ClientContactAddress removeClientContactAddress(ClientContactAddress clientContactAddress) {
		//getClientContactAddresses().remove(clientContactAddress);
		clientContactAddress.setClientContact(null);
		return clientContactAddress;
	}

	public List<ClientContactRole> getClientContactRoles() {
		return this.clientContactRoles;
	}

	public void setClientContactRoles(List<ClientContactRole> clientContactRoles) {
		this.clientContactRoles = clientContactRoles;
	}

	public ClientContactRole addClientContactRole(ClientContactRole clientContactRole) {
		getClientContactRoles().add(clientContactRole);
		clientContactRole.setClientContact(this);

		return clientContactRole;
	}

	public ClientContactRole removeClientContactRole(ClientContactRole clientContactRole) {
		getClientContactRoles().remove(clientContactRole);
		clientContactRole.setClientContact(null);

		return clientContactRole;
	}

	public List<SpClientContact> getSpClientContacts() {
		return this.spClientContacts;
	}

	public void setSpClientContacts(List<SpClientContact> spClientContacts) {
		this.spClientContacts = spClientContacts;
	}

	public SpClientContact addSpClientContact(SpClientContact spClientContact) {
		getSpClientContacts().add(spClientContact);
		spClientContact.setClientContact(this);

		return spClientContact;
	}

	public SpClientContact removeSpClientContact(SpClientContact spClientContact) {
		getSpClientContacts().remove(spClientContact);
		spClientContact.setClientContact(null);

		return spClientContact;
	}

	public List<SupplierClientContact> getSupplierClientContacts() {
		return this.supplierClientContacts;
	}

	public void setSupplierClientContacts(List<SupplierClientContact> supplierClientContacts) {
		this.supplierClientContacts = supplierClientContacts;
	}

	public SupplierClientContact addSupplierClientContact(SupplierClientContact supplierClientContact) {
		getSupplierClientContacts().add(supplierClientContact);
		supplierClientContact.setClientContact(this);

		return supplierClientContact;
	}

	public SupplierClientContact removeSupplierClientContact(SupplierClientContact supplierClientContact) {
		getSupplierClientContacts().remove(supplierClientContact);
		supplierClientContact.setClientContact(null);

		return supplierClientContact;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientContactId == null) ? 0 : clientContactId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientContact other = (ClientContact) obj;
        if (clientContactId == null) {
            if (other.clientContactId != null)
                return false;
        } else if (!clientContactId.equals(other.clientContactId))
            return false;
        return true;
    }

	
}