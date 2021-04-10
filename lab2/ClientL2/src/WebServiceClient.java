import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import services.PersonService;
import utils.RequestsLogic;
import utils.myThread;

public class WebServiceClient {
    private static final int NUM_OF_PERSON_WITH_ID_FIELD = 6;
    private static final File file = new File("/home/tatianadzn/WSTCourse/lab2/ClientL2/examples.txt");

    public static void main(String[] args) throws MalformedURLException, FileNotFoundException {

        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        RequestsLogic requestsLogic = new RequestsLogic(new PersonService(url), NUM_OF_PERSON_WITH_ID_FIELD);

        BufferedReader br = new BufferedReader(new FileReader(file));

        int NUM_OF_THREADS = 5;
        myThread[] threads = new myThread[NUM_OF_THREADS];
        for (int i = 0; i < NUM_OF_THREADS; i++){
            threads[i] = new myThread(requestsLogic, br);
            threads[i].start();
        }
    }
}