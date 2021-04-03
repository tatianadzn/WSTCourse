package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    public List<Person> getPersons(String id, String first_name, String last_name,
                                   String age, String state_id, String is_recommended) {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();


            ResultSet rs = stmt.executeQuery(buildQuery(id, first_name, last_name,
                                                        age, state_id, is_recommended));

            while (rs.next()) {
                int personId = rs.getInt("id");
                String personFirstName = rs.getString("first_name");
                String personLastName = rs.getString("last_name");
                int personAge = rs.getInt("age");
                int personStateId = rs.getInt("state_id");
                boolean personIsRecommended = rs.getBoolean("is_recommended");

                Person person = new Person(personId, personFirstName, personLastName, personAge,
                                            personStateId, personIsRecommended);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persons;
    }

    public int createPerson(String first_name, String last_name,
                                   String age, String state_id, String is_recommended){
        int id_res = -1;
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO persons(first_name, last_name, age, is_recommended, state_id) " +
                    "values (\'" + first_name + "\', \'" + last_name + "\', " +
                                  age + ", " + state_id + ", " + is_recommended + ") returning id;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                id_res = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_res;
    }

    private String buildQuery (String id, String first_name, String last_name,
                               String age, String state_id, String is_recommended){
        StringBuilder query = new StringBuilder("select * from persons");
        List<String> queryArgs = new ArrayList<>();
        if (id != null)
            queryArgs.add("id = " + id + " ");
        if (first_name != null)
            queryArgs.add("first_name = '" + first_name + "' ");
        if (last_name != null)
            queryArgs.add("last_name = '" + last_name + "' ");
        if (age != null)
            queryArgs.add("age = " + age + " ");
        if (state_id != null)
            queryArgs.add("state_id = " + state_id + " ");
        if (is_recommended != null)
            queryArgs.add("is_recommended = " + is_recommended + " ");

        for (int i = 0; i < queryArgs.size(); i++) {
            if (i == 0)
                query.append(" where ");
            else query.append(" and ");
            query.append(queryArgs.get(i));
        }
        return query.toString();
    }
}