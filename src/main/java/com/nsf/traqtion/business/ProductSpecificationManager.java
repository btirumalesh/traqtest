package com.nsf.traqtion.business;

import java.util.List;

import com.nsf.traqtion.data.entity.ProductSpecficationApprove;
import com.nsf.traqtion.data.entity.ProductSpecification;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationApproveDTO;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationDTO;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationSearchDTO;

/**
 * <h1>Business Manager Interface for Product Specification</h1> provides
 * business logic methods for Product specification functionality
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
public interface ProductSpecificationManager {

    /**
     * createProductSpecification method maps DTO to entity objects and creates
     * user record in database by making calls to Data access classes.
     * 
     * @param productSpecificationDTO
     * @return productSpecificationDTO
     */
    public ProductSpecificationDTO createProductSpecification(ProductSpecificationDTO productSpecificationDTO);

    public void saveProductSpecification(ProductSpecificationDTO productSpecificationDTO);

    public void createNewProductSpecificationVersion(ProductSpecification ProductSpecificationDTO);

    public List<ProductSpecificationSearchDTO> searchProductSpecification(String searchQuery);

    public ProductSpecificationSearchDTO saveSearch(ProductSpecificationSearchDTO productSpecificationSearchDTO);

    public void sendInvitations(Integer productSpecificationId, List<Integer> invitedUserIds);

    public ProductSpecificationDTO initiateCollaborativeDraft(ProductSpecification ProductSpecificationDTO);

    public ProductSpecificationDTO reOpenCollaboration(ProductSpecification ProductSpecificationDTO);

    public List<ProductSpecificationApproveDTO> viewApproval(Integer projectSpecficationId);

    public List<ProductSpecificationDTO> viewProductSpecificationHistory(Integer productSpecificationId);

    public Object getproductSpecificationById(Long primarySpecificationId);

}
