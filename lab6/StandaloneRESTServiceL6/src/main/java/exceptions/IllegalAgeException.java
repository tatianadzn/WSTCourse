package exceptions;

import com.sun.jersey.api.Responses;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class IllegalAgeException extends WebApplicationException {
    public static IllegalAgeException DEFAULT_INSTANCE = new
            IllegalAgeException("age should be more than 18");

    public IllegalAgeException(String message) {
        super(Response.status(Responses.NOT_FOUND).
                entity(message).type("text/plain").build());
    }
}


