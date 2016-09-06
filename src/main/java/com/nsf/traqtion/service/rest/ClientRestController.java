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

import com.nsf.traqtion.business.ClientMgmtBL;
import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.model.clientmgmt.ClientContactDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteNotificationDTO;
import com.nsf.traqtion.model.common.ResponseBody;

/**
 * <h1>Controller for Client Management</h1> Provides the Rest Services for
 * Client Management
 * <p>
 * 
 * @author HTC Global Services
 */

@RestController
@RequestMapping(value = "/clients")
public class ClientRestController extends BaseService {

    private static final Logger log = LogManager.getLogger(ClientRestController.class);

    @Autowired
    private ClientMgmtBL clientMgmt;

    /**
     * getClientDetailsById is rest service GET method, which takes user id as
     * path parameter and return appropriate user object.
     * 
     * @param userId
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getClientDetailsById(@PathVariable("clientId") Integer clientId) {
        Object client = null;
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("getClientDetailsById info:: ");
            log.debug("getClientDetails Id :: " + clientId);

            // Call to business method to process the request by passing
            // clientId
            client = clientMgmt.getClientDetailsById(clientId);
            if (null == client) {
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
        return prepareResponse(client, status);
    }

    /**
     * editClientDetails is rest service PUT method, which takes user id as path
     * parameter and return appropriate user object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editClientDetails(@RequestBody ClientDTO client) {
        HttpStatus status = HttpStatus.FOUND;
        try {
            log.info("editClientDetails info:: ");
            // log.debug("editClientDetails Id :: " + client.getClientId());

            // Call to business method to process the request by passing client
            client = clientMgmt.editClientDetailsByClientId(client);
            if (null == client) {
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
        return prepareResponse(client, status);
    }

    /**
     * saveDocument is rest service POST method to create new Doc, which takes
     * clientId as path parameter and return appropriate user object.
     * 
     * @param client
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/docs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveDocument(@PathVariable("clientId") Integer clientId,
            @RequestBody ClientDocumentDTO clientDoc) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            docObj = clientMgmt.mergeDocument(clientId, clientDoc);
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
    @RequestMapping(value = "/{clientId}/docs/{docId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editDocument(@PathVariable("clientId") Integer clientId,
            @RequestBody ClientDocumentDTO clientDoc) {
        HttpStatus status = HttpStatus.FOUND;
        Object docObj = null;
        try {
            docObj = clientMgmt.mergeDocument(clientId, clientDoc);
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
    @RequestMapping(value = "/{clientId}/docs/{docId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> deleteDocument(@PathVariable("docId") Integer docId) {
        HttpStatus status = HttpStatus.FOUND;
        boolean docObj = false;
        try {
            docObj = clientMgmt.deleteDocumentDetails(docId);
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

    /**
     * Get All the Document of cline is rest service GET method, The system
     * searches database for all the Contact details that are in scope for the
     * client
     * 
     * @param clientId
     * @return RequestMapping<ResponseBody>
     */

    @RequestMapping(value = "/{clientId}/docs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getAllDocumnetDetails(@PathVariable("clientId") Integer clientId) {
        HttpStatus status = HttpStatus.FOUND;
        Object docList = null;
        try {
            log.info("getClientContact info:: ");
            log.debug("getClientContact Id :: " + clientId);

            // Call to business method to process the request by passing client
            docList = clientMgmt.getAllDocumnetDetailsByClinetId(clientId);
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
     * saveClientContact is rest service POST method which takes user object and
     * creates user in system and returns user object with unique userId.
     * 
     * @return ResponseEntity<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/contacts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> saveClientContact(@RequestBody ClientContactDTO clientContactDTO,
            @PathVariable("clientId") Integer clientId) {
        log.info("ClientMgmtController :: saveClientContact");
        HttpStatus status = HttpStatus.OK;
        Object contactObj = null;
        try {
            log.info("inside try block :: ClientMgmtController :: saveClientContact");
            // Call to business method to process the request by passing client
            contactObj = clientMgmt.saveClientContact(clientId, clientContactDTO);
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
     * Get All the contact Details of cline is rest service PUT method, which
     * takes user id as path parameter and return appropriate user object.
     * 
     * @param clientId
     * @return RequestMapping<ResponseBody>
     */
    @RequestMapping(value = "/{clientId}/contacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> getClientContact(
            @PathVariable("clientId") Integer clientId/*
                                                       * @PathVariable(
                                                       * "contactId") Integer
                                                       * contactId
                                                       */) {
        HttpStatus status = HttpStatus.FOUND;
        Object contactList = null;
        try {
            log.info("getClientContact info:: ");
            log.debug("getClientContact Id :: " + clientId);

            // Call to business method to process the request by passing client
            contactList = clientMgmt.getContactByClientId(clientId);
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
    @RequestMapping(value = "/{clientId}/contacts/{contactId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> editClientContact(@RequestBody ClientContactDTO clientContactDTO,
            @PathVariable("clientId") Integer clientId, @PathVariable("contactId") Integer contactId) {
        log.info("ClientMgmtController :: editClientContact");
        HttpStatus status = HttpStatus.OK;
        Object contactObj = null;
        try {
            log.info("inside try block :: ClientMgmtController :: editClientContact");
            clientContactDTO.setClientContactId(contactId.longValue());
            // Call to business method to process the request by passing client
            contactObj = clientMgmt.saveClientContact(clientId, clientContactDTO);
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
    @RequestMapping(value = "/{clientId}/contacts/{contactId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> deleteClientContact(@PathVariable("clientContactId") Integer clientContactId) {
        HttpStatus status = HttpStatus.FOUND;
        boolean methodStatus = false;
        try {
            log.info("ClientMgmtController :: deleteClientContact:: ");
            log.debug("clientContact Id :: " + clientContactId);

            // Call to business method to process the request by passing client
            methodStatus = clientMgmt.deleteClientContact(clientContactId);
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
        return prepareResponse(methodStatus,status);
    }

}