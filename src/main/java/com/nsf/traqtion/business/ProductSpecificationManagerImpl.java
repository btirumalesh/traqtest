package com.nsf.traqtion.business;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsf.traqtion.data.dao.ProductSpecificationDao;
import com.nsf.traqtion.data.entity.ProductSpecification;
import com.nsf.traqtion.data.entity.ProductSpecificationSearchEntity;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationApproveDTO;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationDTO;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationSearchDTO;

/**
 * <h1>Business Manager for Product Specification</h1> implements the business
 * logic for Product specification functionality
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
@Service("productSpecificationBusiness")
public class ProductSpecificationManagerImpl implements ProductSpecificationManager {
    private static final Logger log = LogManager.getLogger("ProductSpecificationBLImpl");
    // autowiring ProductSpecificationDao class
    @Autowired
    private ProductSpecificationDao productSpecificationDao;
    private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    /**
     * createProductSpecification method maps DTO to entity objects and creates
     * user record in database by making calls to Data access classes.
     * 
     * @param ProductSpecificationDTO
     * @return ProductSpecificationDTO
     */
    @Override
    public ProductSpecificationDTO createProductSpecification(ProductSpecificationDTO ProductSpecificationDTO) {
        log.info(":: create ProductSpecification");
        ProductSpecification productSpecificationEntity = null;
        if (ProductSpecificationDTO != null) {
            productSpecificationEntity = getModelMapper().map(ProductSpecificationDTO, ProductSpecification.class);
            // call to dao method
            productSpecificationDao.createProductSpecification(productSpecificationEntity);
            // TODO change this code to set id properly
            // ProductSpecificationDTO.setPrimarySpecificationId(productSpecificationEntity.getPrimarySpecificationId());
        }
        return ProductSpecificationDTO;
    }

    /**
     * getFormattedQuery method will return query formatted String
     * 
     * @param columnName
     * @return value
     */

    public String getFormattedQuery(String columnName, String value) {

        StringBuffer sb = new StringBuffer();

        value = value.replace("*", "%");

        sb.append(" and " + columnName + "=" + "\"" + value + "\"");

        return sb.toString();
    }

    /**
     * getproductSpecificationById method making calls to Data access classes.
     * 
     * @param specificationId
     * @return Object
     */

    @Override
    public Object getproductSpecificationById(Long primarySpecificationId) {
        return productSpecificationDao.getproductSpecificationById(primarySpecificationId);
    }

    /**
     * getClientPrivilege method making calls to Data access classes.
     * 
     * @param clientId
     * @return String
     */

    @Override
    public void createNewProductSpecificationVersion(ProductSpecification ProductSpecificationDTO) {
        // TODO Auto-generated method stub

    }

    /**
     * searchProductSpecification method maps DTO to entity objects and gets
     * list of records from database based on search Query criteria.
     * 
     * @param searchQuery
     */

    @Override
    public List<ProductSpecificationSearchDTO> searchProductSpecification(String searchQuery) {

        List<ProductSpecificationSearchEntity> productSpecificationEntityList = productSpecificationDao
                .searchProductSpecification(searchQuery);
        List<ProductSpecificationSearchDTO> productSpecificationDtoList = null;

        if (productSpecificationEntityList != null) {
            productSpecificationDtoList = new ArrayList<ProductSpecificationSearchDTO>();
            for (ProductSpecificationSearchEntity prodspec : productSpecificationEntityList) {

                ProductSpecificationSearchDTO productSpecificationsearchDto = new ProductSpecificationSearchDTO();

                productSpecificationsearchDto.setProductTitle(prodspec.getProductTitle());
                productSpecificationsearchDto.setCommercialStatus(prodspec.getCommercialStatus());
                productSpecificationsearchDto.setBrand(prodspec.getBrand());
                productSpecificationsearchDto.setBusinessName(prodspec.getBusinessName());
                productSpecificationsearchDto.setCategory(prodspec.getCategory());
                productSpecificationsearchDto.setClientProductCode(prodspec.getClientProductCode());
                productSpecificationsearchDto.setCreatedBy(prodspec.getCreatedBy());
                productSpecificationsearchDto.setSiteCode(prodspec.getSiteCode());
                productSpecificationsearchDto.setSiteName(prodspec.getSiteName());
                productSpecificationsearchDto.setSpecificationOwner(prodspec.getSpecificationOwner());
                productSpecificationsearchDto.setSystemProductCode(prodspec.getSystemProductCode());
                productSpecificationsearchDto.setSpecificationStatus(prodspec.getSpecificationStatus());
                productSpecificationsearchDto.setSpecificationType(prodspec.getSpecificationType());
                productSpecificationsearchDto.setSupplierCode(prodspec.getSupplierCode());
                productSpecificationsearchDto.setSupplierName(prodspec.getSupplierName());

                productSpecificationDtoList.add(productSpecificationsearchDto);
            }
        }
        return productSpecificationDtoList;

    }

    /**
     * saveSearch method maps DTO to Entity objects and save record into
     * database and return saved record with unique id
     * 
     * @param ProductSpecificationDTO
     * @return ProductSpecificationDTO
     */
    @Override
    public ProductSpecificationSearchDTO saveSearch(ProductSpecificationSearchDTO productSpecificationSearchDTO) {

        ProductSpecificationSearchEntity productSpecificationSearchEntity = null;

        if (productSpecificationSearchDTO != null) {
            productSpecificationSearchEntity = getModelMapper().map(productSpecificationSearchDTO,
                    ProductSpecificationSearchEntity.class);

            productSpecificationSearchEntity = productSpecificationDao.saveSearch(productSpecificationSearchEntity);

            productSpecificationSearchDTO = getModelMapper().map(productSpecificationSearchEntity,
                    ProductSpecificationSearchDTO.class);

        }
        return productSpecificationSearchDTO;
    }

    @Override
    public void sendInvitations(Integer productSpecificationId, List<Integer> invitedUserIds) {
        // TODO Auto-generated method stub

    }

    @Override
    public ProductSpecificationDTO initiateCollaborativeDraft(ProductSpecification ProductSpecificationDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductSpecificationDTO reOpenCollaboration(ProductSpecification ProductSpecificationDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductSpecificationApproveDTO> viewApproval(Integer projectSpecficationId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductSpecificationDTO> viewProductSpecificationHistory(Integer productSpecificationId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveProductSpecification(ProductSpecificationDTO productSpecificationDTO) {
        // TODO Auto-generated method stub

    }
}
