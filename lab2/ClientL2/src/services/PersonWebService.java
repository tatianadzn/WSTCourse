
package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
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
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://services/", className = "services.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://services/", className = "services.GetPersonsResponse")
    @Action(input = "http://services/PersonWebService/getPersonsRequest", output = "http://services/PersonWebService/getPersonsResponse")
    public List<PersonWithID> getPersons(
        @WebParam(name = "arg0", targetNamespace = "")
        PersonWithID arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://services/", className = "services.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://services/", className = "services.CreatePersonResponse")
    @Action(input = "http://services/PersonWebService/createPersonRequest", output = "http://services/PersonWebService/createPersonResponse")
    public int createPerson(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://services/", className = "services.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://services/", className = "services.UpdatePersonResponse")
    @Action(input = "http://services/PersonWebService/updatePersonRequest", output = "http://services/PersonWebService/updatePersonResponse")
    public int updatePerson(
        @WebParam(name = "arg0", targetNamespace = "")
        PersonWithID arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://services/", className = "services.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://services/", className = "services.DeletePersonResponse")
    @Action(input = "http://services/PersonWebService/deletePersonRequest", output = "http://services/PersonWebService/deletePersonResponse")
    public int deletePerson(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
