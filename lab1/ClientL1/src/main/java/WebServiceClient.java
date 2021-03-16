import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import services.Person;
import services.PersonService;

public class WebServiceClient {

        public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);

        final int NUM_OF_ARGS = 6;
        String[] arg = parseArgs(NUM_OF_ARGS);

        List<Person> persons = personService.getPersonWebServicePort().getPersons(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5]);
        for (Person person : persons) {
            System.out.println("ID: " + person.getId() + ", name: " + person.getFirstName() +
                    ", surname: " + person.getLastName() + ", age: " + person.getAge() +
                    ", state ID: " + person.getStateId() + ", is recommended: " + person.isIsRecommended());
        }
        System.out.println("Total persons: " + persons.size());
    }

    private static String[] parseArgs(int numOfArgs) {
        Scanner scanner = new Scanner(System.in);
        String[] arg = new String[numOfArgs];
        for (int i = 0; i < numOfArgs; i++){
            arg[i] = scanner.next();
            if (arg[i].equals("null")) { arg[i] = null; }
        }
        return arg;
    }
}