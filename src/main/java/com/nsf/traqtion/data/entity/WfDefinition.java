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
 * The persistent class for the wf_definitions database table.
 * 
 */
@Entity
@Table(name="wf_definitions")
@NamedQuery(name="WfDefinition.findAll", query="SELECT w FROM WfDefinition w")
public class WfDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wf_definitions_id")
	private String wfDefinitionsId;

	@Column(name="approval_level")
	private Long approvalLevel;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="mandatory_flag")
	private String mandatoryFlag;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to ClientSpecType
	@ManyToOne
	@JoinColumn(name="client_spec_type_id")
	private ClientSpecType clientSpecType;

	//bi-directional many-to-one association to WfObject
	@OneToMany(mappedBy="wfDefinition")
	private List<WfObject> wfObjects;

	public WfDefinition() {
	}

	public String getWfDefinitionsId() {
		return this.wfDefinitionsId;
	}

	public void setWfDefinitionsId(String wfDefinitionsId) {
		this.wfDefinitionsId = wfDefinitionsId;
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

	public String getMandatoryFlag() {
		return this.mandatoryFlag;
	}

	public void setMandatoryFlag(String mandatoryFlag) {
		this.mandatoryFlag = mandatoryFlag;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ClientSpecType getClientSpecType() {
		return this.clientSpecType;
	}

	public void setClientSpecType(ClientSpecType clientSpecType) {
		this.clientSpecType = clientSpecType;
	}

	public List<WfObject> getWfObjects() {
		return this.wfObjects;
	}

	public void setWfObjects(List<WfObject> wfObjects) {
		this.wfObjects = wfObjects;
	}

	public WfObject addWfObject(WfObject wfObject) {
		getWfObjects().add(wfObject);
		wfObject.setWfDefinition(this);

		return wfObject;
	}

	public WfObject removeWfObject(WfObject wfObject) {
		getWfObjects().remove(wfObject);
		wfObject.setWfDefinition(null);

		return wfObject;
	}

}