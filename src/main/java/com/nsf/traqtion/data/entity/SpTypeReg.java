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
 * The persistent class for the sp_type_reg database table.
 * 
 */
@Entity
@Table(name="sp_type_reg")
@NamedQuery(name="SpTypeReg.findAll", query="SELECT s FROM SpTypeReg s")
public class SpTypeReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sp_type_reg_id")
	private String spTypeRegId;

	@Column(name="active_flag")
	private String activeFlag;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="status_id")
	private Long statusId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to BusinessRegistration
	@ManyToOne
	@JoinColumn(name="business_reg_id")
	private BusinessRegistration businessRegistration;

	//bi-directional many-to-one association to ServiceProviderType
	@ManyToOne
	@JoinColumn(name="service_provider_type_id")
	private ServiceProviderType serviceProviderType;

	public SpTypeReg() {
	}

	public String getSpTypeRegId() {
		return this.spTypeRegId;
	}

	public void setSpTypeRegId(String spTypeRegId) {
		this.spTypeRegId = spTypeRegId;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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

	public BusinessRegistration getBusinessRegistration() {
		return this.businessRegistration;
	}

	public void setBusinessRegistration(BusinessRegistration businessRegistration) {
		this.businessRegistration = businessRegistration;
	}

	public ServiceProviderType getServiceProviderType() {
		return this.serviceProviderType;
	}

	public void setServiceProviderType(ServiceProviderType serviceProviderType) {
		this.serviceProviderType = serviceProviderType;
	}

}