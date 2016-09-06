package com.nsf.traqtion.data.dao;

import java.util.List;

import com.nsf.traqtion.data.entity.ProductSpecficationApprove;
import com.nsf.traqtion.data.entity.ProductSpecification;
import com.nsf.traqtion.data.entity.ProductSpecificationSearchEntity;

/**
 * <h1>Data Access Object Interface for Product Specification</h1> provides data
 * access object logic methods for Product specification functionality
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
public interface ProductSpecificationDao {
    /**
     * createProductSpecification method creates user record in database and
     * return user entity object with generated primary key id.
     * 
     * @param productSpecification
     * @return productSpecification
     */
    public ProductSpecification createProductSpecification(ProductSpecification productSpecification);

    public void saveProductSpecification(ProductSpecification productSpecification);

    public void createNewProductSpecificationVersion(ProductSpecification productSpecification);

    public List<ProductSpecificationSearchEntity> searchProductSpecification(String searchQuery);

    public ProductSpecificationSearchEntity saveSearch(ProductSpecificationSearchEntity productSpecificationSearchEntity);

    public void sendInvitations(Integer productSpecificationId, List<Integer> invitedUserIds);

    public ProductSpecification initiateCollaborativeDraft(ProductSpecification productSpecification);

    public ProductSpecification reOpenCollaboration(ProductSpecification productSpecification);

    public List<ProductSpecficationApprove> viewApproval(Integer projectSpecficationId);

    public List<ProductSpecification> viewProductSpecificationHistory(Integer productSpecificationId);

    public ProductSpecification getproductSpecificationById(Long primarySpecificationId);

}
