package exceptions;

import com.sun.jersey.api.Responses;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class IllegalStateIdException extends WebApplicationException {
    public static IllegalStateIdException DEFAULT_INSTANCE = new
            IllegalStateIdException("state Id should be between 1 and 50");

    public IllegalStateIdException(String message) {
        super(Response.status(Responses.NOT_FOUND).
                entity(message).type("text/plain").build());
    }
}