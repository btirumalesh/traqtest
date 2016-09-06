package com.nsf.traqtion.model.clientmgmt;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nsf.traqtion.data.entity.ClientFacilityType;
import com.nsf.traqtion.data.entity.ClientSite;

public class ClientSiteFacilityDto {
	private Long clientSiteFacilityId;
	private String chargedBy;
	private Timestamp dateChanged;
	private int facilityType;
	private String notes;
	//bi-directional many-to-one association to ClientSite
	private ClientFacilityType clientFacilityType;
	/*
	 * clientFacilityType:{clientFacilityTypeId:{ID}}
	 */

	private ClientSite clientSite;
	
	
	public Long getClientSiteFacilityId() {
		return clientSiteFacilityId;
	}
	public void setClientSiteFacilityId(Long clientSiteFacilityId) {
		this.clientSiteFacilityId = clientSiteFacilityId;
	}
	public String getChargedBy() {
		return chargedBy;
	}
	public void setChargedBy(String chargedBy) {
		this.chargedBy = chargedBy;
	}
	public Timestamp getDateChanged() {
		return dateChanged;
	}
	public void setDateChanged(Timestamp dateChanged) {
		this.dateChanged = dateChanged;
	}
	public int getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(int facilityType) {
		this.facilityType = facilityType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public ClientSite getClientSite() {
		return clientSite;
	}
	public void setClientSite(ClientSite clientSite) {
		this.clientSite = clientSite;
	}
    public ClientFacilityType getClientFacilityType() {
        return clientFacilityType;
    }
    public void setClientFacilityType(ClientFacilityType clientFacilityType) {
        this.clientFacilityType = clientFacilityType;
    }

}
