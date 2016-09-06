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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the languages database table.
 * 
 */
@Entity
@Table(name="languages")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="languages_id")
	private Long languagesId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="language_code")
	private String languageCode;

	@Column(name="language_name")
	private String languageName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@JsonIgnore
	@OneToMany(mappedBy="language",fetch = FetchType.LAZY)
	private List<Client> clients;

	//bi-directional many-to-one association to ClientLanguage
	@JsonIgnore
	@OneToMany(mappedBy="language",fetch = FetchType.LAZY)
	private List<ClientLanguage> clientLanguages;

	//bi-directional many-to-one association to UserDetail
	@JsonIgnore
	@OneToMany(mappedBy="language",fetch = FetchType.LAZY)
	private List<UserDetail> userDetails;

	public Language() {
	}

	public Long getLanguagesId() {
		return this.languagesId;
	}

	public void setLanguagesId(Long languagesId) {
		this.languagesId = languagesId;
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

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
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

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setLanguage(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setLanguage(null);

		return client;
	}

	public List<ClientLanguage> getClientLanguages() {
		return this.clientLanguages;
	}

	public void setClientLanguages(List<ClientLanguage> clientLanguages) {
		this.clientLanguages = clientLanguages;
	}

	public ClientLanguage addClientLanguage(ClientLanguage clientLanguage) {
		getClientLanguages().add(clientLanguage);
		clientLanguage.setLanguage(this);

		return clientLanguage;
	}

	public ClientLanguage removeClientLanguage(ClientLanguage clientLanguage) {
		getClientLanguages().remove(clientLanguage);
		clientLanguage.setLanguage(null);

		return clientLanguage;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setLanguage(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setLanguage(null);

		return userDetail;
	}

}