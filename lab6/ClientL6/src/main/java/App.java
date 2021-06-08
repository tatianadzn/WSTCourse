import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.ObjectMapper;
import services.Person;
import services.PersonWithID;
import utils.Parsers;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class App {
    private static final String URL = "http://localhost:8080/rest/persons";
    private static final int NUM_OF_PERSON_WITH_ID_FIELD = 6;

    public static void main(String[] args) throws IOException {
        printWelcomeMsg();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String operation = scanner.next();
            Vector<String> requestArgs = Parsers.parseNRequestArgs(scanner);
            Client client = Client.create();
            ObjectMapper mapper = new ObjectMapper();
            switch (operation) {
                case "show":
                    printList(getPersons(client, mapper.writeValueAsString(Parsers.parsePersonWithID(requestArgs, NUM_OF_PERSON_WITH_ID_FIELD))));
                    break;
                case "create":
                    System.out.println(createPerson(client,mapper.writeValueAsString(Parsers.parsePerson(requestArgs, NUM_OF_PERSON_WITH_ID_FIELD - 1))));
                    break;
                case "update":
                    System.out.println(updatePerson(client,mapper.writeValueAsString(Parsers.parsePersonWithID(requestArgs, NUM_OF_PERSON_WITH_ID_FIELD))));
                    break;
                case "delete":
                    System.out.println(deletePerson(client,requestArgs.get(0)));
                    break;
                default:
                    System.out.println("Error: operation '" + operation + "' is not supported");
            }
        }
    }

    private static List<PersonWithID> getPersons(Client client, String personWithID){
        WebResource webResource = client.resource(URL);
        if (personWithID != null) {
            webResource = webResource.queryParam("personWithID", personWithID);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> message = new GenericType<String>() {};
            System.out.println(response.getStatus() + ": " + response.getEntity(message));
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<PersonWithID>> type = new GenericType<List<PersonWithID>>() {};

        return response.getEntity(type);
    }

    private static int createPerson(Client client, String person) {
        WebResource webResource = client.resource(URL);
        if (person != null) {
            webResource = webResource.queryParam("person", person);
        }
        ClientResponse response =
                webResource.accept(MediaType.TEXT_PLAIN).post(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> message = new GenericType<String>() {};
            System.out.println(response.getStatus() + ": " + response.getEntity(message));
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {};

        return Integer.parseInt(response.getEntity(type));
    }

    private static int updatePerson(Client client, String personWithId) {
        WebResource webResource = client.resource(URL);
        if (personWithId != null) {
            webResource = webResource.queryParam("personWithId", personWithId);
        }
        ClientResponse response =
                webResource.accept(MediaType.TEXT_PLAIN).put(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> message = new GenericType<String>() {};
            System.out.println(response.getStatus() + ": " + response.getEntity(message));
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {};

        return Integer.parseInt(response.getEntity(type));
    }

    private static int deletePerson(Client client, String id) {
        WebResource webResource = client.resource(URL);
        if (id != null) {
            webResource = webResource.queryParam("id", id);
        }
        ClientResponse response =
                webResource.accept(MediaType.TEXT_PLAIN).delete(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> message = new GenericType<String>() {};
            System.out.println(response.getStatus() + ": " + response.getEntity(message));
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {};

        return Integer.parseInt(response.getEntity(type));
    }

    private static void printList(List<PersonWithID> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static void printWelcomeMsg(){
        System.out.println("Available operations:\n\t" +
                "show <arg1> .. <arg6>\n\t" +
                "create <arg1> .. <arg5>\n\t" +
                "update <id> <arg1> .. <arg5>\n\t" +
                "delete <id>\n");
    }
}