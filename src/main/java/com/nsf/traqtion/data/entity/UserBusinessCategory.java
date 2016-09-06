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
 * The persistent class for the user_business_categories database table.
 * 
 */
@Entity
@Table(name="user_business_categories")
@NamedQuery(name="UserBusinessCategory.findAll", query="SELECT u FROM UserBusinessCategory u")
public class UserBusinessCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_business_categories_id")
	private Long userBusinessCategoriesId;

	@Column(name="categories_id")
	private Long categoriesId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to UserMapping
	@ManyToOne
	@JoinColumn(name="user_mapping_id")
	private UserMapping userMapping;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientBusiness
	@ManyToOne
	@JoinColumn(name="client_business_id")
	private ClientBusiness clientBusiness;

	public UserBusinessCategory() {
	}

	public Long getUserBusinessCategoriesId() {
		return this.userBusinessCategoriesId;
	}

	public void setUserBusinessCategoriesId(Long userBusinessCategoriesId) {
		this.userBusinessCategoriesId = userBusinessCategoriesId;
	}

	public Long getCategoriesId() {
		return this.categoriesId;
	}

	public void setCategoriesId(Long categoriesId) {
		this.categoriesId = categoriesId;
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

	public UserMapping getUserMapping() {
		return this.userMapping;
	}

	public void setUserMapping(UserMapping userMapping) {
		this.userMapping = userMapping;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientBusiness getClientBusiness() {
		return this.clientBusiness;
	}

	public void setClientBusiness(ClientBusiness clientBusiness) {
		this.clientBusiness = clientBusiness;
	}

}