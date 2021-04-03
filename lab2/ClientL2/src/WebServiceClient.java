import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import services.Person;
import services.PersonService;

public class WebServiceClient {
    private static Scanner scanner;
    private static PersonService personService;
    private static final int NUM_OF_ARGS = 6;

    public static void main(String[] args) throws MalformedURLException {
        printWelcomeMsg();
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        personService = new PersonService(url);

        scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String operation = scanner.next();
            switch (operation) {
                case "show":
                    doShowRequest();
                    break;
                case "create":
                    doCreateRequest();
                    break;
                case "update":
                    doUpdateRequest();
                    break;
                case "delete":
                    doDeleteRequest();
                    break;
                default:
                    System.out.println("Error: operation '" + operation + "' is not supported");
            }
        }
    }


    private static void doShowRequest(){
        try{
            Vector<String> arg = parseNRequestArgs();
            if (arg.size() != NUM_OF_ARGS) throw new IOException("Expected " + NUM_OF_ARGS + " arguments, got " + arg.size());

            List<Person> persons = personService.getPersonWebServicePort().getPersons(arg.get(0), arg.get(1), arg.get(2), arg.get(3), arg.get(4), arg.get(5));
            for (Person person : persons) {
                printPerson(person);
            }
            System.out.println("Total persons: " + persons.size());
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void doCreateRequest(){
        try{
            Vector<String> arg = parseNRequestArgs();
            if (arg.size() != NUM_OF_ARGS) throw new IOException("Expected " + NUM_OF_ARGS + " arguments, got " + arg.size());

            int id_res = personService.getPersonWebServicePort().createPerson(arg.get(0), arg.get(1), arg.get(2), arg.get(3), arg.get(4));
            if (id_res != -1){
                System.out.println("Person successfully created; id = " + id_res);
            } else {
                throw new ServerException("Server error");
            }

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void doUpdateRequest(){
        Vector<String> arg = parseNRequestArgs();
        try {
            if (arg.size() != NUM_OF_ARGS) throw new IOException("Expected " + (NUM_OF_ARGS) + " arguments, got " + arg.size());
            int arg0 = Integer.parseInt(arg.firstElement().trim());
            int result_status = personService.getPersonWebServicePort().updatePerson(arg0, arg.get(1), arg.get(2), arg.get(3), arg.get(4), arg.get(5));
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

    private static void doDeleteRequest(){
        Vector<String> arg = parseNRequestArgs();
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

    private static Vector<String> parseNRequestArgs(){
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

    private static void printPerson(Person person){
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