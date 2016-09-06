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
 * The persistent class for the wf_objects database table.
 * 
 */
@Entity
@Table(name="wf_objects")
@NamedQuery(name="WfObject.findAll", query="SELECT w FROM WfObject w")
public class WfObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wf_objects_id")
	private String wfObjectsId;

	@Column(name="approval_level")
	private Long approvalLevel;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="current_level_flag")
	private String currentLevelFlag;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	//bi-directional many-to-one association to WfDefinition
	@ManyToOne
	@JoinColumn(name="wf_definitions_id")
	private WfDefinition wfDefinition;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to WfTransaction
	@OneToMany(mappedBy="wfObject")
	private List<WfTransaction> wfTransactions;

	public WfObject() {
	}

	public String getWfObjectsId() {
		return this.wfObjectsId;
	}

	public void setWfObjectsId(String wfObjectsId) {
		this.wfObjectsId = wfObjectsId;
	}

	public Long getApprovalLevel() {
		return this.approvalLevel;
	}

	public void setApprovalLevel(Long approvalLevel) {
		this.approvalLevel = approvalLevel;
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

	public String getCurrentLevelFlag() {
		return this.currentLevelFlag;
	}

	public void setCurrentLevelFlag(String currentLevelFlag) {
		this.currentLevelFlag = currentLevelFlag;
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

	public SupplierSpecification getSupplierSpecification() {
		return this.supplierSpecification;
	}

	public void setSupplierSpecification(SupplierSpecification supplierSpecification) {
		this.supplierSpecification = supplierSpecification;
	}

	public WfDefinition getWfDefinition() {
		return this.wfDefinition;
	}

	public void setWfDefinition(WfDefinition wfDefinition) {
		this.wfDefinition = wfDefinition;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<WfTransaction> getWfTransactions() {
		return this.wfTransactions;
	}

	public void setWfTransactions(List<WfTransaction> wfTransactions) {
		this.wfTransactions = wfTransactions;
	}

	public WfTransaction addWfTransaction(WfTransaction wfTransaction) {
		getWfTransactions().add(wfTransaction);
		wfTransaction.setWfObject(this);

		return wfTransaction;
	}

	public WfTransaction removeWfTransaction(WfTransaction wfTransaction) {
		getWfTransactions().remove(wfTransaction);
		wfTransaction.setWfObject(null);

		return wfTransaction;
	}

}