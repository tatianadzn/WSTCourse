package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(String id, String first_name, String last_name, String age, String state_id, String is_recommended) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons(id, first_name, last_name, age, state_id, is_recommended);
        return persons;
    }

    @WebMethod(operationName = "createPerson")
    public int createPerson(String first_name, String last_name, String age, String state_id, String is_recommended){
        return (new PostgreSQLDAO()).createPerson(first_name, last_name, age, state_id, is_recommended);
    }

    @WebMethod(operationName = "updatePerson")
    public int updatePerson(int id, String first_name, String last_name, String age, String state_id, String is_recommended){
        return (new PostgreSQLDAO().updatePerson(id, first_name, last_name, age, state_id, is_recommended));
    }

    @WebMethod(operationName = "deletePerson")
    public int deletePerson(int id){
        return (new PostgreSQLDAO().deletePerson(id));
    }
}