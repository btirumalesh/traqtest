package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the client_site_notification database table.
 * 
 */
@Entity
@Table(name = "client_site_notification")
@NamedQueries({ @NamedQuery(name = "ClientSiteNotification.findAll", query = "SELECT c FROM ClientSiteNotification c"),
        @NamedQuery(name = "ClientSiteNotification.findByClientSiteId", query = "from ClientSiteNotification notification where notification.clientSiteId = :clientSiteId") })
public class ClientSiteNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="created_by")
	private BigInteger createdBy;
	
	@Column(name="client_sites_id")
	private BigInteger clientSiteId;
	
	@Column(name="client_email_template_id")
	private BigInteger clientEmailTemplateId;

	@Column(name="creation_date", insertable = false,updatable = false)
	private Timestamp creationDate;

	private String notes;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "notification_id")
	private BigInteger notificationId;

	@Column(name="sent_from")
	private String sentFrom;

	@Column(name="sent_to")
	private String sentTo;

	private String subject;

	@Column(name="updated_by")
	private BigInteger updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;
/*
	//bi-directional many-to-one association to ClientSite
	@ManyToOne
	@JoinColumn(name="client_sites_id")
	private ClientSite clientSite;

	//bi-directional many-to-one association to ClientEmailTemplate
	@ManyToOne
	@JoinColumn(name="client_email_template_id")
	private ClientEmailTemplate clientEmailTemplate;
*/
	public ClientSiteNotification() {
	}

	public BigInteger getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
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

	public BigInteger getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(BigInteger notificationId) {
		this.notificationId = notificationId;
	}

	public String getSentFrom() {
		return this.sentFrom;
	}

	public void setSentFrom(String sentFrom) {
		this.sentFrom = sentFrom;
	}

	public String getSentTo() {
		return this.sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public BigInteger getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(BigInteger updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
/*
	public ClientSite getClientSite() {
		return this.clientSite;
	}

	public void setClientSite(ClientSite clientSite) {
		this.clientSite = clientSite;
	}

	public ClientEmailTemplate getClientEmailTemplate() {
		return this.clientEmailTemplate;
	}

	public void setClientEmailTemplate(ClientEmailTemplate clientEmailTemplate) {
		this.clientEmailTemplate = clientEmailTemplate;
	}
*/

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

    @Override
    public String toString() {
        return "ClientSiteNotification [createdBy=" + createdBy + ", clientSiteId=" + clientSiteId
                + ", clientEmailTemplateId=" + clientEmailTemplateId + ", creationDate=" + creationDate + ", notes="
                + notes + ", notificationId=" + notificationId + ", sentFrom=" + sentFrom + ", sentTo=" + sentTo
                + ", subject=" + subject + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
    }
}