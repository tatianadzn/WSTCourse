import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.ObjectMapper;
import services.Person;
import services.PersonWithID;
import utils.Parsers;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.ws.rs.core.MediaType;

public class App {
    private static final String URL = "http://localhost:8080/rest/persons";
    private static final int NUM_OF_PERSON_WITH_ID_FIELD = 6;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Vector<String> requestArgs = Parsers.parseNRequestArgs(scanner);
        PersonWithID personWithID = Parsers.parsePersonWithID(requestArgs, NUM_OF_PERSON_WITH_ID_FIELD);
        Client client = Client.create();
        ObjectMapper mapper = new ObjectMapper();

        printList(getPersons(client,mapper.writeValueAsString(personWithID)));
    }

    private static List<PersonWithID> getPersons(Client client, String personWithID) {
        WebResource webResource = client.resource(URL);
        if (personWithID != null) {
            webResource = webResource.queryParam("personWithID", personWithID);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<PersonWithID>> type = new GenericType<List<PersonWithID>>() {};
        ;
        return response.getEntity(type);
    }

    private static void printList(List<PersonWithID> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}