package exceptions;

import com.sun.jersey.api.Responses;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class IllegalNameException extends WebApplicationException {
    public static IllegalNameException DEFAULT_INSTANCE = new
            IllegalNameException("personName cannot be null or empty");

    public IllegalNameException(String message) {
        super(Response.status(Responses.NOT_FOUND).
                entity(message).type("text/plain").build());
    }
}