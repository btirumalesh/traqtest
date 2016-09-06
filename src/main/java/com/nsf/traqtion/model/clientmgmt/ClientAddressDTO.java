package com.nsf.traqtion.model.clientmgmt;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.Country;
import com.nsf.traqtion.data.entity.State;

public class ClientAddressDTO {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private String clientAddressId;

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private Long createdBy;

    private Timestamp creationDate;

    private Long updatedBy;

    private Timestamp updatedDate;

    private int zipCode;

    private Client client;
    
    private State state;
    
    private Long stateId;
    
    private Country country;
    
    private Long countryId;


    public String getClientAddressId() {
        return clientAddressId;
    }

    public void setClientAddressId(String clientAddressId) {
        this.clientAddressId = clientAddressId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    
}
