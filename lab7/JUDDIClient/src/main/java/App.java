import org.apache.juddi.api_v3.AccessPointType;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.api_v3.*;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String operation = scanner.next();
            switch (operation) {
                case "get":
                    getServices();
                    break;
                case "register":
                    registerService();
                    break;
                default:
                    System.out.println("Operation is not available");
            }
        }
    }

    private static void registerService(){
        App myApp = new App();
        myApp.publish();
    }

    private static void getServices(){
        SimpleBrowse simpleBrowse = new SimpleBrowse();
        simpleBrowse.Browse();
    }


    private static UDDISecurityPortType security = null;
    private static UDDIPublicationPortType publish = null;

    public App() {
        try {
            UDDIClient uddiClient = new UDDIClient("/home/tatianadzn/WSTCourse/lab7/JUDDIClient/src/main/resources/META_INF/uddi.xml");
            Transport transport = uddiClient.getTransport("default");

            security = transport.getUDDISecurityService();
            publish = transport.getUDDIPublishService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish() {
        try {
            GetAuthToken getAuthTokenMyPub = new GetAuthToken();
            getAuthTokenMyPub.setUserID("uddi");
            getAuthTokenMyPub.setCred("uddi");
            AuthToken myPubAuthToken = security.getAuthToken(getAuthTokenMyPub);

            BusinessEntity myBusEntity = new BusinessEntity();
            Name myBusName = new Name();
            myBusName.setValue("Business Name");
            myBusEntity.getName().add(myBusName);

            SaveBusiness sb = new SaveBusiness();
            sb.getBusinessEntity().add(myBusEntity);
            sb.setAuthInfo(myPubAuthToken.getAuthInfo());
            BusinessDetail bd = publish.saveBusiness(sb);
            String myBusKey = bd.getBusinessEntity().get(0).getBusinessKey();

            BusinessService myService = new BusinessService();
            myService.setBusinessKey(myBusKey);
            Name myServName = new Name();
            myServName.setValue("Service name");
            myService.getName().add(myServName);

            BindingTemplate myBindingTemplate = new BindingTemplate();
            AccessPoint accessPoint = new AccessPoint();
            accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
            accessPoint.setValue("http://localhost:8080/PersonService?wsdl");
            myBindingTemplate.setAccessPoint(accessPoint);
            BindingTemplates myBindingTemplates = new BindingTemplates();

            myService.setBindingTemplates(myBindingTemplates);

            SaveService ss = new SaveService();
            ss.getBusinessService().add(myService);
            ss.setAuthInfo(myPubAuthToken.getAuthInfo());
            ServiceDetail sd = publish.saveService(ss);
            String myServKey = sd.getBusinessService().get(0).getServiceKey();

            security.discardAuthToken(new DiscardAuthToken(myPubAuthToken.getAuthInfo()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


