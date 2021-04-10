package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class myThread extends Thread{
    private static RequestsLogic requestsLogic;
    private static BufferedReader bufferedReader;

    public myThread(RequestsLogic rl, BufferedReader br){
        synchronized (this){
            if (requestsLogic == null){
                requestsLogic = rl;
            }
            if (bufferedReader == null){
                bufferedReader = br;
            }
        }
    }

    @Override
    public void run(){
        try {
            routine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void routine() throws IOException {
        String line;
        while((line = bufferedReader.readLine()) != null){
            Vector<String> requestArgs = new Vector<>(Arrays.asList(line.split(" ")));
            Parsers.parseVector(requestArgs);
            String operation = requestArgs.remove(0);
            switch (operation) {
                case "show":
                    requestsLogic.doShowRequest(requestArgs);
                    break;
                case "create":
                    requestsLogic.doCreateRequest(requestArgs);
                    break;
                case "update":
                    requestsLogic.doUpdateRequest(requestArgs);
                    break;
                case "delete":
                    requestsLogic.doDeleteRequest(requestArgs);
                    break;
                default:
                    System.out.println("Error: operation '" + requestArgs.get(0) + "' is not supported");
            }
        }
    }
}
