package errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "errors.PersonServiceFault")
public class IllegalRecommendedStatusException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final PersonServiceFault fault;
    public IllegalRecommendedStatusException(String message, PersonServiceFault fault) {
        super(message);
        this.fault = fault;
    }
    public IllegalRecommendedStatusException(String message, PersonServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public PersonServiceFault getFaultInfo() {
        return fault;
    }
}
