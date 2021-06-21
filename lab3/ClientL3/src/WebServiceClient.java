import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import services.*;
import utils.Parsers;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class WebServiceClient {
    private static PersonService personService;
    private static final int NUM_OF_PERSON_WITH_ID_FIELD = 6;
    private static URL url;

    public static void main(String[] args) throws MalformedURLException {
        printWelcomeMsg();
        url = new URL("http://localhost:8080/PersonService?wsdl");
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
        } catch (IllegalIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalAgeException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalNameException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalStateIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        }

    }

    private static void doCreateRequest(Vector<String> arg){
        try{
            Person person = Parsers.parsePerson(arg, NUM_OF_PERSON_WITH_ID_FIELD - 1);
            int id_res = getAuthPort().createPerson(person);
            System.out.println("Person successfully created; id = " + id_res);

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalAgeException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalNameException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalStateIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (BadQueryResponseException e) {
            e.printStackTrace();
        } catch (IllegalRecommendedStatusException e) {
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        }
    }

    private static void doUpdateRequest(Vector<String> arg){
        try {
            PersonWithID personWithID = Parsers.parsePersonWithID(arg, NUM_OF_PERSON_WITH_ID_FIELD);
            getAuthPort().updatePerson(personWithID);
            System.out.println("Person successfully updated");

        } catch (NumberFormatException e){
            System.out.println("Error: expected integer, got " + arg.firstElement());
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalAgeException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalNameException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (IllegalStateIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (BadQueryResponseException e) {
            e.printStackTrace();
        } catch (IllegalUpdatePersonSetException e) {
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        }
    }

    private static void doDeleteRequest(Vector<String> arg){
        try {
            if (arg.size() != 1) throw new IOException("Expected 1 argument, got " + arg.size());
            int arg0 = Integer.parseInt(arg.firstElement().trim());
            getAuthPort().deletePerson(arg0);
            System.out.println("Person successfully deleted");

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Error: expected integer, got " + arg.firstElement());
        } catch (IllegalIdException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage() + ": " + e.getFaultInfo().getMessage());
        } catch (BadQueryResponseException e) {
            e.printStackTrace();
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

    private static PersonWebService getAuthPort(){
        PersonWebService personWebService = personService.getPersonWebServicePort();

        Map<String, Object> context = ((BindingProvider) personWebService).getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());
        Map<String, List<String>> headers = new HashMap<>();
        String credentials = "user:password";
        String authEncoded = Base64.getEncoder().encodeToString(credentials.getBytes());
        headers.put("Authorization", Collections.singletonList("Basic " + authEncoded));
        context.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        return personWebService;
    }
}