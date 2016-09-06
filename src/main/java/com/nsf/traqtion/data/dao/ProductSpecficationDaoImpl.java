package com.nsf.traqtion.data.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nsf.traqtion.data.entity.ProductSpecficationApprove;
import com.nsf.traqtion.data.entity.ProductSpecification;
import com.nsf.traqtion.data.entity.ProductSpecificationSearchEntity;
import com.nsf.traqtion.service.rest.ProductSpecificationController;

/**
 * <h1>Data Access Object Implementation for Product Specification</h1>
 * implements data access object logic for Product specification functionality
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
@Transactional
@Repository("ProductSpecificationDao")
public class ProductSpecficationDaoImpl extends BaseDaoImpl implements ProductSpecificationDao {
    @PersistenceContext
    private EntityManager entityManager;
    private static final Logger log = LogManager.getLogger(ProductSpecficationDaoImpl.class);

    /**
     * createProductSpecification method creates user record in database and
     * return ProductSpecification entity object with generated primary key id.
     * 
     * @param ProductSpecification
     * @return ProductSpecification
     */
    @Override
    public ProductSpecification createProductSpecification(ProductSpecification productSpecification) {
        productSpecification = (ProductSpecification) create(productSpecification);
        return productSpecification;
    }

    /**
     * getproductSpecificationById method connect to database and return
     * ProductSpecification of particular PrimaryspecificationId.
     * 
     * @param primarySpecificationId
     * @return ProductSpecification
     */

    @Override
    public ProductSpecification getproductSpecificationById(Long primarySpecificationId) {
        log.info(" :: primarySpecificationId");
        if (log.isDebugEnabled()) {
            log.debug("ProductSpecificationDAOImpl primarySpecificationId : " + primarySpecificationId);
        }
        return fetchById(primarySpecificationId, ProductSpecification.class);
    }

    @Override
    public void saveProductSpecification(ProductSpecification productSpecification) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createNewProductSpecificationVersion(ProductSpecification productSpecification) {
        // TODO Auto-generated method stub

    }

    /**
     * searchProductSpecification method get search record from database
     * 
     * @param searchQuery
     * @return ProductSpecificationSearchEntity
     */
    @Override
    public List<ProductSpecificationSearchEntity> searchProductSpecification(String searchQuery) {

        String crit = "select primSpec.product_title,primSpec.specification_status,primSpec.commercial_status,primSpec.client_product_code,clintBus.business_code,clintCat.category_name from primary_specification primSpec join client_business clintBus on primSpec.business_unit = clintBus.client_business_id join client_category clintCat on primSpec.category = clintCat.client_category_id where "
                + searchQuery;
        Query query1 = entityManager.createNativeQuery(crit);

        List<Object[]> results = (List<Object[]>) query1.getResultList();

        List<ProductSpecificationSearchEntity> productSpecificationList = new ArrayList<ProductSpecificationSearchEntity>();
        ProductSpecificationSearchEntity ps = new ProductSpecificationSearchEntity();

        for (Object[] obj : results) {

            ps.setProductTitle("" + obj[0]);
            ps.setSpecificationStatus("" + obj[1]);
            ps.setCommercialStatus("" + obj[2]);
            ps.setClientProductCode("" + obj[3]);
            ps.setBusinessName("" + obj[4]);
            ps.setCategory("" + obj[5]);

            productSpecificationList.add(ps);

        }

        return productSpecificationList;

    }

    /**
     * saveSearch method save record in database and return ProductSpecification
     * entity object with generated primary key id.
     * 
     * @param ProductSpecification
     * @return ProductSpecification
     */
    @Override
    public ProductSpecificationSearchEntity saveSearch(
            ProductSpecificationSearchEntity productSpecificationSearchEntity) {

        productSpecificationSearchEntity = (ProductSpecificationSearchEntity) create(productSpecificationSearchEntity);

        System.out.println("saveSearch Dao Impl  Result:" + productSpecificationSearchEntity.toString());
        return productSpecificationSearchEntity;

    }

    @Override
    public void sendInvitations(Integer productSpecificationId, List<Integer> invitedUserIds) {
        // TODO Auto-generated method stub

    }

    @Override
    public ProductSpecification initiateCollaborativeDraft(ProductSpecification productSpecification) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductSpecification reOpenCollaboration(ProductSpecification productSpecification) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductSpecficationApprove> viewApproval(Integer projectSpecficationId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductSpecification> viewProductSpecificationHistory(Integer productSpecificationId) {
        // TODO Auto-generated method stub
        return null;
    }

}