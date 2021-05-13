package services;

import models.Person;
import models.PersonWithID;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@WebService
@Path("/persons")
public class PersonResource {
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
    public String createPerson(@QueryParam("person") String person){
        ObjectMapper mapper = new ObjectMapper();
        int id_res = -1;
        try {
            Person p = mapper.readValue(person, Person.class);
            id_res = new PostgreSQLDAO().createPerson(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(id_res);
    }

    @PUT
    @Produces({MediaType.TEXT_PLAIN})
    public String updatePerson(@QueryParam("personWithId") String personWithId){
        ObjectMapper mapper = new ObjectMapper();
        int status = 0;
        try {
            PersonWithID p = mapper.readValue(personWithId, PersonWithID.class);
            status = new PostgreSQLDAO().updatePerson(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(status);
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    public String deletePerson(@QueryParam("id") String id) {
        return String.valueOf(new PostgreSQLDAO().deletePerson(Integer.parseInt(id)));
    }
}
