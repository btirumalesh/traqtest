package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the client_site_facility database table.
 * 
 */
@Entity
@Table(name="client_site_facility")
@NamedQueries(
        {
        	@NamedQuery(name="ClientSiteFacility.findAll", query="SELECT c FROM ClientSiteFacility c"),
            @NamedQuery(
            name = "ClientSiteFacility.findByClientSiteId",
            query = "SELECT c FROM ClientSiteFacility c where c.clientSite = :clientSite"
            )
        }
    ) 
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class ClientSiteFacility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_site_facility_id")
	private Long clientSiteFacilityId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String notes;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientSite
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name="client_sites_id")
	private ClientSite clientSite;

	//bi-directional many-to-one association to ClientFacilityType
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_facility_type_id")
	private ClientFacilityType clientFacilityType;

	public ClientSiteFacility() {
	}

	public Long getClientSiteFacilityId() {
		return this.clientSiteFacilityId;
	}

	public void setClientSiteFacilityId(Long clientSiteFacilityId) {
		this.clientSiteFacilityId = clientSiteFacilityId;
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

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public ClientSite getClientSite() {
		return this.clientSite;
	}

	public void setClientSite(ClientSite clientSite) {
		this.clientSite = clientSite;
	}

	public ClientFacilityType getClientFacilityType() {
		return this.clientFacilityType;
	}

	public void setClientFacilityType(ClientFacilityType clientFacilityType) {
		this.clientFacilityType = clientFacilityType;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientSiteFacilityId == null) ? 0 : clientSiteFacilityId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientSiteFacility other = (ClientSiteFacility) obj;
        if (clientSiteFacilityId == null) {
            if (other.clientSiteFacilityId != null)
                return false;
        } else if (!clientSiteFacilityId.equals(other.clientSiteFacilityId))
            return false;
        return true;
    }

	
}