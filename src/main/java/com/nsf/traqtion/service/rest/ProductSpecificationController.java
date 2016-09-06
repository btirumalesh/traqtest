package com.nsf.traqtion.service.rest;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsf.traqtion.business.ProductSpecificationManager;
import com.nsf.traqtion.business.ProductSpecificationManagerImpl;
import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.model.common.NSFConstants;
import com.nsf.traqtion.model.common.ResponseBody;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationDTO;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationSearchDTO;

/**
 * <h1>Rest Controller for Product Specification</h1> implements the
 * presentation layer for Product specification functionality
 *
 * @author HTC Global Services
 * @version 1.0
 * @since 2016-08-01
 */
@RestController
@RequestMapping(value = "/productSpecifications")
public class ProductSpecificationController extends BaseService {

    private static final Logger log = LogManager.getLogger(ProductSpecificationController.class);

    // Autowiring Business class
    @Autowired
    private ProductSpecificationManager productSpecificationBusiness;

    /**
     * createProductSpecification is rest service POST method which takes user
     * object and creates user in system and returns ProductSpecification object
     * with unique productSpecificationId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "createProductSpecification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> createProductSpecification(
            @RequestBody ProductSpecificationDTO createProductSpecificationRequest) {

        HttpStatus status = HttpStatus.OK;

        try {
            log.info("createProductSpecification  ::");

            createProductSpecificationRequest = productSpecificationBusiness
                    .createProductSpecification(createProductSpecificationRequest);
            if (null == createProductSpecificationRequest) {
                status = HttpStatus.BAD_REQUEST;
                throw new NSFException(NSFExceptionType.INVALID_USER_DATA);
            }
        } catch (Exception nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        }
        return prepareResponse(createProductSpecificationRequest, status);

    }

    /**
     * getprimarySpecificationId is rest service GET method, which takes
     * getproductSpecificationById as path parameter and returns
     * primaryspecification.
     * 
     * @return ResponseEntity<ResponseBody>
     */

    @RequestMapping(value = "/{primarySpecificationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getproductSpecificationById(
            @PathVariable("primarySpecificationId") long primarySpecificationId) {
        Object client = null;
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("getprimarySpecificationDetailsById info:: ");
            log.debug("getprimarySpecificationDetails Id :: " + primarySpecificationId);

            // Call to business method to process the request by passing
            // primarySpecificationId
            client = productSpecificationBusiness.getproductSpecificationById(primarySpecificationId);
            if (null == client) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (Exception nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        }
        return prepareResponse(client, status);
    }

    /**
     * searchProductSpecification service is GET method which takes params as
     * search criteria and return list of objects
     * 
     * @return ResponseEntity<ResponseBody>
     */

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> searchProductSpecification(@RequestParam("params") String searchCriteria)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProductSpecificationSearchDTO searchCriteriaProductSpecification = (ProductSpecificationSearchDTO) objectMapper
                .readValue(searchCriteria, ProductSpecificationSearchDTO.class);

        log.info("Search Product Specification :: " + searchCriteria);

        ProductSpecificationManagerImpl prodspecManagerImpl = new ProductSpecificationManagerImpl();

        List<ProductSpecificationSearchDTO> productSpecificationSearchResults = null;
        HttpStatus status = HttpStatus.OK;

        StringBuffer formattedQuery = new StringBuffer();

        if (searchCriteriaProductSpecification.getProductTitle() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.PRODUCT_TITLE,
                    searchCriteriaProductSpecification.getProductTitle()));

        }
        if (searchCriteriaProductSpecification.getCategory() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.CATEGORY,
                    searchCriteriaProductSpecification.getCategory()));

        }

        if (searchCriteriaProductSpecification.getSpecificationStatus() != null) {

            formattedQuery.append(
                    prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SPECIFICATION_STATUS,
                            searchCriteriaProductSpecification.getSpecificationStatus()));

        }

        if (searchCriteriaProductSpecification.getBrand() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.BRAND,
                    searchCriteriaProductSpecification.getBrand()));

        }

        if (searchCriteriaProductSpecification.getCommercialStatus() != null) {

            formattedQuery
                    .append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.COMMERCIAL_STATUS,
                            searchCriteriaProductSpecification.getCommercialStatus()));

        }
        if (searchCriteriaProductSpecification.getCreatedBy() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.CREATED_BY,
                    searchCriteriaProductSpecification.getCreatedBy()));

        }
        if (searchCriteriaProductSpecification.getSpecificationOwner() != null) {

            formattedQuery
                    .append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SPECIFICATION_OWNER,
                            searchCriteriaProductSpecification.getSpecificationOwner()));

        }

        if (searchCriteriaProductSpecification.getSpecificationType() != null) {

            formattedQuery
                    .append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SPECIFICATION_TYPE,
                            searchCriteriaProductSpecification.getSpecificationType()));

        }

        if (searchCriteriaProductSpecification.getClientProductCode() != null) {

            formattedQuery
                    .append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.CLIENT_PRODUCT_CODE,
                            searchCriteriaProductSpecification.getClientProductCode()));

        }
        if (searchCriteriaProductSpecification.getBusinessName() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.BUSINESS_NAME,
                    searchCriteriaProductSpecification.getBusinessName()));

        }

        if (searchCriteriaProductSpecification.getSiteCode() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SITE_CODE,
                    searchCriteriaProductSpecification.getSiteCode()));

        }
        if (searchCriteriaProductSpecification.getSiteName() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SITE_NAME,
                    searchCriteriaProductSpecification.getSiteName()));

        }

        if (searchCriteriaProductSpecification.getSystemProductCode() != null) {

            formattedQuery
                    .append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SYSTEM_PRODUCT_CODE,
                            searchCriteriaProductSpecification.getSystemProductCode()));

        }
        if (searchCriteriaProductSpecification.getSupplierName() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SUPPLIER_NAME,
                    searchCriteriaProductSpecification.getSupplierName()));

        }
        if (searchCriteriaProductSpecification.getSupplierCode() != null) {

            formattedQuery.append(prodspecManagerImpl.getFormattedQuery(NSFConstants.ProductSpecification.SUPPLIER_CODE,
                    searchCriteriaProductSpecification.getSupplierCode()));

        }

        if (" and ".equals(formattedQuery.toString().substring(0, 5)))
            formattedQuery = new StringBuffer(formattedQuery.substring(5, formattedQuery.length()));

        if (searchCriteriaProductSpecification.getCategoryType().equalsIgnoreCase("myCategory")) {
            // formattedQuery.append("and primSpec.category in (select
            // client_category_id from client_category where
            // client_id="+1000+")");
            formattedQuery
                    .append("and primSpec.category in (select client_category_id from client_category where client_id="
                            + searchCriteriaProductSpecification.getClientId() + ")");
        } else if (searchCriteriaProductSpecification.getCategoryType().equalsIgnoreCase("allCategory")) {
            formattedQuery.append("and primSpec.category in (select client_category_id from client_category)");
        }

        log.info("Query formatted String ::" + formattedQuery);

        try {

            productSpecificationSearchResults = productSpecificationBusiness
                    .searchProductSpecification(formattedQuery.toString());

            // return prepareResponse(productSpecificationSearchResults,
            // status);
        } catch (NSFException nsf) {
            // return prepareResponse(productSpecificationSearchResults,
            // status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
        } catch (Exception e) {
            // return prepareResponse(productSpecificationSearchResults, status,
            // false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());
        }
        return prepareResponse(productSpecificationSearchResults, status);
    }

    /**
     * saveProductSpecificationSearch service is POST method which takes DTO
     * object to save the list of selected values in database and it will return
     * object with unique id
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/savedsearches", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveProductSpecificationSearch(
            @RequestBody ProductSpecificationSearchDTO productSpecificationSearcDTO) {

        // log.info("ClientMgmtController :: saveClientContact");

        HttpStatus status = HttpStatus.OK;

        try {

            log.info("saveProductSpecificationSearch ::");

            productSpecificationSearcDTO = productSpecificationBusiness.saveSearch(productSpecificationSearcDTO);

            if (null == productSpecificationSearcDTO) {
                status = HttpStatus.BAD_REQUEST;
                throw new NSFException(NSFExceptionType.DATA_EXCEPTION);
            }

        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            // return prepareResponse(null,
            // status,false,1001,nsfEx.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            // return prepareResponse(null, status,false,1001,ex.getMessage());
        }
        return prepareResponse(productSpecificationSearcDTO, status);
    }

}
