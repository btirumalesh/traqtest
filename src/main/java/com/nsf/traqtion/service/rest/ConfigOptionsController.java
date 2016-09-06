package com.nsf.traqtion.service.rest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nsf.traqtion.business.config.ClientConfigManager;
import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.model.common.LookupDTO;
import com.nsf.traqtion.model.common.ResponseBody;
import com.nsf.traqtion.model.usermgmt.SecurityQuestionsDTO;

@RestController
@RequestMapping(value = "/config/options")
public class ConfigOptionsController extends BaseService{
	private static final Logger log = LogManager.getLogger(ConfigOptionsController.class);
	
	// Autowiring Business class
	@Autowired
	private ClientConfigManager clientConfigBusiness;

	/**
	 * getSupplierNamesByClientId is rest service GET method, which takes client id as request parameter and return appropriate supplier names.
	 * @param clientId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/suppliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getSupplierNamesByClientId(@RequestParam("clientId") BigInteger clientId) {
		List<LookupDTO> lookUpDtoList = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing clientId
		try{
			lookUpDtoList = clientConfigBusiness.getSupplierNamesByClientId(clientId);
		}catch(NSFException nsf){
		//return prepareResponse(lookUpDtoList, status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
		}catch (Exception e){
		//return prepareResponse(lookUpDtoList, status, false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());	
		}
		return prepareResponse(lookUpDtoList, status);
	}
	
	@RequestMapping(value = "/companies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getCompanyOptions() {
		
		log.info("getJobTitleByClientId  ::");
		HttpStatus status = HttpStatus.OK;
		List<LookupDTO> companyTypeList = null;
		try{
			//TODO call business method
			 companyTypeList = new ArrayList<LookupDTO>();			 
			 companyTypeList=(List<LookupDTO>) clientConfigBusiness.geCompanyType();
		}catch(NSFException nsfEx){
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		}catch(Exception ex){
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		}
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		return  prepareResponse(companyTypeList, status);
	
	}
	
	@RequestMapping(value = "/getRole", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getRoleList(@RequestParam("clientId") Integer clientId) {		
		HttpStatus status = HttpStatus.OK;
		List<LookupDTO> lookUpList = null;
		try{
			//TODO call business method
			lookUpList = new ArrayList<LookupDTO>();			
			lookUpList=(List<LookupDTO>) clientConfigBusiness.geRoleList(clientId);
		}catch(NSFException nsfEx){
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		}catch(Exception ex){
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		}
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		return  prepareResponse(lookUpList, status);
	
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getCategoryList(@RequestParam("clientId") Integer clientId) {
		
		HttpStatus status = HttpStatus.OK;
		List<LookupDTO> lookUpList = null;
		try{
			//TODO call business method
			lookUpList = new ArrayList<LookupDTO>();
			lookUpList=(List<LookupDTO>) clientConfigBusiness.getCategoryList(clientId);
		}catch(NSFException nsfEx){
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		}catch(Exception ex){
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		}
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		return  prepareResponse(lookUpList, status);
	
	}
	
	/**
	 * getFacilityOptionsBySupplierId is rest service GET method, which takes supplierId as request parameter and return appropriate FacilityOptions.
	 * @param supplierId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/facilities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getFacilityOptionsBySupplierId(@RequestParam("supplierId") BigInteger supplierId) {
		List<LookupDTO> lookUpDtoList = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing supplierId
		try{
			lookUpDtoList = clientConfigBusiness.getFacilitiesBySupplierTypeId(supplierId);
		}catch(NSFException nsf){
		//return prepareResponse(lookUpDtoList, status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
		}catch (Exception e){
		//return prepareResponse(lookUpDtoList, status, false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());	
		}
		return prepareResponse(lookUpDtoList, status);
	}
	
	/**
	 * getServiceProviderOptionsByClientId is rest service GET method, which takes clientId as Request parameter and return appropriate ServiceProvider names.
	 * @param clientId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/servProvider", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getServiceProviderOptionsByClientId(@RequestParam("clientId") BigInteger clientId) {
		List<LookupDTO> lookUpDtoList = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing clientId
		try{
			lookUpDtoList = clientConfigBusiness.getServiceProviderNamesByClientId(clientId);
		}catch(NSFException nsf){
		//return prepareResponse(lookUpDtoList, status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
		}catch (Exception e){
		//return prepareResponse(lookUpDtoList, status, false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());	
		}
		return prepareResponse(lookUpDtoList, status);
	}
		
	/**
	 * getServiceProviderOptionsByClientId is rest service GET method, which takes clientId as Request parameter and return appropriate ServiceProvider names.
	 * @param supplierId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/servTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getServiceTypeOptionsBySrviceProviderId(@RequestParam("srvPrvdrId") BigInteger srvPrvdrId) {
		List<LookupDTO> lookUpDtoList = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing srvPrvdrId
		try{
			lookUpDtoList = clientConfigBusiness.getServiceTypesByServiceProviderId(srvPrvdrId);
		}catch(NSFException nsf){
	//	return prepareResponse(lookUpDtoList, status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
		}catch (Exception e){
	//	return prepareResponse(lookUpDtoList, status, false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());	
		}
		return prepareResponse(lookUpDtoList, status);
	}
	
	/**
	 * getJobTitleOptionsByClientId is rest service GET method, which takes clientId as Request parameter and return appropriate ServiceProvider JobTitles.
	 * @param supplierId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getJobTitleOptionsByClientId(@RequestParam("clientId") BigInteger clientId) {
		List<LookupDTO> lookUpDtoList = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing clientId
		try{
			lookUpDtoList = clientConfigBusiness.getJobTitleOptionsByClientId(clientId);
		}catch(NSFException nsf){
	//	return prepareResponse(lookUpDtoList, status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
		}catch (Exception e){
	//	return prepareResponse(lookUpDtoList, status, false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());	
		}
		return prepareResponse(lookUpDtoList, status);
	}
	
	/**
	 * getLanguageOptionsByClientId is rest service GET method, which takes clientId as Request parameter and return appropriate ServiceProvider languages.
	 * @param clientId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/languages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getLanguageOptionsByClientId(@RequestParam("clientId") BigInteger clientId) {
		List<LookupDTO> lookUpDtoList = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing clientId
		try{
			lookUpDtoList = clientConfigBusiness.getLanguageOptionsByClientId(clientId);
		}catch(NSFException nsf){
//		return prepareResponse(lookUpDtoList, status,false,Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),nsf.getNSFExceptionType().getErrorMessage());
		}catch (Exception e){
//		return prepareResponse(lookUpDtoList, status, false,Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());	
		}
		return prepareResponse(lookUpDtoList, status);
	}
		
	 /**
	  * getSecurityQuestions is rest service GET method which returns All security Questions list .
	  * @param 
	  * @return securityQuestionsDTO
	  */
	@RequestMapping(value="/securityQuestions", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<ResponseBody> getSecurityQuestions(){
	      log.info("getSecurityQuestions:");
	     
	      HttpStatus status = HttpStatus.OK;
	      List <SecurityQuestionsDTO> securityQuestionsDTO = clientConfigBusiness.getSecurityQuestions();
			
	      return prepareResponse(securityQuestionsDTO, status);

	  } 
	
	@RequestMapping(value = "/getSites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getSitesByClientId(@RequestParam("clientId") BigInteger clientId) {
        List<LookupDTO> lookUpDtoList = null;
        HttpStatus status = HttpStatus.OK;
        // Call to business method to process the request by passing clientId
        try {
            lookUpDtoList = clientConfigBusiness.getSitesByClientId(clientId);
        } catch (NSFException nsf) {
            /*return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),
                    nsf.getNSFExceptionType().getErrorMessage());*/
        } catch (Exception e) {
           /* return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),
                    NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());*/
        }
        return prepareResponse(lookUpDtoList, status);
    }

	

    @RequestMapping(value = "/getSupplier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getSupplierBySupplierId(@RequestParam("supplierId") BigInteger supplierId) {
        List<LookupDTO> lookUpDtoList = null;
        HttpStatus status = HttpStatus.OK;
        // Call to business method to process the request by passing clientId
        try {
            lookUpDtoList = clientConfigBusiness.getSupplierBySupplierId(supplierId);
        } catch (NSFException nsf) {
            /*return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),
                    nsf.getNSFExceptionType().getErrorMessage());*/
        } catch (Exception e) {
           /* return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),
                    NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());*/
        }
        return prepareResponse(lookUpDtoList, status);
    }
	
	
    @RequestMapping(value = "/categoriesByBusinessId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getCategoryOptionsByBusinessId(@RequestParam("clientId") BigInteger clientId,
            @RequestParam("businessId") BigInteger businessId) {

        HttpStatus status = HttpStatus.OK;
        List<LookupDTO> lookUpList = null;
        try {
            // TODO call business method
            lookUpList = new ArrayList<LookupDTO>();
            lookUpList = (List<LookupDTO>) clientConfigBusiness.getCategoryOptionsByBusinessId(clientId, businessId);
        } catch (NSFException nsfEx) {
            //return prepareResponse(null, status, false, 1001, "Invalid username password");
        } catch (Exception ex) {
            //return prepareResponse(null, status, false, 1001, "Invalid username password");
        }
        // return prepareResponse(null, status,false,1001,"Invalid username
        // password");
        return prepareResponse(lookUpList, status);
    }
    
    @RequestMapping(value = "/getSitesBySupplierId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getSitesBySupplierId(@RequestParam("supplierId") BigInteger supplierId) {
        List<LookupDTO> lookUpDtoList = null;
        HttpStatus status = HttpStatus.OK;
        // Call to business method to process the request by passing clientId
        try {
            lookUpDtoList = clientConfigBusiness.getSitesBySupplierId(supplierId);
        } catch (NSFException nsf) {
            /*return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),
                    nsf.getNSFExceptionType().getErrorMessage());*/
        } catch (Exception e) {
           /* return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),
                    NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());*/
        }
        return prepareResponse(lookUpDtoList, status);
    }
    
    
    @RequestMapping(value = "/getbusinessByClientId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getbusinessByClientId(@RequestParam("clientId") BigInteger clientId) {
        List<LookupDTO> lookUpDtoList = null;
        HttpStatus status = HttpStatus.OK;
        // Call to business method to process the request by passing clientId
        try {
            lookUpDtoList = clientConfigBusiness.getbusinessByClientId(clientId);
        } catch (NSFException nsf) {
            /*return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(nsf.getNSFExceptionType().getErrorCode()),
                    nsf.getNSFExceptionType().getErrorMessage());*/
        } catch (Exception e) {
           /* return prepareResponse(lookUpDtoList, status, false,
                    Integer.parseInt(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode()),
                    NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage());*/
        }
        return prepareResponse(lookUpDtoList, status);
    }
    
    /**
     * getClientPrivilege is rest service GET method, which takes user id as
     * pathparameter and returns privilege of client.
     * 
     * @return ResponseEntity<ResponseBody>
     */

    @RequestMapping(value = "/client/privilege/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getClientPrivilegeByClientId(@PathVariable("clientId") Integer clientId) {
        Object client = null;
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("getClientDetailsById info:: ");
            log.debug("getClientDetails Id :: " + clientId);

            // Call to business method to process the request by passing clientId
            client = clientConfigBusiness.getClientPrivilegeByClientId(clientId);
            if (null == client) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } 
        catch (Exception nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx,status);
        }
        return prepareResponse(client, status);
    }

    
    

}

