package utils;

import models.Person;
import models.PersonWithID;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    public static String buildSelectQuery(PersonWithID person){
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

    public static String buildUpdateQuery(PersonWithID person){
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

        for (int i = 0; i < queryArgs.size() - 1; i++) {
            query.append(queryArgs.get(i));
            query.append(", ");
        }
        query.append(queryArgs.get(queryArgs.size() - 1));
        query.append(" where id=").append(person.getId());
        return query.toString();
    }

    public static String buildCreateQuery(Person person){
        return "INSERT INTO persons(first_name, last_name, age, state_id, is_recommended) " +
                "values (\'" + person.getFirstName() + "\', \'" + person.getLastName() + "\', " +
                person.getAge() + ", " + person.getStateId() + ", " + person.getIsRecommended() + ") returning id;";
    }
}
