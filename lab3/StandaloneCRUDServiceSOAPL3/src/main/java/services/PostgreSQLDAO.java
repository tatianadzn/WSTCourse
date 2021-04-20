package services;

import models.Person;
import models.PersonWithID;
import utils.ExceptionThrower;
import utils.QueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLDAO {

    public List<PersonWithID> getPersons(PersonWithID person) throws errors.SQLException {
        List<PersonWithID> personSelections = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(QueryBuilder.buildSelectQuery(person));
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
            ExceptionThrower.throwSQLException("database connection failed", "cannot get persons");
        }
        return personSelections;
    }


    public int createPerson(Person person) throws errors.SQLException {
        int id_res = -1;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(QueryBuilder.buildCreateQuery(person));

            while (rs.next()){
                id_res = rs.getInt("id");
            }
        } catch (SQLException ex){
            ExceptionThrower.throwSQLException("database connection failed", "cannot create person");
        }
        return id_res;
    }

    public int updatePerson(PersonWithID person) throws errors.SQLException {
        int rs = -1;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            rs = stmt.executeUpdate(QueryBuilder.buildUpdateQuery(person));

        } catch (SQLException ex) {
            ExceptionThrower.throwSQLException("database connection failed", "cannot update person");
        }
        return rs;
    }

    public int deletePerson (int id) throws errors.SQLException {
        int rs = -1;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            String query = "delete from persons where id=" + id;

            rs = stmt.executeUpdate(query);

        } catch (SQLException ex) {
            ExceptionThrower.throwSQLException("database connection failed", "cannot delete person");
        }
        return rs;
    }

}