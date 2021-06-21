package services;

import errors.*;
import models.Person;
import models.PersonWithID;
import utils.ExceptionThrower;
import utils.PersonFieldsChecker;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(serviceName = "PersonService")
public class PersonWebService {

    @Resource
    WebServiceContext webServiceContext;

    @WebMethod(operationName = "getPersons")
    @WebResult(name = "person")
    public List<PersonWithID> getPersons(PersonWithID person) throws IllegalAgeException, IllegalNameException,
            IllegalStateIdException, IllegalIdException, SQLException {
        PersonFieldsChecker.checkAllFieldsCouldBeNull(person);
        return (new PostgreSQLDAO()).getPersons(person);
    }

    @WebMethod(operationName = "createPerson")
    @WebResult(name = "resultCode")
    public int createPerson(Person person) throws IllegalNameException, IllegalAgeException,
            IllegalRecommendedStatusException, IllegalStateIdException, IllegalIdException, BadQueryResponseException, SQLException {

        checkAuth();

        PersonFieldsChecker.checkAllFieldsNotNull(person);
        int id_res = (new PostgreSQLDAO()).createPerson(person);
        if (id_res == -1) {
            ExceptionThrower.throwBadQueryResponseException("create query failed", "cannot create person");
        }
        return id_res;
    }

    @WebMethod(operationName = "updatePerson")
    @WebResult(name = "resultCode")
    public int updatePerson(PersonWithID person) throws IllegalIdException, IllegalAgeException,
            IllegalNameException, IllegalStateIdException, IllegalUpdatePersonSetException, BadQueryResponseException, SQLException {

        checkAuth();

        PersonFieldsChecker.checkIdNotNull(person.getId());
        PersonFieldsChecker.checkAllFieldsCouldBeNull(person);
        PersonFieldsChecker.isAllFieldsNull(person);
        int status_code = (new PostgreSQLDAO().updatePerson(person));
        if (status_code != 1) {
            ExceptionThrower.throwBadQueryResponseException("no person with id=" + person.getId(), "cannot update person");
        }
        return status_code;
    }

    @WebMethod(operationName = "deletePerson")
    @WebResult(name = "resultCode")
    public int deletePerson(int id) throws IllegalIdException, BadQueryResponseException, SQLException {

        checkAuth();

        PersonFieldsChecker.checkIdNotNull(id);
        int status_code = (new PostgreSQLDAO().deletePerson(id));
        if (status_code != 1) {
            ExceptionThrower.throwBadQueryResponseException("no person with id=" + id, "cannot delete person");
        }
        return status_code;
    }

    private void checkAuth() throws BadQueryResponseException {
        MessageContext messageContext = webServiceContext.getMessageContext();
        Map httpHeaders = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List auths = (List) httpHeaders.get("Authorization");
        if (auths == null) {
            throw new BadQueryResponseException("No authorization provided", PersonServiceFault.defaultInstance());
        }
        String auth = auths.get(0).toString();
        String authEncoded = auth.split(" ")[1];
        String[] credentials = (new String(Base64.getDecoder().decode(authEncoded))).split(":");

        if (!credentials[0].equals("user") || !credentials[1].equals("password")){
            throw new BadQueryResponseException("Bad authorization", PersonServiceFault.defaultInstance());
        }
    }
}