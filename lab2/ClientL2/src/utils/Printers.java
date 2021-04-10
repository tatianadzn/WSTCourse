package utils;

import services.PersonWithID;

public class Printers {
    public static void printPerson(PersonWithID person){
        System.out.println("ID: " + person.getId() + ", name: " + person.getFirstName() +
                ", surname: " + person.getLastName() + ", age: " + person.getAge() +
                ", state ID: " + person.getStateId() + ", is recommended: " + person.isIsRecommended());
    }
}
