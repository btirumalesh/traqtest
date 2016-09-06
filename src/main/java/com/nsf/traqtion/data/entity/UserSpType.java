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
 * The persistent class for the user_sp_type database table.
 * 
 */
@Entity
@Table(name="user_sp_type")
@NamedQuery(name="UserSpType.findAll", query="SELECT u FROM UserSpType u")
public class UserSpType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_sp_type_id")
	private Long userSpTypeId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ServiceProviderType
	@ManyToOne
	@JoinColumn(name="service_provider_type_id")
	private ServiceProviderType serviceProviderType;

	//bi-directional many-to-one association to UserMapping
	@ManyToOne
	@JoinColumn(name="user_mapping_id")
	private UserMapping userMapping;

	public UserSpType() {
	}

	public Long getUserSpTypeId() {
		return this.userSpTypeId;
	}

	public void setUserSpTypeId(Long userSpTypeId) {
		this.userSpTypeId = userSpTypeId;
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

	public ServiceProviderType getServiceProviderType() {
		return this.serviceProviderType;
	}

	public void setServiceProviderType(ServiceProviderType serviceProviderType) {
		this.serviceProviderType = serviceProviderType;
	}

	public UserMapping getUserMapping() {
		return this.userMapping;
	}

	public void setUserMapping(UserMapping userMapping) {
		this.userMapping = userMapping;
	}

}