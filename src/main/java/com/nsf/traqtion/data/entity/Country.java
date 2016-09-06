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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private String countryId;

	private String code;

	@Column(name="country_phone_code")
	private String countryPhoneCode;

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

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientAddress
	@JsonIgnore
	@OneToMany(mappedBy="country",fetch = FetchType.LAZY)
	private List<ClientAddress> clientAddresses;

	//bi-directional many-to-one association to SpAddress
	@JsonIgnore
	@OneToMany(mappedBy="country",fetch = FetchType.LAZY)
	private List<SpAddress> spAddresses;

	//bi-directional many-to-one association to State
	@JsonIgnore
	@OneToMany(mappedBy="country",fetch = FetchType.LAZY)
	private List<State> states;

	//bi-directional many-to-one association to SupplierAddress
	@JsonIgnore
	@OneToMany(mappedBy="country",fetch = FetchType.LAZY)
	private List<SupplierAddress> supplierAddresses;

	public Country() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryPhoneCode() {
		return this.countryPhoneCode;
	}

	public void setCountryPhoneCode(String countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
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
		clientAddress.setCountry(this);

		return clientAddress;
	}

	public ClientAddress removeClientAddress(ClientAddress clientAddress) {
		getClientAddresses().remove(clientAddress);
		clientAddress.setCountry(null);

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
		spAddress.setCountry(this);

		return spAddress;
	}

	public SpAddress removeSpAddress(SpAddress spAddress) {
		getSpAddresses().remove(spAddress);
		spAddress.setCountry(null);

		return spAddress;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setCountry(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setCountry(null);

		return state;
	}

	public List<SupplierAddress> getSupplierAddresses() {
		return this.supplierAddresses;
	}

	public void setSupplierAddresses(List<SupplierAddress> supplierAddresses) {
		this.supplierAddresses = supplierAddresses;
	}

	public SupplierAddress addSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().add(supplierAddress);
		supplierAddress.setCountry(this);

		return supplierAddress;
	}

	public SupplierAddress removeSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().remove(supplierAddress);
		supplierAddress.setCountry(null);

		return supplierAddress;
	}

}