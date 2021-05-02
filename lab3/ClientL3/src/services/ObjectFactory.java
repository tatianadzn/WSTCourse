
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IllegalNameException_QNAME = new QName("http://services/", "IllegalNameException");
    private final static QName _UpdatePerson_QNAME = new QName("http://services/", "updatePerson");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://services/", "deletePersonResponse");
    private final static QName _Download_QNAME = new QName("http://services/", "download");
    private final static QName _BadQueryResponseException_QNAME = new QName("http://services/", "BadQueryResponseException");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://services/", "updatePersonResponse");
    private final static QName _DownloadResponse_QNAME = new QName("http://services/", "downloadResponse");
    private final static QName _Person_QNAME = new QName("http://services/", "person");
    private final static QName _IllegalRecommendedStatusException_QNAME = new QName("http://services/", "IllegalRecommendedStatusException");
    private final static QName _IllegalStateIdException_QNAME = new QName("http://services/", "IllegalStateIdException");
    private final static QName _GetPersons_QNAME = new QName("http://services/", "getPersons");
    private final static QName _CreatePerson_QNAME = new QName("http://services/", "createPerson");
    private final static QName _UploadResponse_QNAME = new QName("http://services/", "uploadResponse");
    private final static QName _IllegalAgeException_QNAME = new QName("http://services/", "IllegalAgeException");
    private final static QName _BadBinaryAttachmentException_QNAME = new QName("http://services/", "BadBinaryAttachmentException");
    private final static QName _DeletePerson_QNAME = new QName("http://services/", "deletePerson");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://services/", "createPersonResponse");
    private final static QName _IllegalUpdatePersonSetException_QNAME = new QName("http://services/", "IllegalUpdatePersonSetException");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://services/", "getPersonsResponse");
    private final static QName _IllegalIdException_QNAME = new QName("http://services/", "IllegalIdException");
    private final static QName _SQLException_QNAME = new QName("http://services/", "SQLException");
    private final static QName _Upload_QNAME = new QName("http://services/", "upload");
    private final static QName _UploadArg1_QNAME = new QName("", "arg1");
    private final static QName _DownloadResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link PersonServiceFault }
     * 
     */
    public PersonServiceFault createPersonServiceFault() {
        return new PersonServiceFault();
    }

    /**
     * Create an instance of {@link Upload }
     * 
     */
    public Upload createUpload() {
        return new Upload();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link PersonServiceBinaryAttachmentFault }
     * 
     */
    public PersonServiceBinaryAttachmentFault createPersonServiceBinaryAttachmentFault() {
        return new PersonServiceBinaryAttachmentFault();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link Download }
     * 
     */
    public Download createDownload() {
        return new Download();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link PersonWithID }
     * 
     */
    public PersonWithID createPersonWithID() {
        return new PersonWithID();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "IllegalNameException")
    public JAXBElement<PersonServiceFault> createIllegalNameException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IllegalNameException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Download }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "download")
    public JAXBElement<Download> createDownload(Download value) {
        return new JAXBElement<Download>(_Download_QNAME, Download.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "BadQueryResponseException")
    public JAXBElement<PersonServiceFault> createBadQueryResponseException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_BadQueryResponseException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "downloadResponse")
    public JAXBElement<DownloadResponse> createDownloadResponse(DownloadResponse value) {
        return new JAXBElement<DownloadResponse>(_DownloadResponse_QNAME, DownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "person")
    public JAXBElement<Object> createPerson(Object value) {
        return new JAXBElement<Object>(_Person_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "IllegalRecommendedStatusException")
    public JAXBElement<PersonServiceFault> createIllegalRecommendedStatusException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IllegalRecommendedStatusException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "IllegalStateIdException")
    public JAXBElement<PersonServiceFault> createIllegalStateIdException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IllegalStateIdException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadResponse")
    public JAXBElement<UploadResponse> createUploadResponse(UploadResponse value) {
        return new JAXBElement<UploadResponse>(_UploadResponse_QNAME, UploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "IllegalAgeException")
    public JAXBElement<PersonServiceFault> createIllegalAgeException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IllegalAgeException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceBinaryAttachmentFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "BadBinaryAttachmentException")
    public JAXBElement<PersonServiceBinaryAttachmentFault> createBadBinaryAttachmentException(PersonServiceBinaryAttachmentFault value) {
        return new JAXBElement<PersonServiceBinaryAttachmentFault>(_BadBinaryAttachmentException_QNAME, PersonServiceBinaryAttachmentFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "IllegalUpdatePersonSetException")
    public JAXBElement<PersonServiceFault> createIllegalUpdatePersonSetException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IllegalUpdatePersonSetException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "IllegalIdException")
    public JAXBElement<PersonServiceFault> createIllegalIdException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IllegalIdException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "SQLException")
    public JAXBElement<PersonServiceFault> createSQLException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_SQLException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "upload")
    public JAXBElement<Upload> createUpload(Upload value) {
        return new JAXBElement<Upload>(_Upload_QNAME, Upload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = Upload.class)
    public JAXBElement<byte[]> createUploadArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadArg1_QNAME, byte[].class, Upload.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = DownloadResponse.class)
    public JAXBElement<byte[]> createDownloadResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_DownloadResponseReturn_QNAME, byte[].class, DownloadResponse.class, ((byte[]) value));
    }

}
