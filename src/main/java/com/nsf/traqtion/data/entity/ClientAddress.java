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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the client_address database table.
 * 
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name="client_address")
@NamedQueries({
    @NamedQuery(name="ClientAddress.findAll", query="SELECT c FROM ClientAddress c"),
    @NamedQuery(name="ClientAddress.findByClientId",
                query="SELECT c FROM ClientDocument c WHERE c.client.clientId = :clientId"),
}) 
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class ClientAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_address_id")
	private Long clientAddressId;

	private String address1;

	private String address2;

	private String address3;

	private String city;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="zip_code")
	private int zipCode;

	//bi-directional one-to-one association to Client
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL, optional = true, 
	fetch = FetchType.EAGER, orphanRemoval = false)
    @JoinColumn(name="client_id",referencedColumnName="client_id" , nullable=false)
	private Client client;

	//bi-directional many-to-one association to State
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="state_id")
	private State state;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="country_id")
	private Country country;

	public ClientAddress() {
	}

	public Long getClientAddressId() {
		return this.clientAddressId;
	}

	public void setClientAddressId(Long clientAddressId) {
		this.clientAddressId = clientAddressId;
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
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

}