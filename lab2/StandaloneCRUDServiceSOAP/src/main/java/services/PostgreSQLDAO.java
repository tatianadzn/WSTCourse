package services;

import models.Person;
import models.PersonWithID;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    public List<PersonWithID> getPersons(PersonWithID person){
        List<PersonWithID> personSelections = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()){
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


    public int createPerson(Person person){
        int id_res = -1;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(buildCreateQuery(person));

            while (rs.next()){
                id_res = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_res;
    }

    public int updatePerson(PersonWithID person){
        int rs = 0;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            rs = stmt.executeUpdate(buildUpdateQuery(person));

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int deletePerson (int id){
        int rs = 0;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            String query = "delete from persons where id=" + id;

            rs = stmt.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
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

    private String buildUpdateQuery(PersonWithID person){
        StringBuilder query = new StringBuilder("update persons set ");
        List<String> queryArgs = new ArrayList<>();
        if (person.getFirstName() != null)
            queryArgs.add("first_name = '" + person.getFirstName() + "'");
        if (person.getLastName() != null)
            queryArgs.add("last_name = '" + person.getLastName() + "'");
        if (person.getAge() != null)
            queryArgs.add("age = " + person.getAge());
        if (person.getStateId() != null)
            queryArgs.add("state_id = " + person.getStateId());
        if (person.getIsRecommended() != null)
            queryArgs.add("is_recommended = " + person.getIsRecommended());

        if (queryArgs.size() == 0) {
            //throw error
        }

        for (int i = 0; i < queryArgs.size() - 1; i++) {
            query.append(queryArgs.get(i));
            query.append(", ");
        }
        query.append(queryArgs.get(queryArgs.size() - 1));
        query.append(" where id=").append(person.getId());
        return query.toString();
    }

    private String buildCreateQuery(Person person){
        return "INSERT INTO persons(first_name, last_name, age, is_recommended, state_id) " +
                "values (\'" + person.getFirstName() + "\', \'" + person.getLastName() + "\', " +
                person.getAge() + ", " + person.getStateId() + ", " + person.getIsRecommended() + ") returning id;";
    }
}