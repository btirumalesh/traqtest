package com.nsf.traqtion.model.clientmgmt;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsf.traqtion.data.entity.ClientSite;

public class ClientSiteDocumentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigInteger clientSiteDocumentId;
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
    
    @JsonIgnore
    private ClientSite clientSite;

    public BigInteger getClientSiteDocumentId() {
        return clientSiteDocumentId;
    }

    public void setClientSiteDocumentId(BigInteger clientSiteDocumentId) {
        this.clientSiteDocumentId = clientSiteDocumentId;
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

    public ClientSite getClientSite() {
        return clientSite;
    }

    public void setClientSite(ClientSite clientSite) {
        this.clientSite = clientSite;
    }

    @Override
    public String toString() {
        return "ClientSiteDocumentDTO [clientSiteDocumentId=" + clientSiteDocumentId + ", attachmentPath="
                + attachmentPath + ", attachments=" + Arrays.toString(attachments) + ", clientDocumentTypeId="
                + clientDocumentTypeId + ", createdBy=" + createdBy + ", creationDate=" + creationDate
                + ", description=" + description + ", documentCode=" + documentCode + ", documentName=" + documentName
                + ", publicFlag=" + publicFlag + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
                + ", clientSite=" + clientSite + "]";
    }
}
