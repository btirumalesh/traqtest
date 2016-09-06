package com.nsf.traqtion.model.clientmgmt;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import com.nsf.traqtion.data.entity.ClientContact;


/**
 * The persistent class for the Client_contact_address database table.
 * 
 */

public class ClientContactAddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String client_contact_address_id;

	private String address1;

	private String address2;

	private String city;

	private String country;

	private BigInteger createdBy;

	private Timestamp creationDate;

	private String state;

	private BigInteger updatedBy;

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigInteger getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(BigInteger updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Timestamp updatedDate;

	private int zip;

	private ClientContact clientContact;

	public ClientContactAddressDTO() {
	}

	public String getClient_contact_address_id() {
		return this.client_contact_address_id;
	}

	public void setClient_contact_address_id(String client_contact_address_id) {
		this.client_contact_address_id = client_contact_address_id;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public ClientContact getClientContact() {
		return this.clientContact;
	}

	public void setClientContact(ClientContact clientContact) {
		this.clientContact = clientContact;
	}

}