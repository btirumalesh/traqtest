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
 * The persistent class for the client_spec_type database table.
 * 
 */
@Entity
@Table(name="client_spec_type")
@NamedQuery(name="ClientSpecType.findAll", query="SELECT c FROM ClientSpecType c")
public class ClientSpecType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_spec_type_id")
	private String clientSpecTypeId;

	private String code;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="trq_master_values_id")
	private Long trqMasterValuesId;

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

	//bi-directional many-to-one association to WfDefinition
	@OneToMany(mappedBy="clientSpecType")
	private List<WfDefinition> wfDefinitions;

	public ClientSpecType() {
	}

	public String getClientSpecTypeId() {
		return this.clientSpecTypeId;
	}

	public void setClientSpecTypeId(String clientSpecTypeId) {
		this.clientSpecTypeId = clientSpecTypeId;
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

	public Long getTrqMasterValuesId() {
		return this.trqMasterValuesId;
	}

	public void setTrqMasterValuesId(Long trqMasterValuesId) {
		this.trqMasterValuesId = trqMasterValuesId;
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

	public List<WfDefinition> getWfDefinitions() {
		return this.wfDefinitions;
	}

	public void setWfDefinitions(List<WfDefinition> wfDefinitions) {
		this.wfDefinitions = wfDefinitions;
	}

	public WfDefinition addWfDefinition(WfDefinition wfDefinition) {
		getWfDefinitions().add(wfDefinition);
		wfDefinition.setClientSpecType(this);

		return wfDefinition;
	}

	public WfDefinition removeWfDefinition(WfDefinition wfDefinition) {
		getWfDefinitions().remove(wfDefinition);
		wfDefinition.setClientSpecType(null);

		return wfDefinition;
	}

}