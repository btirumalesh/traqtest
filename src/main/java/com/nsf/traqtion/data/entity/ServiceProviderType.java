package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the service_provider_type database table.
 * 
 */
@Entity
@Table(name="service_provider_type")
@NamedQuery(name="ServiceProviderType.findAll", query="SELECT s FROM ServiceProviderType s")
public class ServiceProviderType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_provider_type_id")
	private Long serviceProviderTypeId;

	private String code;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SpTypeReg
	@OneToMany(mappedBy="serviceProviderType")
	private List<SpTypeReg> spTypeRegs;

	//bi-directional many-to-one association to UserSpType
	@OneToMany(mappedBy="serviceProviderType")
	private List<UserSpType> userSpTypes;

	public ServiceProviderType() {
	}

	public Long getServiceProviderTypeId() {
		return this.serviceProviderTypeId;
	}

	public void setServiceProviderTypeId(Long serviceProviderTypeId) {
		this.serviceProviderTypeId = serviceProviderTypeId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<SpTypeReg> getSpTypeRegs() {
		return this.spTypeRegs;
	}

	public void setSpTypeRegs(List<SpTypeReg> spTypeRegs) {
		this.spTypeRegs = spTypeRegs;
	}

	public SpTypeReg addSpTypeReg(SpTypeReg spTypeReg) {
		getSpTypeRegs().add(spTypeReg);
		spTypeReg.setServiceProviderType(this);

		return spTypeReg;
	}

	public SpTypeReg removeSpTypeReg(SpTypeReg spTypeReg) {
		getSpTypeRegs().remove(spTypeReg);
		spTypeReg.setServiceProviderType(null);

		return spTypeReg;
	}

	public List<UserSpType> getUserSpTypes() {
		return this.userSpTypes;
	}

	public void setUserSpTypes(List<UserSpType> userSpTypes) {
		this.userSpTypes = userSpTypes;
	}

	public UserSpType addUserSpType(UserSpType userSpType) {
		getUserSpTypes().add(userSpType);
		userSpType.setServiceProviderType(this);

		return userSpType;
	}

	public UserSpType removeUserSpType(UserSpType userSpType) {
		getUserSpTypes().remove(userSpType);
		userSpType.setServiceProviderType(null);

		return userSpType;
	}

}