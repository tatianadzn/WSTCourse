import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import services.Person;
import services.PersonService;
import services.PersonWithID;
import utils.Parsers;

public class WebServiceClient {
    private static PersonService personService;
    private static final int NUM_OF_PERSON_WITH_ID_FIELD = 6;

    public static void main(String[] args) throws MalformedURLException {
        printWelcomeMsg();
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        personService = new PersonService(url);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String operation = scanner.next();
            Vector<String> requestArgs = Parsers.parseNRequestArgs(scanner);
            switch (operation) {
                case "show":
                    doShowRequest(requestArgs);
                    break;
                case "create":
                    doCreateRequest(requestArgs);
                    break;
                case "update":
                    doUpdateRequest(requestArgs);
                    break;
                case "delete":
                    doDeleteRequest(requestArgs);
                    break;
                default:
                    System.out.println("Error: operation '" + operation + "' is not supported");
            }
        }
    }


    private static void doShowRequest(Vector<String> arg){
        try{
            PersonWithID personWithID = Parsers.parsePersonWithID(arg, NUM_OF_PERSON_WITH_ID_FIELD);
            List<PersonWithID> persons = personService.getPersonWebServicePort().getPersons(personWithID);
            for (PersonWithID person : persons) {
                printPerson(person);
            }
            System.out.println("Total persons: " + persons.size());
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void doCreateRequest(Vector<String> arg){
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

    private static void doUpdateRequest(Vector<String> arg){
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

    private static void doDeleteRequest(Vector<String> arg){
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



    private static void printPerson(PersonWithID person){
        System.out.println("ID: " + person.getId() + ", name: " + person.getFirstName() +
                    ", surname: " + person.getLastName() + ", age: " + person.getAge() +
                    ", state ID: " + person.getStateId() + ", is recommended: " + person.isIsRecommended());
    }

    private static void printWelcomeMsg(){
        System.out.println("Available operations:\n\t" +
                "show <arg1> .. <arg6>\n\t" +
                "create <arg1> .. <arg5>\n\t" +
                "update <id> <arg1> .. <arg5>\n\t" +
                "delete <id>\n");
    }
}