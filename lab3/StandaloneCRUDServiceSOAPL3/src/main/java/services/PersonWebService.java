package services;

import errors.*;
import models.Person;
import models.PersonWithID;
import utils.ExceptionThrower;
import utils.PersonFieldsChecker;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "PersonService")
public class PersonWebService {

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
        PersonFieldsChecker.checkIdNotNull(id);
        int status_code = (new PostgreSQLDAO().deletePerson(id));
        if (status_code != 1) {
            ExceptionThrower.throwBadQueryResponseException("no person with id=" + id, "cannot delete person");
        }
        return status_code;
    }
}