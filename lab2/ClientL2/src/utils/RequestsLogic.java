package utils;

import services.Person;
import services.PersonService;
import services.PersonWithID;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;
import java.util.Vector;

public class RequestsLogic {

    private final int NUM_OF_PERSON_WITH_ID_FIELD;
    private final PersonService personService;

    public RequestsLogic(PersonService personService, int NUM_OF_PERSON_WITH_ID_FIELD){
        this.personService = personService;
        this.NUM_OF_PERSON_WITH_ID_FIELD = NUM_OF_PERSON_WITH_ID_FIELD;
    }

    public void doShowRequest(Vector<String> arg){
        try{
            PersonWithID personWithID = Parsers.parsePersonWithID(arg, NUM_OF_PERSON_WITH_ID_FIELD);
            List<PersonWithID> persons = personService.getPersonWebServicePort().getPersons(personWithID);

            synchronized (this){
                for (PersonWithID person : persons) {
                    Printers.printPerson(person);
                }
                System.out.println("Total persons: " + persons.size());
            }

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void doCreateRequest(Vector<String> arg){
        try{
            Person person = Parsers.parsePerson(arg, NUM_OF_PERSON_WITH_ID_FIELD - 1);
            int id_res = personService.getPersonWebServicePort().createPerson(person);
            if (id_res != -1){
                System.out.println("Person successfully created; id = " + id_res);
            } else {
                throw new ServerException("Server error");
            }

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void doUpdateRequest(Vector<String> arg){
        try {
            PersonWithID personWithID = Parsers.parsePersonWithID(arg, NUM_OF_PERSON_WITH_ID_FIELD);
            int result_status = personService.getPersonWebServicePort().updatePerson(personWithID);
            if (result_status == 1){
                System.out.println("Person successfully updated");
            } else {
                System.out.println("Error: server error");
            }

        } catch (NumberFormatException e){
            System.out.println("Error: expected integer, got " + arg.firstElement());
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void doDeleteRequest(Vector<String> arg){
        try {
            if (arg.size() != 1) throw new IOException("Expected 1 argument, got " + arg.size());
            int arg0 = Integer.parseInt(arg.firstElement().trim());
            int result_status = personService.getPersonWebServicePort().deletePerson(arg0);
            if (result_status == 1){
                System.out.println("Person successfully deleted");
            } else {
                throw new ServerException("Server error");
            }

        } catch (NumberFormatException e){
            System.out.println("Error: expected integer, got " + arg.firstElement());
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
