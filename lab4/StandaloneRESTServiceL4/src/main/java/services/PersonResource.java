package services;

import models.PersonWithID;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@WebService
@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    @GET
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
}
