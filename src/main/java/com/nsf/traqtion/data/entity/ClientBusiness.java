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
 * The persistent class for the client_business database table.
 * 
 */
@Entity
@Table(name="client_business")
@NamedQuery(name="ClientBusiness.findAll", query="SELECT c FROM ClientBusiness c")
public class ClientBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_business_id")
	private Long clientBusinessId;

	@Column(name="business_code")
	private String businessCode;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="parent_business_id")
	private Long parentBusinessId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientBusinessCategory
	@OneToMany(mappedBy="clientBusiness")
	private List<ClientBusinessCategory> clientBusinessCategories;

	//bi-directional many-to-one association to ClientSpecType
	@OneToMany(mappedBy="clientBusiness")
	private List<ClientSpecType> clientSpecTypes;

	//bi-directional many-to-one association to UserBusinessCategory
	@OneToMany(mappedBy="clientBusiness")
	private List<UserBusinessCategory> userBusinessCategories;

	public ClientBusiness() {
	}

	public Long getClientBusinessId() {
		return this.clientBusinessId;
	}

	public void setClientBusinessId(Long clientBusinessId) {
		this.clientBusinessId = clientBusinessId;
	}

	public String getBusinessCode() {
		return this.businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
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

	public Long getParentBusinessId() {
		return this.parentBusinessId;
	}

	public void setParentBusinessId(Long parentBusinessId) {
		this.parentBusinessId = parentBusinessId;
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

	public List<ClientBusinessCategory> getClientBusinessCategories() {
		return this.clientBusinessCategories;
	}

	public void setClientBusinessCategories(List<ClientBusinessCategory> clientBusinessCategories) {
		this.clientBusinessCategories = clientBusinessCategories;
	}

	public ClientBusinessCategory addClientBusinessCategory(ClientBusinessCategory clientBusinessCategory) {
		getClientBusinessCategories().add(clientBusinessCategory);
		clientBusinessCategory.setClientBusiness(this);

		return clientBusinessCategory;
	}

	public ClientBusinessCategory removeClientBusinessCategory(ClientBusinessCategory clientBusinessCategory) {
		getClientBusinessCategories().remove(clientBusinessCategory);
		clientBusinessCategory.setClientBusiness(null);

		return clientBusinessCategory;
	}

	public List<ClientSpecType> getClientSpecTypes() {
		return this.clientSpecTypes;
	}

	public void setClientSpecTypes(List<ClientSpecType> clientSpecTypes) {
		this.clientSpecTypes = clientSpecTypes;
	}

	public ClientSpecType addClientSpecType(ClientSpecType clientSpecType) {
		getClientSpecTypes().add(clientSpecType);
		clientSpecType.setClientBusiness(this);

		return clientSpecType;
	}

	public ClientSpecType removeClientSpecType(ClientSpecType clientSpecType) {
		getClientSpecTypes().remove(clientSpecType);
		clientSpecType.setClientBusiness(null);

		return clientSpecType;
	}

	public List<UserBusinessCategory> getUserBusinessCategories() {
		return this.userBusinessCategories;
	}

	public void setUserBusinessCategories(List<UserBusinessCategory> userBusinessCategories) {
		this.userBusinessCategories = userBusinessCategories;
	}

	public UserBusinessCategory addUserBusinessCategory(UserBusinessCategory userBusinessCategory) {
		getUserBusinessCategories().add(userBusinessCategory);
		userBusinessCategory.setClientBusiness(this);

		return userBusinessCategory;
	}

	public UserBusinessCategory removeUserBusinessCategory(UserBusinessCategory userBusinessCategory) {
		getUserBusinessCategories().remove(userBusinessCategory);
		userBusinessCategory.setClientBusiness(null);

		return userBusinessCategory;
	}

}