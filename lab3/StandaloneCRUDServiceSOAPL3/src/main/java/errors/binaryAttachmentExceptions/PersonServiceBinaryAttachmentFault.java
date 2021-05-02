package errors.binaryAttachmentExceptions;

public class PersonServiceBinaryAttachmentFault {
    private static final String DEFAULT_MESSAGE = "something wrong with binary attachments";

    protected String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static PersonServiceBinaryAttachmentFault defaultInstance() {
        PersonServiceBinaryAttachmentFault fault = new PersonServiceBinaryAttachmentFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
