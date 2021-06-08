package services;

import exceptions.IllegalNameException;
import exceptions.IllegalAgeException;
import exceptions.IllegalStateIdException;
import models.Person;
import models.PersonWithID;
import org.codehaus.jackson.map.ObjectMapper;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

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
    public String createPerson(@QueryParam("person") String person) throws IllegalNameException, IllegalAgeException, IllegalStateIdException {
        ObjectMapper mapper = new ObjectMapper();
        int id_res = -1;
        try {
            Person p = mapper.readValue(person, Person.class);
            if (p.getFirstName() == null || p.getFirstName().trim().isEmpty())
                throw IllegalNameException.DEFAULT_INSTANCE;
            if (p.getLastName() == null || p.getLastName().trim().isEmpty())
                throw IllegalNameException.DEFAULT_INSTANCE;
            if (p.getAge() == null || (p.getAge() < 18))
                throw IllegalAgeException.DEFAULT_INSTANCE;
            if (p.getStateId() == null || (p.getStateId() < 1 || p.getStateId() > 50))
                throw IllegalStateIdException.DEFAULT_INSTANCE;
            id_res = new PostgreSQLDAO().createPerson(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(id_res);
    }

    @PUT
    @Produces({MediaType.TEXT_PLAIN})
    public String updatePerson(@QueryParam("personWithId") String personWithId) throws IllegalNameException, IllegalAgeException, IllegalStateIdException {
        ObjectMapper mapper = new ObjectMapper();
        int status = 0;
        try {
            PersonWithID p = mapper.readValue(personWithId, PersonWithID.class);
            if (p.getFirstName().trim().isEmpty())
                throw IllegalNameException.DEFAULT_INSTANCE;
            if (p.getLastName().trim().isEmpty())
                throw IllegalNameException.DEFAULT_INSTANCE;
            if (p.getAge() != null && (p.getAge() < 18))
                throw IllegalAgeException.DEFAULT_INSTANCE;
            if (p.getStateId() != null && (p.getStateId() < 1 || p.getStateId() > 50))
                throw IllegalStateIdException.DEFAULT_INSTANCE;
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
