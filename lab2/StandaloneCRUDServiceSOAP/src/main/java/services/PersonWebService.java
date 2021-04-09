package services;

import models.Person;
import models.PersonWithID;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "PersonService")
public class PersonWebService {

    @WebMethod(operationName = "getPersons")
    @WebResult(name = "person")
    public List<PersonWithID> getPersons(PersonWithID person) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getPersons(person);
    }

    @WebMethod(operationName = "createPerson")
    @WebResult(name = "resultCode")
    public int createPerson(Person person){
        return (new PostgreSQLDAO()).createPerson(person);
    }

    @WebMethod(operationName = "updatePerson")
    @WebResult(name = "resultCode")
    public int updatePerson(PersonWithID person){
        return (new PostgreSQLDAO().updatePerson(person));
    }

    @WebMethod(operationName = "deletePerson")
    @WebResult(name = "resultCode")
    public int deletePerson(int id){
        return (new PostgreSQLDAO().deletePerson(id));
    }
}