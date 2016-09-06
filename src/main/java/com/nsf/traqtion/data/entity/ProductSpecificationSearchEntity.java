package com.nsf.traqtion.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_specification_search")
public class ProductSpecificationSearchEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_specification_search_id")
    private Integer productSpecificationSearchId;
    @Column(name = "client_product_code")
    private String clientProductCode;
    @Column(name = "system_product_code")
    private String systemProductCode;
    @Column(name = "supplier_code")
    private String supplierCode;
    @Column(name = "site_code")
    private String siteCode;
    @Column(name = "specification_status")
    private String specificationStatus;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "commercial_status")
    private String commercialStatus;
    @Column(name = "specification_type")
    private String specificationType;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "specification_owner")
    private String specificationOwner;
    @Column(name = "site_name")
    private String siteName;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "brand")
    private String brand;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "category_name")
    private String category;

    @Column(name = "my_categories")
    private String myCategories;
    @Column(name = "all_categories")
    private String allCategories;
    @Column(name = "category_type")
    private String categoryType;

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductSpecificationSearchEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductSpecificationSearchEntity(Integer productSpecificationSearchId, String clientProductCode,
            String systemProductCode, String supplierCode, String siteCode, String specificationStatus,
            String supplierName, String commercialStatus, String specificationType, String businessName,
            String specificationOwner, String siteName, String createdBy, String brand, String productTitle,
            String category, String myCategories, String allCategories, String categoryType) {
        super();
        this.productSpecificationSearchId = productSpecificationSearchId;
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
        this.createdBy = createdBy;
        this.brand = brand;
        this.productTitle = productTitle;
        this.category = category;
        this.myCategories = myCategories;
        this.allCategories = allCategories;
        this.categoryType = categoryType;
    }

}