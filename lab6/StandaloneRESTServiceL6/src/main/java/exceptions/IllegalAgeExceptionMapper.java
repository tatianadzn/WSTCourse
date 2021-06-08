package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalAgeExceptionMapper implements ExceptionMapper<IllegalAgeException> {
    @Override
    public Response toResponse(IllegalAgeException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
}