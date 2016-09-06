package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the client_contact_address database table.
 * 
 */
@Entity
@Table(name="client_contact_address")
@NamedQuery(name="ClientContactAddress.findAll", query="SELECT c FROM ClientContactAddress c")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class ClientContactAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_contact_address_id")
	private Long clientContactAddressId;

	private String address1;

	private String address2;

	private String address3;

	private String city;

	@Column(name="country_id")
	private Long countryId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="state_id")
	private Long stateId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="zip_code")
	private int zipCode;

	//bi-directional many-to-one association to ClientContact
	//@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="client_contact_id")
	@JsonBackReference
    @OneToOne(cascade = CascadeType.MERGE,  
    fetch = FetchType.EAGER)
    @JoinColumn(name="client_contact_id",referencedColumnName="client_contact_id" 
    , nullable=false,unique=true)
	private ClientContact clientContact;

	public ClientContactAddress() {
	}

	public Long getClientContactAddressId() {
		return this.clientContactAddressId;
	}

	public void setClientContactAddressId(Long clientContactAddressId) {
		this.clientContactAddressId = clientContactAddressId;
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

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
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

	public ClientContact getClientContact() {
		return this.clientContact;
	}

	public void setClientContact(ClientContact clientContact) {
		this.clientContact = clientContact;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientContactAddressId == null) ? 0 : clientContactAddressId.hashCode());
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
        ClientContactAddress other = (ClientContactAddress) obj;
        if (clientContactAddressId == null) {
            if (other.clientContactAddressId != null)
                return false;
        } else if (!clientContactAddressId.equals(other.clientContactAddressId))
            return false;
        return true;
    }
	
	

}