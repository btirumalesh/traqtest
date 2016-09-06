package com.nsf.traqtion.model.produtSpecification;

import java.util.Date;

/**
 * 
 * @author HTCINDIA\maheswarang
 *
 */
public class ProductSpecificationSearchDTO {

    private Integer productSpecificationSearchId;
    private String productTitle;
    private String clientProductCode;
    private String systemProductCode;
    private String supplierCode;
    private String siteCode;
    private String specificationStatus;
    private String supplierName;
    private String commercialStatus;
    private String specificationType;
    private String businessName;
    private String specificationOwner;
    private String siteName;
    private String category;
    private String createdBy;
    private String brand;
    private String myCategories;
    private String allCategories;
    private String clientId;
    private String categoryType;

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getMyCategories() {
        return myCategories;
    }

    public void setMyCategories(String myCategories) {
        this.myCategories = myCategories;
    }

    public String getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(String allCategories) {
        this.allCategories = allCategories;
    }

    public Integer getProductSpecificationSearchId() {
        return productSpecificationSearchId;
    }

    public void setProductSpecificationSearchId(Integer productSpecificationSearchId) {
        this.productSpecificationSearchId = productSpecificationSearchId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getClientProductCode() {
        return clientProductCode;
    }

    public void setClientProductCode(String clientProductCode) {
        this.clientProductCode = clientProductCode;
    }

    public String getSystemProductCode() {
        return systemProductCode;
    }

    public void setSystemProductCode(String systemProductCode) {
        this.systemProductCode = systemProductCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSpecificationStatus() {
        return specificationStatus;
    }

    public void setSpecificationStatus(String specificationStatus) {
        this.specificationStatus = specificationStatus;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCommercialStatus() {
        return commercialStatus;
    }

    public void setCommercialStatus(String commercialStatus) {
        this.commercialStatus = commercialStatus;
    }

    public String getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(String specificationType) {
        this.specificationType = specificationType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getSpecificationOwner() {
        return specificationOwner;
    }

    public void setSpecificationOwner(String specificationOwner) {
        this.specificationOwner = specificationOwner;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductSpecificationSearchDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductSpecificationSearchDTO(Integer productSpecificationSearchId, String productTitle,
            String clientProductCode, String systemProductCode, String supplierCode, String siteCode,
            String specificationStatus, String supplierName, String commercialStatus, String specificationType,
            String businessName, String specificationOwner, String siteName, String category, String createdBy,
            String brand, String myCategories, String allCategories, String clientId, String categoryType) {
        super();
        this.productSpecificationSearchId = productSpecificationSearchId;
        this.productTitle = productTitle;
        this.clientProductCode = clientProductCode;
        this.systemProductCode = systemProductCode;
        this.supplierCode = supplierCode;
        this.siteCode = siteCode;
        this.specificationStatus = specificationStatus;
        this.supplierName = supplierName;
        this.commercialStatus = commercialStatus;
        this.specificationType = specificationType;
        this.businessName = businessName;
        this.specificationOwner = specificationOwner;
        this.siteName = siteName;
        this.category = category;
        this.createdBy = createdBy;
        this.brand = brand;
        this.myCategories = myCategories;
        this.allCategories = allCategories;
        this.clientId = clientId;
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductSpecificationSearchDTO [productSpecificationSearchId=" + productSpecificationSearchId
                + ", productTitle=" + productTitle + ", clientProductCode=" + clientProductCode + ", systemProductCode="
                + systemProductCode + ", supplierCode=" + supplierCode + ", siteCode=" + siteCode
                + ", specificationStatus=" + specificationStatus + ", supplierName=" + supplierName
                + ", commercialStatus=" + commercialStatus + ", specificationType=" + specificationType
                + ", businessName=" + businessName + ", specificationOwner=" + specificationOwner + ", siteName="
                + siteName + ", category=" + category + ", createdBy=" + createdBy + ", brand=" + brand
                + ", myCategories=" + myCategories + ", allCategories=" + allCategories + ", clientId=" + clientId
                + ", categoryType=" + categoryType + "]";
    }

}