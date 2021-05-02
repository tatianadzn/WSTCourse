package errors.binaryAttachmentExceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "errors.binaryAttachmentException.PersonServiceBinaryAttachmentFault")
public class BadBinaryAttachmentException extends Exception {
    private static final long serialVersionUID = -6647544772732631049L;
    private final PersonServiceBinaryAttachmentFault fault;
    public BadBinaryAttachmentException(String message, PersonServiceBinaryAttachmentFault fault) {
        super(message);
        this.fault = fault;
    }
    public BadBinaryAttachmentException(String message, PersonServiceBinaryAttachmentFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public PersonServiceBinaryAttachmentFault getFaultInfo() {
        return fault;
    }
}
