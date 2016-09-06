package com.nsf.traqtion.model.produtSpecification;

import java.util.Date;

/**
 * <h1>Data Transfer Object class for Product Specification</h1> Data transfer
 * object (DTO) is an object that carries data between processes.
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
public class ProductSpecificationDTO {

    private Long primarySpecificationId;
    private String primarySpecificationName;
    private String primarySpecificationSequenceNo;
    private Integer clientId;
    private String specificationType;
    private String businessUnit;
    private String owner;
    private String clientProductCode;
    private String productTitle;
    private String brand;
    private String category;
    private String primaryVersionNo;
    private String productImagePath;
    private String commercialStatus;
    private String specificationStatus;
    private Integer createdBy;
    private Integer updatedBy;
    private Date specificationCreationDate;
    private Date creationDate;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getSpecificationCreationDate() {
        return specificationCreationDate;
    }

    public void setSpecificationCreationDate(Date specificationCreationDate) {
        this.specificationCreationDate = specificationCreationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ProductSpecificationDTO() {

    }

    @Override
    public String toString() {
        return "ProductSpecificationDTO [primarySpecificationId=" + primarySpecificationId
                + ", primarySpecificationName=" + primarySpecificationName + ", primarySpecificationSequenceNo="
                + primarySpecificationSequenceNo + ", clientId=" + clientId + ", specificationType=" + specificationType
                + ", businessUnit=" + businessUnit + ", owner=" + owner + ", clientProductCode=" + clientProductCode
                + ", productTitle=" + productTitle + ", brand=" + brand + ", category=" + category
                + ", primaryVersionNo=" + primaryVersionNo + ", productImagePath=" + productImagePath
                + ", commercialStatus=" + commercialStatus + ", specificationStatus=" + specificationStatus
                + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", specificationCreationDate="
                + specificationCreationDate + ", creationDate=" + creationDate + ", updatedDate=" + updatedDate + "]";
    }

}
