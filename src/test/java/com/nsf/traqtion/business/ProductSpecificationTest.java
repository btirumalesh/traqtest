package com.nsf.traqtion.business;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsf.traqtion.model.common.ResponseBody;
import com.nsf.traqtion.model.produtSpecification.ProductSpecificationDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false) 
public class ProductSpecificationTest {
    private static final Logger log = LogManager.getLogger(ProductSpecificationTest.class);
    ObjectMapper mapper = new ObjectMapper();

    RestTemplate restTemplate = new RestTemplate();
    final String createProductSpecificationURL = "http://localhost:7070/NSFTraqtion/restservice/productSpecifications/createProductSpecification";

    // Testing create user service :: POST Request
    @Test
    public void createProductSpecification() {

        try {
            ProductSpecificationDTO p = new ProductSpecificationDTO();
            Date date = new Date();
            p.setPrimarySpecificationName("Mahesh");
            p.setPrimarySpecificationSequenceNo("HHH143");
            p.setClientId(1000);
            p.setSpecificationType("ClientDraft");
            p.setBusinessUnit("vennala");
            p.setOwner("owner");
            p.setClientProductCode("asdgsdg");
            p.setProductTitle("Title");
            p.setBrand("numer1");
            p.setCategory("many");
            p.setPrimaryVersionNo("ad333");
            p.setProductImagePath("dsagsadglksdag");
            p.setCommercialStatus("active");
            p.setSpecificationStatus("skadlglkg");
            p.setCreatedBy(2335);
            p.setUpdatedBy(2324);
            p.setSpecificationCreationDate(date);
            p.setCreationDate(date);
            p.setUpdatedDate(date);
        
            log.info("Sample ProductSpecification object created to access createURL");
            final HttpEntity<ProductSpecificationDTO> request = new HttpEntity<>(p);
            ResponseBody responseBody = restTemplate.postForObject(createProductSpecificationURL, request,
                    ResponseBody.class);
            log.info("Called REST Service to create productSpecification");
            log.info("Response from REST Service >> " + responseBody);
            assertThat(responseBody, notNullValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
