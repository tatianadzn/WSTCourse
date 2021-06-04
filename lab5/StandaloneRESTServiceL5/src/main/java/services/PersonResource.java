package services;

import models.Person;
import models.PersonWithID;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@WebService
@Path("/persons")
public class PersonResource {
    private final String USER = "User";
    private final String PASSWORD = "Password";

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<PersonWithID> getPersons(@QueryParam("personWithID") String personWithID) {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonWithID> persons = null;
        try {
            PersonWithID p = mapper.readValue(personWithID, PersonWithID.class);
            persons = new PostgreSQLDAO().getPersons(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @POST
    @Produces({MediaType.TEXT_PLAIN})
    public String createPerson(@QueryParam("person") String person, @HeaderParam("Authorization") String authString){
        if (authorize(authString)){
            ObjectMapper mapper = new ObjectMapper();
            int id_res = -1;
            try {
                Person p = mapper.readValue(person, Person.class);
                id_res = new PostgreSQLDAO().createPerson(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
                return String.valueOf(id_res);

            } else {
                return "-1";
            }
    }

    @PUT
    @Produces({MediaType.TEXT_PLAIN})
    public String updatePerson(@QueryParam("personWithId") String personWithId, @HeaderParam("Authorization") String authString){
        if (authorize(authString)) {
            ObjectMapper mapper = new ObjectMapper();
            int status = 0;
            try {
                PersonWithID p = mapper.readValue(personWithId, PersonWithID.class);
                status = new PostgreSQLDAO().updatePerson(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return String.valueOf(status);
        } else {
            return "0";
        }
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    public String deletePerson(@QueryParam("id") String id, @HeaderParam("Authorization") String authString) {
        if (authorize(authString)) {
            return String.valueOf(new PostgreSQLDAO().deletePerson(Integer.parseInt(id)));
        } else {
            return "-1";
        }
    }

    private boolean authorize(String authString) {
        String authStr = new String(Base64.getDecoder().decode(authString)).replaceFirst("Basic"
                + " ", "");
        if (authStr.matches("[A-z]*:[A-z0-9?.^_\\-*]*")) {
            String user = authStr.substring(0, authStr.indexOf(':'));
            String pswd = authStr.substring(authStr.indexOf(':') + 1);

            return user.equals(USER) && pswd.equals(PASSWORD);
        } else {
            return false;
        }
    }
}
