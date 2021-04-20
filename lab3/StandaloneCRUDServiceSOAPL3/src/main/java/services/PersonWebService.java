package services;

import errors.*;
import models.Person;
import models.PersonWithID;
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
            IllegalStateIdException, IllegalIdException {
        PersonFieldsChecker.checkAllFieldsCouldBeNull(person);
        return (new PostgreSQLDAO()).getPersons(person);
    }

    @WebMethod(operationName = "createPerson")
    @WebResult(name = "resultCode")
    public int createPerson(Person person) throws IllegalNameException, IllegalAgeException,
            IllegalRecommendedStatusException, IllegalStateIdException, IllegalIdException {
        PersonFieldsChecker.checkAllFieldsNotNull(person);
        return (new PostgreSQLDAO()).createPerson(person);
    }

    @WebMethod(operationName = "updatePerson")
    @WebResult(name = "resultCode")
    public int updatePerson(PersonWithID person) throws IllegalIdException, IllegalAgeException,
            IllegalNameException, IllegalStateIdException {
        PersonFieldsChecker.checkIdNotNull(person.getId());
        PersonFieldsChecker.checkAllFieldsCouldBeNull(person);
        return (new PostgreSQLDAO().updatePerson(person));
    }

    @WebMethod(operationName = "deletePerson")
    @WebResult(name = "resultCode")
    public int deletePerson(int id) throws IllegalIdException {
        PersonFieldsChecker.checkIdNotNull(id);
        return (new PostgreSQLDAO().deletePerson(id));
    }
}