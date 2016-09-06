package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the client_site_document database table.
 * 
 */
@Entity
@Table(name="client_site_document")
@NamedQueries({
    @NamedQuery(name="ClientSiteDocument.findAll", query="SELECT c FROM ClientSiteDocument c"),
    @NamedQuery(name="ClientSiteDocument.findByClientSiteId",
                query="SELECT c FROM ClientSiteDocument c WHERE c.clientSite = :clientSite"),
}) 
public class ClientSiteDocument implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="client_site_document_id")
    private BigInteger clientSiteDocumentId;

    @Column(name="attachment_path")
    private String attachmentPath;

    @Lob
    private byte[] attachments;

    @Column(name="client_document_type_id")
    private Long clientDocumentTypeId;

    @Column(name="created_by")
    private Long createdBy;

    @Column(name="creation_date")
    private Timestamp creationDate;

    private String description;

    @Column(name="document_code")
    private String documentCode;

    @Column(name="document_name")
    private String documentName;

    @Column(name="public_flag")
    private String publicFlag;

    @Column(name="updated_by")
    private Long updatedBy;

    @Column(name="updated_date")
    private Timestamp updatedDate;

    //bi-directional many-to-one association to ClientSite
    @ManyToOne
    @JoinColumn(name="client_sites_id")
    private ClientSite clientSite;

    public ClientSiteDocument() {
    }

    public BigInteger getClientSiteDocumentId() {
        return this.clientSiteDocumentId;
    }

    public void setClientSiteDocumentId(BigInteger clientSiteDocumentId) {
        this.clientSiteDocumentId = clientSiteDocumentId;
    }

    public String getAttachmentPath() {
        return this.attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public byte[] getAttachments() {
        return this.attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    public Long getClientDocumentTypeId() {
        return this.clientDocumentTypeId;
    }

    public void setClientDocumentTypeId(Long clientDocumentTypeId) {
        this.clientDocumentTypeId = clientDocumentTypeId;
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

    public String getDocumentCode() {
        return this.documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getPublicFlag() {
        return this.publicFlag;
    }

    public void setPublicFlag(String publicFlag) {
        this.publicFlag = publicFlag;
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

    @Override
    public String toString() {
        return "ClientSiteDocument [clientSiteDocumentId=" + clientSiteDocumentId + ", attachmentPath=" + attachmentPath
                + ", attachments=" + Arrays.toString(attachments) + ", clientDocumentTypeId=" + clientDocumentTypeId
                + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", description=" + description
                + ", documentCode=" + documentCode + ", documentName=" + documentName + ", publicFlag=" + publicFlag
                + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", clientSite=" + clientSite + "]";
    }

}