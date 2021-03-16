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

}