package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the primary_specification database table.
 * 
 */
@Entity
@Table(name="primary_specification")
@NamedQuery(name="PrimarySpecification.findAll", query="SELECT p FROM PrimarySpecification p")
public class PrimarySpecification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="primary_spec_id")
	private Long primarySpecId;

	private String brand;

	@Column(name="business_unit")
	private String businessUnit;

	private String category;

	@Column(name="client_product_code")
	private String clientProductCode;

	@Column(name="commercial_status")
	private String commercialStatus;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String owner;

	@Column(name="primary_spec_name")
	private String primarySpecName;

	@Column(name="primary_spec_seq_no")
	private String primarySpecSeqNo;

	@Column(name="primary_version_no")
	private String primaryVersionNo;

	@Column(name="product_image_path")
	private String productImagePath;

	@Column(name="product_title")
	private String productTitle;

	@Column(name="spec_creation_date")
	private Timestamp specCreationDate;

	@Column(name="specification_status")
	private String specificationStatus;

	@Column(name="specification_type")
	private String specificationType;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ProductClientAssociation
	@OneToMany(mappedBy="primarySpecification")
	private List<ProductClientAssociation> productClientAssociations;

	//bi-directional many-to-one association to SupplierSpecification
	@OneToMany(mappedBy="primarySpecification")
	private List<SupplierSpecification> supplierSpecifications;

	public PrimarySpecification() {
	}

	public Long getPrimarySpecId() {
        return primarySpecId;
    }

	public void setPrimarySpecId(Long primarySpecId) {
        this.primarySpecId = primarySpecId;
    }

    public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClientProductCode() {
		return this.clientProductCode;
	}

	public void setClientProductCode(String clientProductCode) {
		this.clientProductCode = clientProductCode;
	}

	public String getCommercialStatus() {
		return this.commercialStatus;
	}

	public void setCommercialStatus(String commercialStatus) {
		this.commercialStatus = commercialStatus;
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

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPrimarySpecName() {
		return this.primarySpecName;
	}

	public void setPrimarySpecName(String primarySpecName) {
		this.primarySpecName = primarySpecName;
	}

	public String getPrimarySpecSeqNo() {
		return this.primarySpecSeqNo;
	}

	public void setPrimarySpecSeqNo(String primarySpecSeqNo) {
		this.primarySpecSeqNo = primarySpecSeqNo;
	}

	public String getPrimaryVersionNo() {
		return this.primaryVersionNo;
	}

	public void setPrimaryVersionNo(String primaryVersionNo) {
		this.primaryVersionNo = primaryVersionNo;
	}

	public String getProductImagePath() {
		return this.productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductTitle() {
		return this.productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public Timestamp getSpecCreationDate() {
		return this.specCreationDate;
	}

	public void setSpecCreationDate(Timestamp specCreationDate) {
		this.specCreationDate = specCreationDate;
	}

	public String getSpecificationStatus() {
		return this.specificationStatus;
	}

	public void setSpecificationStatus(String specificationStatus) {
		this.specificationStatus = specificationStatus;
	}

	public String getSpecificationType() {
		return this.specificationType;
	}

	public void setSpecificationType(String specificationType) {
		this.specificationType = specificationType;
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

	public List<ProductClientAssociation> getProductClientAssociations() {
		return this.productClientAssociations;
	}

	public void setProductClientAssociations(List<ProductClientAssociation> productClientAssociations) {
		this.productClientAssociations = productClientAssociations;
	}

	public ProductClientAssociation addProductClientAssociation(ProductClientAssociation productClientAssociation) {
		getProductClientAssociations().add(productClientAssociation);
		productClientAssociation.setPrimarySpecification(this);

		return productClientAssociation;
	}

	public ProductClientAssociation removeProductClientAssociation(ProductClientAssociation productClientAssociation) {
		getProductClientAssociations().remove(productClientAssociation);
		productClientAssociation.setPrimarySpecification(null);

		return productClientAssociation;
	}

	public List<SupplierSpecification> getSupplierSpecifications() {
		return this.supplierSpecifications;
	}

	public void setSupplierSpecifications(List<SupplierSpecification> supplierSpecifications) {
		this.supplierSpecifications = supplierSpecifications;
	}

	public SupplierSpecification addSupplierSpecification(SupplierSpecification supplierSpecification) {
		getSupplierSpecifications().add(supplierSpecification);
		supplierSpecification.setPrimarySpecification(this);

		return supplierSpecification;
	}

	public SupplierSpecification removeSupplierSpecification(SupplierSpecification supplierSpecification) {
		getSupplierSpecifications().remove(supplierSpecification);
		supplierSpecification.setPrimarySpecification(null);

		return supplierSpecification;
	}

}