package com.nsf.traqtion.model.clientmgmt;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientContactAddress;
import com.nsf.traqtion.data.entity.ClientContactRole;
import com.nsf.traqtion.data.entity.ClientSite;
import com.nsf.traqtion.data.entity.ContactType;
import com.nsf.traqtion.data.entity.JobTitle;
import com.nsf.traqtion.data.entity.Role;
import com.nsf.traqtion.data.entity.SpClientContact;
import com.nsf.traqtion.data.entity.SupplierClientContact;

/**
 * The persistent class for the client_contact database table.
 * 
 */

public class ClientContactDTO implements Serializable {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    public void setClientContactId(Long clientContactId) {
        this.clientContactId = clientContactId;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrimaryAddrFlag() {
        return primaryAddrFlag;
    }

    public void setPrimaryAddrFlag(String primaryAddrFlag) {
        this.primaryAddrFlag = primaryAddrFlag;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getTraqUserFlag() {
        return traqUserFlag;
    }

    public void setTraqUserFlag(String traqUserFlag) {
        this.traqUserFlag = traqUserFlag;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientSite getClientSite() {
        return clientSite;
    }

    public void setClientSite(ClientSite clientSite) {
        this.clientSite = clientSite;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public JobTitle getJobTitleBean() {
        return jobTitleBean;
    }

    public void setJobTitleBean(JobTitle jobTitleBean) {
        this.jobTitleBean = jobTitleBean;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ClientContactAddress getClientContactAddresses() {
        return clientContactAddresses;
    }

    public void setClientContactAddresses(ClientContactAddress clientContactAddresses) {
        this.clientContactAddresses = clientContactAddresses;
    }

    public List<ClientContactRole> getClientContactRoles() {
        return clientContactRoles;
    }

    public void setClientContactRoles(List<ClientContactRole> clientContactRoles) {
        this.clientContactRoles = clientContactRoles;
    }

    public List<SpClientContact> getSpClientContacts() {
        return spClientContacts;
    }

    public void setSpClientContacts(List<SpClientContact> spClientContacts) {
        this.spClientContacts = spClientContacts;
    }

    public List<SupplierClientContact> getSupplierClientContacts() {
        return supplierClientContacts;
    }

    public void setSupplierClientContacts(List<SupplierClientContact> supplierClientContacts) {
        this.supplierClientContacts = supplierClientContacts;
    }

    private Long clientContactId;

    private String alternatePhone;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String comments;

    private Long createdBy;

    private Timestamp creationDate;

    private String emailId;

    private String fax;

    private String firstName;

    private String jobTitle;

    @Column(name = "last_name")
    private String lastName;

    private String middleName;

    private String prefix;

    private String primaryAddrFlag;

    private String primaryPhone;

    private String traqUserFlag;

    private Long updatedBy;

    private Timestamp updatedDate;

    private Client client;

    private ClientSite clientSite;

    private ContactType contactType;

    private JobTitle jobTitleBean;

    private Role role;

    private ClientContactAddress clientContactAddresses;

    private List<ClientContactRole> clientContactRoles;

    private List<SpClientContact> spClientContacts;

    private List<SupplierClientContact> supplierClientContacts;

    public Long getClientContactId() {
        return clientContactId;
    }
    
    
}