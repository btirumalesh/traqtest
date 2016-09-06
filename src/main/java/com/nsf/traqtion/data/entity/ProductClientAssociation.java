package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the product_client_association database table.
 * 
 */
@Entity
@Table(name="product_client_association")
@NamedQuery(name="ProductClientAssociation.findAll", query="SELECT p FROM ProductClientAssociation p")
public class ProductClientAssociation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_client_assoc_id")
	private String productClientAssocId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to PrimarySpecification
	@ManyToOne
	@JoinColumn(name="primary_spec_id")
	private PrimarySpecification primarySpecification;

	public ProductClientAssociation() {
	}

	public String getProductClientAssocId() {
		return this.productClientAssocId;
	}

	public void setProductClientAssocId(String productClientAssocId) {
		this.productClientAssocId = productClientAssocId;
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

	public PrimarySpecification getPrimarySpecification() {
		return this.primarySpecification;
	}

	public void setPrimarySpecification(PrimarySpecification primarySpecification) {
		this.primarySpecification = primarySpecification;
	}

}