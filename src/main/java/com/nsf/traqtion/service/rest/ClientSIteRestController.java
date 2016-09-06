package com.nsf.traqtion.service.rest;

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
import org.springframework.web.bind.annotation.RestController;

import com.nsf.traqtion.business.ClientSiteMgmtBl;
import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientSite;
import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.model.clientmgmt.ClientContactDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteDto;
import com.nsf.traqtion.model.clientmgmt.ClientSiteFacilityDto;
import com.nsf.traqtion.model.clientmgmt.ClientSiteNotificationDTO;
import com.nsf.traqtion.model.common.ResponseBody;

/**
 * UserRestController class is Rest Controller for User Management module. This
 * class exposes the services for creating, modifying, viewing etc.. operations.
 * 
 * @author HTC Global Services
 */

@RestController
@RequestMapping(value = "/clients")

public class ClientSIteRestController extends BaseService {

    private static final Logger log = LogManager.getLogger(ClientSIteRestController.class);

    // Autowiring Business class
    @Autowired
    private ClientSiteMgmtBl clientSiteMgmtBl;

    /**
     * addSiteDetails is rest service POST method which takes Client object and
     * creates ClientSite in system and returns ClientSite object with unique
     * ClientSiteId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> addSiteDetails(@PathVariable("clientId") Long clientId,
            @RequestBody ClientSiteDto clientSiteDto) {
        log.info("createUser  ::");
        HttpStatus status = HttpStatus.FOUND;
        Object siteObj = null;
        try {
            if (clientSiteDto.getClient() == null) {
                Client clientObj = new Client();
                clientObj.setClientId(clientId);
                clientSiteDto.setClient(clientObj);
            }

            // Call to business method for creating using by passing user
            // request object
            siteObj = clientSiteMgmtBl.saveClientSite(clientSiteDto);
            if (null == siteObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(siteObj, status);

    }

    /**
     * editSiteDetails is rest service PUT method which takes Client object and
     * creates ClientSite in system and returns ClientSite object with unique
     * ClientSiteId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{sitesId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editSiteDetails(@PathVariable("clientId") Long clientId,
            @RequestBody ClientSiteDto clientSiteDto) {
        log.info("createUser  ::");
        HttpStatus status = HttpStatus.FOUND;
        Object siteObj = null;
        try {
            if (clientSiteDto.getClient() == null) {
                Client clientObj = new Client();
                clientObj.setClientId(clientId);
                clientSiteDto.setClient(clientObj);
            }

            siteObj = clientSiteMgmtBl.saveClientSite(clientSiteDto);
            if (null == siteObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(siteObj, status);

    }

    /**
     * getClientSites is rest service GET method, which takes client id as path
     * parameter and return appropriate ClientSite object.
     * 
     * @param ClientId
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getClientSites(@PathVariable("clientId") Long clientId) {
        log.info("getUserById info:: ");
        log.debug("getClientSites Id :: " + clientId);
        HttpStatus status = HttpStatus.FOUND;
        Object clientSiteDto = null;
        try {
            clientSiteDto = clientSiteMgmtBl.getClientSiteInfo(clientId);
            if (null == clientSiteDto) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(clientSiteDto, status);

    }

    @RequestMapping(value = "/{clientId}/sites/{sitesId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> deleteClientSite(@PathVariable("sitesId") String sitesId,
            @RequestBody ClientSiteDto deleteSite) {
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("ClientMgmtController :: deleteClientSite:: ");
            log.debug("clientSiteId :: " + sitesId);
            // Call to business method to process the request by passing client
            boolean methodStatus = clientSiteMgmtBl.deleteClienSiteId(sitesId, deleteSite);
            if (!methodStatus) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(deleteSite, status);
    }

    /**
     * addClientSiteFacility is rest service POST method which takes Site object
     * and creates ClientSiteFaclility in system and returns ClientSiteFaclility
     * object with unique ClientSiteFacilityId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/facilities", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveClientSiteFacilities(@PathVariable("clientId") Long clientId,
            @PathVariable("clientSiteId") Long clientSiteId, @RequestBody ClientSiteFacilityDto clientSiteFacilityDtO) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            log.info("ClientSiteRestController :: saveClientSiteFacilities");
            log.debug("save Client ClientSiteFacilities details under " + "client Id :: " + clientId + "and Site Id :: "
                    + clientSiteId);
            // Call to business method to process the request by passing client
            ClientSite clientSite = new ClientSite();
            clientSite.setClientSitesId(clientSiteId);
            clientSiteFacilityDtO.setClientSite(clientSite);
            docObj = clientSiteMgmtBl.saveClientSiteFacilities(clientId, clientSiteFacilityDtO);
            if (null == docObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docObj, status);
    }

    /**
     * Get All Notification of client rest service GET method, The system
     * searches database for all Notifications in scope client site
     * 
     * @param clientId
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/facilities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getAllFacilities(@PathVariable("clientId") Long clientId,
            @PathVariable("clientSiteId") Long clientSiteId) {
        HttpStatus status = HttpStatus.FOUND;
        Object docList = null;
        try {
            log.info("ClientSiteRestController :: getAllFacilities ");
            log.debug("Get all Client Site Facility details under " + "client Id :: " + clientId + "and Site Id :: "
                    + clientSiteId);
            // Call to business method to process the request by passing client
            docList = clientSiteMgmtBl.getAllFacilitiesByClientSiteId(clientSiteId);
            if (null == docList) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docList, status);
    }

    /**
     * edit site facility of clientSite rest service PUT method, The system
     * searches database for exiting facility in scope client site
     * 
     * @param Facility
     * @return RequestMapping<ResponseBody>
     */

    @RequestMapping(value = "/{clientId}/sites/{siteId}/facilities/{clientSiteFacilityId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editClientFacilities(@PathVariable("siteId") Long siteId,
            @RequestBody ClientSiteFacilityDto clientSiteFacilityDto) {
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("editClientSIteFacilityDetails info:: ");
            log.debug("editClientDetails Id :: " + clientSiteFacilityDto.getClientSiteFacilityId());
            ClientSite clientSite = new ClientSite();
            clientSite.setClientSitesId(siteId);
            clientSiteFacilityDto.setClientSite(clientSite);
            // Call to business method to process the request by passing client
            clientSiteFacilityDto = clientSiteMgmtBl.editClientSiteFacilitiesByClientId(clientSiteFacilityDto);
            if (null == clientSiteFacilityDto) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(clientSiteFacilityDto, status);
    }

    /**
     * save Client Site notification rest service PUT method, which takes
     * ClientSiteNotificationDTO as parameter and return appropriate user
     * object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/notification", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveClientSiteNotification(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId,
            @RequestBody ClientSiteNotificationDTO clientSiteNotificationDTO) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            log.info("ClientRestController :: saveClientSiteNotification");
            log.debug("save Client Site Notification details under " + "client Id :: " + clientId + "and Site Id :: "
                    + clientSiteId);

            // Call to business method to process the request by passing client
            docObj = clientSiteMgmtBl.saveClientSiteNotification(clientId, clientSiteNotificationDTO);
            if (null == docObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docObj, status);
    }

    /**
     * Edit Client Site notification rest service PUT method, which takes
     * ClientSiteNotificationDTO as parameter and return appropriate user
     * object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/notification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editClientSiteNotification(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId,
            @RequestBody ClientSiteNotificationDTO clientSiteNotificationDTO) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            log.info("ClientRestController :: saveClientSiteNotification");
            log.debug("save Client Site Notification details under " + "client Id :: " + clientId + "and Site Id :: "
                    + clientSiteId);

            // Call to business method to process the request by passing client
            docObj = clientSiteMgmtBl.saveClientSiteNotification(clientId, clientSiteNotificationDTO);
            if (null == docObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docObj, status);
    }

    /**
     * Get All Notification of client rest service GET method, The system
     * searches database for all Notifications in scope client site
     * 
     * @param clientId
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/notification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getAllNotifications(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId) {
        HttpStatus status = HttpStatus.FOUND;
        Object docList = null;
        try {
            log.info("ClientRestController :: getAllNotifications ");
            log.debug("Get all Client Site Notification details under " + "client Id :: " + clientId + "and Site Id :: "
                    + clientSiteId);

            // Call to business method to process the request by passing client
            docList = clientSiteMgmtBl.getAllNotificationsByClientSiteId(clientSiteId);
            if (null == docList) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docList, status);
    }

    /**
     * Get All the contact Details of cline is rest service PUT method, which
     * takes user id as path parameter and return appropriate user object.
     * 
     * @param clientId
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{siteId}/contacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getSiteContact(@PathVariable("siteId") Long siteId) {
        HttpStatus status = HttpStatus.FOUND;
        Object contactList = null;
        try {
            log.info("siteId info:: ");
            log.debug("siteId Id :: " + siteId);

            // Call to business method to process the request by passing client
            contactList = clientSiteMgmtBl.getContactDetailsBySite(siteId);
            if (null == contactList) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }

        return prepareResponse(contactList, status);
    }

    /**
     * saveClientContact is rest service POST method which takes user object and
     * creates user in system and returns user object with unique userId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{siteId}/contacts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveClientContact(@RequestBody ClientContactDTO clientContactDTO,
            @PathVariable("clientId") Long clientId, @PathVariable("siteId") Long siteId) {
        log.info("ClientMgmtController :: saveClientContact");
        HttpStatus status = HttpStatus.OK;
        Object contactObj = null;
        try {
            log.info("inside try block :: ClientMgmtController :: saveClientContact");
            // Call to business method to process the request by passing client
            contactObj = clientSiteMgmtBl.saveClientContact(clientId, siteId, clientContactDTO);
            if (null == contactObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(contactObj, status);
    }

    /**
     * saveClientContact is rest service POST method which takes user object and
     * creates user in system and returns user object with unique userId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{siteId}/contacts/{contactsId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editClientContact(@RequestBody ClientContactDTO clientContactDTO,
            @PathVariable("clientId") Long clientId, @PathVariable("siteId") Long siteId,
            @PathVariable("contactsId") Long contactsId) {
        log.info("ClientMgmtController :: editClientContact");
        HttpStatus status = HttpStatus.OK;
        Object contactObj = null;
        try {
            log.info("inside try block :: ClientMgmtController :: editClientContact");
            clientContactDTO.setClientContactId(contactsId);
            // Call to business method to process the request by passing client
            contactObj = clientSiteMgmtBl.saveClientContact(clientId, siteId, clientContactDTO);
            if (null == contactObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(contactObj, status);
    }

    /**
     * 
     * @param userId
     * @param saveUserRequest
     * @return
     */
    @RequestMapping(value = "/{clientId}/sites/{siteId}/contacts/{contactsId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> deleteClientContact(@PathVariable("contactsId") Long contactsId) {
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("ClientMgmtController :: deleteClientContact:: ");
            log.debug("clientContact Id :: " + contactsId);

            // Call to business method to process the request by passing client
            boolean methodStatus = clientSiteMgmtBl.deleteClientContact(contactsId);
            if (!methodStatus) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(true, status);
    }

    /**
     * Get All the Document of client site as rest service GET method, The
     * system searches database for all the Document details that are in scope
     * for the client site
     * 
     * @param clientId,clientSiteId
     * @return RequestMapping<ResponseBody>
     */

    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/docs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getAllDocumnetDetails(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId) {
        HttpStatus status = HttpStatus.FOUND;
        Object docList = null;
        try {
            log.info("getClientContact info:: ");
            log.debug("getClientContact Id :: " + clientSiteId);

            // Call to business method to process the request by passing client
            docList = clientSiteMgmtBl.getAllDocumnetDetailsByClinetSiteId(clientSiteId);
            if (null == docList) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docList, status);
    }

    /**
     * saveDocument as rest service POST method to create new Doc, which takes
     * clientSiteId as path parameter and return appropriate user object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/docs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveClientsSiteDocumentInfo(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId, @RequestBody ClientSiteDocumentDTO clientSiteDoc) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            docObj = clientSiteMgmtBl.mergeClientSiteDocumentInfo(clientSiteId, clientSiteDoc);
            if (null == docObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docObj, status);
    }

    /**
     * editDocument is rest service POST method to Edit existing Doc, which
     * takes clientId as path parameter and return appropriate user object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/docs", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editClientsSiteDocumentInfo(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId, @RequestBody ClientSiteDocumentDTO clientSiteDoc) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            docObj = clientSiteMgmtBl.mergeClientSiteDocumentInfo(clientSiteId, clientSiteDoc);
            if (null == docObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docObj, status);
    }

    /**
     * deleteDocument is rest service PUT method to Delete existing Doc, which
     * takes takes clientId as path parameter and return appropriate user
     * object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/sites/{clientSiteId}/docs/{docId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> deleteClientSiteDocumentInfo(@PathVariable("clientId") Integer clientId,
            @PathVariable("clientSiteId") Integer clientSiteId, @PathVariable("docId") Integer docId) {
        HttpStatus status = HttpStatus.FOUND;
        boolean docObj = false;
        try {
            docObj = clientSiteMgmtBl.deleteClientSiteDocumentInfo(docId);
            if (false == docObj) {
                status = HttpStatus.NOT_FOUND;
                throw new NSFException(NSFExceptionType.INVALID_TOKEN);
            }
        } catch (NSFException nsfEx) {
            log.error(nsfEx.getMessage());
            return prepareResponse(nsfEx, status);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return prepareResponse(ex, status);
        }
        return prepareResponse(docObj, status);
    }

}
