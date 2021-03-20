package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @Resource(lookup = "jdbc/mydb")
    private DataSource dataSource;

    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(String id, String first_name, String last_name,
                                   String age, String state_id, String is_recommended) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons(id, first_name, last_name, age, state_id, is_recommended);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}