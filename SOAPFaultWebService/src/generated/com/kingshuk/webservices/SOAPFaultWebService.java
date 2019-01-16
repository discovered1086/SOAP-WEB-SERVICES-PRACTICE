package com.kingshuk.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-15T21:44:06.266-06:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "SOAPFaultWebService",
                  wsdlLocation = "file:/C:/Users/kimukher/git/SOAP-FAULT-WEB-SERVICE/SOAPFaultWebService/src/main/resources/SOAPFaultWebService.wsdl",
                  targetNamespace = "http://webservices.kingshuk.com")
public class SOAPFaultWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservices.kingshuk.com", "SOAPFaultWebService");
    public final static QName SOAPFaultwebserviceOAP = new QName("http://webservices.kingshuk.com", "SOAPFaultwebserviceOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/kimukher/git/SOAP-FAULT-WEB-SERVICE/SOAPFaultWebService/src/main/resources/SOAPFaultWebService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SOAPFaultWebService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/kimukher/git/SOAP-FAULT-WEB-SERVICE/SOAPFaultWebService/src/main/resources/SOAPFaultWebService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SOAPFaultWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SOAPFaultWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAPFaultWebService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SOAPFaultWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SOAPFaultWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SOAPFaultWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns GetEmployeePortType
     */
    @WebEndpoint(name = "SOAPFaultwebserviceOAP")
    public GetEmployeePortType getSOAPFaultwebserviceOAP() {
        return super.getPort(SOAPFaultwebserviceOAP, GetEmployeePortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetEmployeePortType
     */
    @WebEndpoint(name = "SOAPFaultwebserviceOAP")
    public GetEmployeePortType getSOAPFaultwebserviceOAP(WebServiceFeature... features) {
        return super.getPort(SOAPFaultwebserviceOAP, GetEmployeePortType.class, features);
    }

}
