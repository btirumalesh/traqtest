package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the client_facility_type database table.
 * 
 */
@Entity
@Table(name="client_facility_type")
@NamedQuery(name="ClientFacilityType.findAll", query="SELECT c FROM ClientFacilityType c")
public class ClientFacilityType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_facility_type_id")
	private Long clientFacilityTypeId;

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

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientSiteFacility
	@JsonIgnore
    @OneToMany(mappedBy="clientFacilityType",fetch = FetchType.LAZY)
	private List<ClientSiteFacility> clientSiteFacilities;

	public ClientFacilityType() {
	}

	public Long getClientFacilityTypeId() {
		return this.clientFacilityTypeId;
	}

	public void setClientFacilityTypeId(Long clientFacilityTypeId) {
		this.clientFacilityTypeId = clientFacilityTypeId;
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ClientSiteFacility> getClientSiteFacilities() {
		return this.clientSiteFacilities;
	}

	public void setClientSiteFacilities(List<ClientSiteFacility> clientSiteFacilities) {
		this.clientSiteFacilities = clientSiteFacilities;
	}

	public ClientSiteFacility addClientSiteFacility(ClientSiteFacility clientSiteFacility) {
		getClientSiteFacilities().add(clientSiteFacility);
		clientSiteFacility.setClientFacilityType(this);

		return clientSiteFacility;
	}

	public ClientSiteFacility removeClientSiteFacility(ClientSiteFacility clientSiteFacility) {
		getClientSiteFacilities().remove(clientSiteFacility);
		clientSiteFacility.setClientFacilityType(null);

		return clientSiteFacility;
	}

}