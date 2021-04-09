package utils;

import services.Person;
import services.PersonWithID;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Parsers {
    public static Vector<String> parseNRequestArgs(Scanner scanner){
        Vector<String> arg = new Vector<>();
        while (scanner.hasNext()){
            String temp = scanner.next();
            if (temp.equals("null")) {
                arg.add(null);
            } else {
                arg.add(temp);
            }
        }
        return arg;
    }

    public static Person parsePerson(Vector<String> arg, int size) throws IOException {
        if (arg.size() != size)
            throw new IOException("Expected " + size + " arguments, got " + arg.size());
        Person person = new Person();

        if (arg.get(0) != null) { person.setFirstName(arg.get(0)); }                            else { person.setFirstName(null); }
        if (arg.get(1) != null) { person.setLastName(arg.get(1)); }                             else { person.setLastName(null); }
        if (arg.get(2) != null) { person.setAge(Integer.parseInt(arg.get(2))); }                else { person.setAge(null); }
        if (arg.get(3) != null) { person.setStateId(Integer.parseInt(arg.get(3))); }            else { person.setStateId(null); }
        if (arg.get(4) != null) { person.setIsRecommended(Boolean.parseBoolean(arg.get(4))); }  else { person.setIsRecommended(null); }

        System.out.println(person.isIsRecommended());
        return person;
    }

    public static PersonWithID parsePersonWithID(Vector<String> arg, int size) throws IOException {
        if (arg.size() != size)
            throw new IOException("Expected " + size + " arguments, got " + arg.size());

        PersonWithID person = new PersonWithID();
        if (arg.get(0) != null) { person.setId(Integer.parseInt(arg.get(0)));}                  else { person.setId(null); }
        if (arg.get(1) != null) { person.setFirstName(arg.get(1)); }                            else { person.setFirstName(null); }
        if (arg.get(2) != null) { person.setLastName(arg.get(2)); }                             else { person.setLastName(null); }
        if (arg.get(3) != null) { person.setAge(Integer.parseInt(arg.get(3))); }                else { person.setAge(null); }
        if (arg.get(4) != null) { person.setStateId(Integer.parseInt(arg.get(4))); }            else { person.setStateId(null); }
        if (arg.get(5) != null) { person.setIsRecommended(Boolean.parseBoolean(arg.get(5))); }  else { person.setIsRecommended(null); }

        return person;
    }
}
