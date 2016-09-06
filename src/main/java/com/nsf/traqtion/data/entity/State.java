package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@Table(name="state")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="state_id")
	private String stateId;

	private String code;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="default_time_zone")
	private String defaultTimeZone;

	@Column(name="iso_coun")
	private String isoCoun;

	private String name;

	@Column(name="reg_code")
	private String regCode;

	@Column(name="state_phone_code")
	private String statePhoneCode;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientAddress
	@JsonIgnore
	@OneToMany(mappedBy="state",fetch = FetchType.LAZY)
	private List<ClientAddress> clientAddresses;

	//bi-directional many-to-one association to SpAddress
	@JsonIgnore
	@OneToMany(mappedBy="state",fetch = FetchType.LAZY)
	private List<SpAddress> spAddresses;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	//bi-directional many-to-one association to SupplierAddress
	@JsonIgnore
	@OneToMany(mappedBy="state",fetch = FetchType.LAZY)
	private List<SupplierAddress> supplierAddresses;

	public State() {
	}

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDefaultTimeZone() {
		return this.defaultTimeZone;
	}

	public void setDefaultTimeZone(String defaultTimeZone) {
		this.defaultTimeZone = defaultTimeZone;
	}

	public String getIsoCoun() {
		return this.isoCoun;
	}

	public void setIsoCoun(String isoCoun) {
		this.isoCoun = isoCoun;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegCode() {
		return this.regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getStatePhoneCode() {
		return this.statePhoneCode;
	}

	public void setStatePhoneCode(String statePhoneCode) {
		this.statePhoneCode = statePhoneCode;
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

	public List<ClientAddress> getClientAddresses() {
		return this.clientAddresses;
	}

	public void setClientAddresses(List<ClientAddress> clientAddresses) {
		this.clientAddresses = clientAddresses;
	}

	public ClientAddress addClientAddress(ClientAddress clientAddress) {
		getClientAddresses().add(clientAddress);
		clientAddress.setState(this);

		return clientAddress;
	}

	public ClientAddress removeClientAddress(ClientAddress clientAddress) {
		getClientAddresses().remove(clientAddress);
		clientAddress.setState(null);

		return clientAddress;
	}

	public List<SpAddress> getSpAddresses() {
		return this.spAddresses;
	}

	public void setSpAddresses(List<SpAddress> spAddresses) {
		this.spAddresses = spAddresses;
	}

	public SpAddress addSpAddress(SpAddress spAddress) {
		getSpAddresses().add(spAddress);
		spAddress.setState(this);

		return spAddress;
	}

	public SpAddress removeSpAddress(SpAddress spAddress) {
		getSpAddresses().remove(spAddress);
		spAddress.setState(null);

		return spAddress;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<SupplierAddress> getSupplierAddresses() {
		return this.supplierAddresses;
	}

	public void setSupplierAddresses(List<SupplierAddress> supplierAddresses) {
		this.supplierAddresses = supplierAddresses;
	}

	public SupplierAddress addSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().add(supplierAddress);
		supplierAddress.setState(this);

		return supplierAddress;
	}

	public SupplierAddress removeSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().remove(supplierAddress);
		supplierAddress.setState(null);

		return supplierAddress;
	}

}