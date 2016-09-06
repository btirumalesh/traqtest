package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the client_category database table.
 * 
 */
@Entity
@Table(name="client_category")
@NamedQuery(name="ClientCategory.findAll", query="SELECT c FROM ClientCategory c")
public class ClientCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_category_id")
	private Long clientCategoryId;

	@Column(name="active_flag")
	private String activeFlag;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="display_flag")
	private String displayFlag;

	@Column(name="parent_category_id")
	private Long parentCategoryId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientBusinessCategory
	@OneToMany(mappedBy="clientCategory")
	private List<ClientBusinessCategory> clientBusinessCategories;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientSpecType
	@OneToMany(mappedBy="clientCategory")
	private List<ClientSpecType> clientSpecTypes;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="clientCategory")
	private List<UserDetail> userDetails;

	public ClientCategory() {
	}

	public Long getClientCategoryId() {
		return this.clientCategoryId;
	}

	public void setClientCategoryId(Long clientCategoryId) {
		this.clientCategoryId = clientCategoryId;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayFlag() {
		return this.displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public Long getParentCategoryId() {
		return this.parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
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

	public List<ClientBusinessCategory> getClientBusinessCategories() {
		return this.clientBusinessCategories;
	}

	public void setClientBusinessCategories(List<ClientBusinessCategory> clientBusinessCategories) {
		this.clientBusinessCategories = clientBusinessCategories;
	}

	public ClientBusinessCategory addClientBusinessCategory(ClientBusinessCategory clientBusinessCategory) {
		getClientBusinessCategories().add(clientBusinessCategory);
		clientBusinessCategory.setClientCategory(this);

		return clientBusinessCategory;
	}

	public ClientBusinessCategory removeClientBusinessCategory(ClientBusinessCategory clientBusinessCategory) {
		getClientBusinessCategories().remove(clientBusinessCategory);
		clientBusinessCategory.setClientCategory(null);

		return clientBusinessCategory;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ClientSpecType> getClientSpecTypes() {
		return this.clientSpecTypes;
	}

	public void setClientSpecTypes(List<ClientSpecType> clientSpecTypes) {
		this.clientSpecTypes = clientSpecTypes;
	}

	public ClientSpecType addClientSpecType(ClientSpecType clientSpecType) {
		getClientSpecTypes().add(clientSpecType);
		clientSpecType.setClientCategory(this);

		return clientSpecType;
	}

	public ClientSpecType removeClientSpecType(ClientSpecType clientSpecType) {
		getClientSpecTypes().remove(clientSpecType);
		clientSpecType.setClientCategory(null);

		return clientSpecType;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setClientCategory(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setClientCategory(null);

		return userDetail;
	}

}