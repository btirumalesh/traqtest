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
 * The persistent class for the client_business_categories database table.
 * 
 */
@Entity
@Table(name="client_business_categories")
@NamedQuery(name="ClientBusinessCategory.findAll", query="SELECT c FROM ClientBusinessCategory c")
public class ClientBusinessCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="business_categories_id")
	private String businessCategoriesId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientCategory
	@ManyToOne
	@JoinColumn(name="client_category_id")
	private ClientCategory clientCategory;

	//bi-directional many-to-one association to ClientBusiness
	@ManyToOne
	@JoinColumn(name="client_business_id")
	private ClientBusiness clientBusiness;

	public ClientBusinessCategory() {
	}

	public String getBusinessCategoriesId() {
		return this.businessCategoriesId;
	}

	public void setBusinessCategoriesId(String businessCategoriesId) {
		this.businessCategoriesId = businessCategoriesId;
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientCategory getClientCategory() {
		return this.clientCategory;
	}

	public void setClientCategory(ClientCategory clientCategory) {
		this.clientCategory = clientCategory;
	}

	public ClientBusiness getClientBusiness() {
		return this.clientBusiness;
	}

	public void setClientBusiness(ClientBusiness clientBusiness) {
		this.clientBusiness = clientBusiness;
	}

}