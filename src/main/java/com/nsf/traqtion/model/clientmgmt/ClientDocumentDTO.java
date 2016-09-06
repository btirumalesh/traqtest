package com.nsf.traqtion.model.clientmgmt;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the client_document database table.
 * 
 */

public class ClientDocumentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientDocumentId;

    private String attachmentPath;

    @JsonIgnore
    private byte[] attachments;

    private Long clientDocumentTypeId;

    private Long createdBy;

    @JsonIgnore
    private Timestamp creationDate;

    private String description;

    private String documentCode;

    private String documentName;

    private String publicFlag;

    private Long updatedBy;

    @JsonIgnore
    private Timestamp updatedDate;

    public String getClientDocumentId() {
        return clientDocumentId;
    }

    public void setClientDocumentId(String clientDocumentId) {
        this.clientDocumentId = clientDocumentId;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    public Long getClientDocumentTypeId() {
        return clientDocumentTypeId;
    }

    public void setClientDocumentTypeId(Long clientDocumentTypeId) {
        this.clientDocumentTypeId = clientDocumentTypeId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getPublicFlag() {
        return publicFlag;
    }

    public void setPublicFlag(String publicFlag) {
        this.publicFlag = publicFlag;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
}