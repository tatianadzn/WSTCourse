
package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonWebService", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<services.PersonWithID>
     * @throws IllegalStateIdException
     * @throws IllegalNameException
     * @throws IllegalIdException
     * @throws IllegalAgeException
     * @throws SQLException
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://services/", className = "services.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://services/", className = "services.GetPersonsResponse")
    @Action(input = "http://services/PersonWebService/getPersonsRequest", output = "http://services/PersonWebService/getPersonsResponse", fault = {
        @FaultAction(className = IllegalAgeException.class, value = "http://services/PersonWebService/getPersons/Fault/IllegalAgeException"),
        @FaultAction(className = IllegalNameException.class, value = "http://services/PersonWebService/getPersons/Fault/IllegalNameException"),
        @FaultAction(className = IllegalStateIdException.class, value = "http://services/PersonWebService/getPersons/Fault/IllegalStateIdException"),
        @FaultAction(className = IllegalIdException.class, value = "http://services/PersonWebService/getPersons/Fault/IllegalIdException"),
        @FaultAction(className = SQLException.class, value = "http://services/PersonWebService/getPersons/Fault/SQLException")
    })
    public List<PersonWithID> getPersons(
        @WebParam(name = "arg0", targetNamespace = "")
        PersonWithID arg0)
        throws IllegalAgeException, IllegalIdException, IllegalNameException, IllegalStateIdException, SQLException
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     * @throws IllegalStateIdException
     * @throws BadQueryResponseException
     * @throws IllegalIdException
     * @throws IllegalNameException
     * @throws IllegalAgeException
     * @throws IllegalRecommendedStatusException
     * @throws SQLException
     */
    @WebMethod
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://services/", className = "services.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://services/", className = "services.CreatePersonResponse")
    @Action(input = "http://services/PersonWebService/createPersonRequest", output = "http://services/PersonWebService/createPersonResponse", fault = {
        @FaultAction(className = IllegalNameException.class, value = "http://services/PersonWebService/createPerson/Fault/IllegalNameException"),
        @FaultAction(className = IllegalAgeException.class, value = "http://services/PersonWebService/createPerson/Fault/IllegalAgeException"),
        @FaultAction(className = IllegalRecommendedStatusException.class, value = "http://services/PersonWebService/createPerson/Fault/IllegalRecommendedStatusException"),
        @FaultAction(className = IllegalStateIdException.class, value = "http://services/PersonWebService/createPerson/Fault/IllegalStateIdException"),
        @FaultAction(className = IllegalIdException.class, value = "http://services/PersonWebService/createPerson/Fault/IllegalIdException"),
        @FaultAction(className = BadQueryResponseException.class, value = "http://services/PersonWebService/createPerson/Fault/BadQueryResponseException"),
        @FaultAction(className = SQLException.class, value = "http://services/PersonWebService/createPerson/Fault/SQLException")
    })
    public int createPerson(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0)
        throws BadQueryResponseException, IllegalAgeException, IllegalIdException, IllegalNameException, IllegalRecommendedStatusException, IllegalStateIdException, SQLException
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     * @throws IllegalStateIdException
     * @throws BadQueryResponseException
     * @throws IllegalUpdatePersonSetException
     * @throws IllegalNameException
     * @throws IllegalIdException
     * @throws IllegalAgeException
     * @throws SQLException
     */
    @WebMethod
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://services/", className = "services.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://services/", className = "services.UpdatePersonResponse")
    @Action(input = "http://services/PersonWebService/updatePersonRequest", output = "http://services/PersonWebService/updatePersonResponse", fault = {
        @FaultAction(className = IllegalIdException.class, value = "http://services/PersonWebService/updatePerson/Fault/IllegalIdException"),
        @FaultAction(className = IllegalAgeException.class, value = "http://services/PersonWebService/updatePerson/Fault/IllegalAgeException"),
        @FaultAction(className = IllegalNameException.class, value = "http://services/PersonWebService/updatePerson/Fault/IllegalNameException"),
        @FaultAction(className = IllegalStateIdException.class, value = "http://services/PersonWebService/updatePerson/Fault/IllegalStateIdException"),
        @FaultAction(className = IllegalUpdatePersonSetException.class, value = "http://services/PersonWebService/updatePerson/Fault/IllegalUpdatePersonSetException"),
        @FaultAction(className = BadQueryResponseException.class, value = "http://services/PersonWebService/updatePerson/Fault/BadQueryResponseException"),
        @FaultAction(className = SQLException.class, value = "http://services/PersonWebService/updatePerson/Fault/SQLException")
    })
    public int updatePerson(
        @WebParam(name = "arg0", targetNamespace = "")
        PersonWithID arg0)
        throws BadQueryResponseException, IllegalAgeException, IllegalIdException, IllegalNameException, IllegalStateIdException, IllegalUpdatePersonSetException, SQLException
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     * @throws BadQueryResponseException
     * @throws IllegalIdException
     * @throws SQLException
     */
    @WebMethod
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://services/", className = "services.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://services/", className = "services.DeletePersonResponse")
    @Action(input = "http://services/PersonWebService/deletePersonRequest", output = "http://services/PersonWebService/deletePersonResponse", fault = {
        @FaultAction(className = IllegalIdException.class, value = "http://services/PersonWebService/deletePerson/Fault/IllegalIdException"),
        @FaultAction(className = BadQueryResponseException.class, value = "http://services/PersonWebService/deletePerson/Fault/BadQueryResponseException"),
        @FaultAction(className = SQLException.class, value = "http://services/PersonWebService/deletePerson/Fault/SQLException")
    })
    public int deletePerson(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BadQueryResponseException, IllegalIdException, SQLException
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws BadBinaryAttachmentException
     */
    @WebMethod
    @RequestWrapper(localName = "upload", targetNamespace = "http://services/", className = "services.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://services/", className = "services.UploadResponse")
    @Action(input = "http://services/PersonWebService/uploadRequest", output = "http://services/PersonWebService/uploadResponse", fault = {
        @FaultAction(className = BadBinaryAttachmentException.class, value = "http://services/PersonWebService/upload/Fault/BadBinaryAttachmentException")
    })
    public void upload(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        byte[] arg1)
        throws BadBinaryAttachmentException
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     * @throws BadBinaryAttachmentException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "download", targetNamespace = "http://services/", className = "services.Download")
    @ResponseWrapper(localName = "downloadResponse", targetNamespace = "http://services/", className = "services.DownloadResponse")
    @Action(input = "http://services/PersonWebService/downloadRequest", output = "http://services/PersonWebService/downloadResponse", fault = {
        @FaultAction(className = BadBinaryAttachmentException.class, value = "http://services/PersonWebService/download/Fault/BadBinaryAttachmentException")
    })
    public byte[] download(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws BadBinaryAttachmentException
    ;

}
