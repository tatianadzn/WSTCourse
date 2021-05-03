package com.restful.EEServiceRESTful;

import org.codehaus.jackson.map.ObjectMapper;

import javax.annotation.Resource;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Path("/persons")
public class PersonResource {
    @Resource(lookup = "jdbc/mydb")
    private DataSource dataSource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonWithID> getPersons(@QueryParam("personWithID") String personWithID) {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonWithID> persons = null;
        try {
            PersonWithID p = mapper.readValue(personWithID, PersonWithID.class);
            System.out.println(p);
            persons = new PostgreSQLDAO(getConnection()).getPersons(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}