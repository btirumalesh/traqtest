package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <h1>Entity class for Product Specification</h1> an entity class represents a
 * table in a relational database
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
@Entity
@Table(name = "primary_specification")
public class ProductSpecification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "primary_spec_id")
    private Long primarySpecificationId;

    @Column(name = "primary_spec_name")
    private String primarySpecificationName;

    @Column(name = "primary_spec_seq_no")
    private String primarySpecificationSequenceNo;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "specification_type")
    private String specificationType;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "owner")
    private String owner;

    @Column(name = "client_product_code")
    private String clientProductCode;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "brand")
    private String brand;

    @Column(name = "category")
    private String category;

    @Column(name = "primary_version_no")
    private String primaryVersionNo;

    @Column(name = "product_image_path")
    private String productImagePath;

    @Column(name = "commercial_status")
    private String commercialStatus;

    @Column(name = "specification_status")
    private String specificationStatus;

    @Column(name = "created_by")
    private Integer createdBy;
    
    @Column(name = "updated_by")
    private Integer updatedBy;
    
    @Column(name = "spec_creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date specificationCreationDate;
      
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Long getPrimarySpecificationId() {
        return primarySpecificationId;
    }

    public void setPrimarySpecificationId(Long primarySpecificationId) {
        this.primarySpecificationId = primarySpecificationId;
    }

    public String getPrimarySpecificationName() {
        return primarySpecificationName;
    }

    public void setPrimarySpecificationName(String primarySpecificationName) {
        this.primarySpecificationName = primarySpecificationName;
    }

    public String getPrimarySpecificationSequenceNo() {
        return primarySpecificationSequenceNo;
    }

    public void setPrimarySpecificationSequenceNo(String primarySpecificationSequenceNo) {
        this.primarySpecificationSequenceNo = primarySpecificationSequenceNo;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(String specificationType) {
        this.specificationType = specificationType;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getClientProductCode() {
        return clientProductCode;
    }

    public void setClientProductCode(String clientProductCode) {
        this.clientProductCode = clientProductCode;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrimaryVersionNo() {
        return primaryVersionNo;
    }

    public void setPrimaryVersionNo(String primaryVersionNo) {
        this.primaryVersionNo = primaryVersionNo;
    }

    public Date getSpecificationCreationDate() {
        return specificationCreationDate;
    }

    public void setSpecificationCreationDate(Date specificationCreationDate) {
        this.specificationCreationDate = specificationCreationDate;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public String getCommercialStatus() {
        return commercialStatus;
    }

    public void setCommercialStatus(String commercialStatus) {
        this.commercialStatus = commercialStatus;
    }

    public String getSpecificationStatus() {
        return specificationStatus;
    }

    public void setSpecificationStatus(String specificationStatus) {
        this.specificationStatus = specificationStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

}
