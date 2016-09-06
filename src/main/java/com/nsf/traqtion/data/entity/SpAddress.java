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
 * The persistent class for the sp_address database table.
 * 
 */
@Entity
@Table(name="sp_address")
@NamedQuery(name="SpAddress.findAll", query="SELECT s FROM SpAddress s")
public class SpAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sp_address_id")
	private String spAddressId;

	private String address1;

	private String address2;

	private String address3;

	private String city;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="primary_address_flag")
	private String primaryAddressFlag;

	@Column(name="same_as_primary_flag")
	private String sameAsPrimaryFlag;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="zip_code")
	private int zipCode;

	//bi-directional many-to-one association to ServiceProvider
	@ManyToOne
	@JoinColumn(name="service_providers_id")
	private ServiceProvider serviceProvider;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	//bi-directional many-to-one association to TrqMasterValue
	@ManyToOne
	@JoinColumn(name="trq_master_values_id")
	private TrqMasterValue trqMasterValue;

	public SpAddress() {
	}

	public String getSpAddressId() {
		return this.spAddressId;
	}

	public void setSpAddressId(String spAddressId) {
		this.spAddressId = spAddressId;
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

	public String getPrimaryAddressFlag() {
		return this.primaryAddressFlag;
	}

	public void setPrimaryAddressFlag(String primaryAddressFlag) {
		this.primaryAddressFlag = primaryAddressFlag;
	}

	public String getSameAsPrimaryFlag() {
		return this.sameAsPrimaryFlag;
	}

	public void setSameAsPrimaryFlag(String sameAsPrimaryFlag) {
		this.sameAsPrimaryFlag = sameAsPrimaryFlag;
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

	public ServiceProvider getServiceProvider() {
		return this.serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public TrqMasterValue getTrqMasterValue() {
		return this.trqMasterValue;
	}

	public void setTrqMasterValue(TrqMasterValue trqMasterValue) {
		this.trqMasterValue = trqMasterValue;
	}

}