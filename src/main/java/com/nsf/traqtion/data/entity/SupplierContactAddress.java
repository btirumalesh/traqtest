package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the supplier_contact_address database table.
 * 
 */
@Entity
@Table(name="supplier_contact_address")
@NamedQuery(name="SupplierContactAddress.findAll", query="SELECT s FROM SupplierContactAddress s")
public class SupplierContactAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_contact_address_id")
	private String supplierContactAddressId;

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

	//bi-directional many-to-one association to SupplierContact
	@ManyToOne
	@JoinColumn(name="supplier_contact_id")
	private SupplierContact supplierContact;

	public SupplierContactAddress() {
	}

	public String getSupplierContactAddressId() {
		return this.supplierContactAddressId;
	}

	public void setSupplierContactAddressId(String supplierContactAddressId) {
		this.supplierContactAddressId = supplierContactAddressId;
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

	public SupplierContact getSupplierContact() {
		return this.supplierContact;
	}

	public void setSupplierContact(SupplierContact supplierContact) {
		this.supplierContact = supplierContact;
	}

}