package com.nsf.traqtion.model.clientmgmt;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * The Data Transfer Object class for the client_site_notification database
 * table.
 * 
 */

public class ClientSiteNotificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigInteger createdBy;
    private BigInteger clientSiteId;
    private BigInteger clientEmailTemplateId;
   // private Timestamp creationDate;
    private String notes;
    private BigInteger notificationId;
    private String sentFrom;
    private String sentTo;
    private String subject;
    private BigInteger updatedBy;
   // private Timestamp updatedDate;

    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }

    public BigInteger getClientSiteId() {
        return clientSiteId;
    }

    public void setClientSiteId(BigInteger clientSiteId) {
        this.clientSiteId = clientSiteId;
    }

    public BigInteger getClientEmailTemplateId() {
        return clientEmailTemplateId;
    }

    public void setClientEmailTemplateId(BigInteger clientEmailTemplateId) {
        this.clientEmailTemplateId = clientEmailTemplateId;
    }

   /* public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }*/

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigInteger getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(BigInteger notificationId) {
        this.notificationId = notificationId;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigInteger getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(BigInteger updatedBy) {
        this.updatedBy = updatedBy;
    }

   /* public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }*/

    @Override
    public String toString() {
        return "ClientSiteNotificationDTO [createdBy=" + createdBy + ", clientSiteId=" + clientSiteId
                + ", clientEmailTemplateId=" + clientEmailTemplateId + ", creationDate=" + ", notes="
                + notes + ", notificationId=" + notificationId + ", sentFrom=" + sentFrom + ", sentTo=" + sentTo
                + ", subject=" + subject + ", updatedBy=" + updatedBy + ", updatedDate=" + "]";
    }
}
