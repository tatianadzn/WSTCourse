package errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "errors.PersonServiceFault")
public class BadQueryResponseException extends Exception {
    private static final long serialVersionUID = -6647544772732631049L;
    private final PersonServiceFault fault;
    public BadQueryResponseException(String message, PersonServiceFault fault) {
        super(message);
        this.fault = fault;
    }
    public BadQueryResponseException(String message, PersonServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public PersonServiceFault getFaultInfo() {
        return fault;
    }
}
