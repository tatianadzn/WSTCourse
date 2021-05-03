package com.restful.EEServiceRESTful;

import org.codehaus.jackson.map.ObjectMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    Connection connection;

    public PostgreSQLDAO(Connection connection){
        this.connection = connection;
    }

    public List<PersonWithID> getPersons(PersonWithID person){
        List<PersonWithID> personSelections = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(buildSelectQuery(person));
            while(rs.next()){
                personSelections.add(new PersonWithID(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getInt("state_id"),
                        rs.getBoolean("is_recommended")));
            }
        } catch (SQLException ex){
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personSelections;
    }

    private String buildSelectQuery(PersonWithID person){
        StringBuilder query = new StringBuilder("select * from persons");
        List<String> queryArgs = new ArrayList<>();
        if (person.getId() != null)
            queryArgs.add("id = " + person.getId() + " ");
        if (person.getFirstName() != null)
            queryArgs.add("first_name = '" + person.getFirstName() + "' ");
        if (person.getLastName() != null)
            queryArgs.add("last_name = '" + person.getLastName() + "' ");
        if (person.getAge() != null)
            queryArgs.add("age = " + person.getAge() + " ");
        if (person.getStateId() != null)
            queryArgs.add("state_id = " + person.getStateId() + " ");
        if (person.getIsRecommended() != null)
            queryArgs.add("is_recommended = " + person.getIsRecommended() + " ");

        for (int i = 0; i < queryArgs.size(); i++) {
            if (i == 0)
                query.append(" where ");
            else query.append(" and ");
            query.append(queryArgs.get(i));
        }
        query.append(" order by id");
        return query.toString();
    }
}