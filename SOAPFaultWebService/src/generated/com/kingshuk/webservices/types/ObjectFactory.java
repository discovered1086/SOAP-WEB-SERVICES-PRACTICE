
package com.kingshuk.webservices.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kingshuk.webservices.types package. 
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

    private final static QName _SchemaValidationException_QNAME = new QName("http://webservices.kingshuk.com/types", "schemaValidationException");
    private final static QName _TheRequest_QNAME = new QName("http://webservices.kingshuk.com/types", "theRequest");
    private final static QName _EmployeeResponse_QNAME = new QName("http://webservices.kingshuk.com/types", "employeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kingshuk.webservices.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SchemaValidationExceptionType }
     * 
     */
    public SchemaValidationExceptionType createSchemaValidationExceptionType() {
        return new SchemaValidationExceptionType();
    }

    /**
     * Create an instance of {@link EmployeeRequest }
     * 
     */
    public EmployeeRequest createEmployeeRequest() {
        return new EmployeeRequest();
    }

    /**
     * Create an instance of {@link EmployeeResponse }
     * 
     */
    public EmployeeResponse createEmployeeResponse() {
        return new EmployeeResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SchemaValidationExceptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.kingshuk.com/types", name = "schemaValidationException")
    public JAXBElement<SchemaValidationExceptionType> createSchemaValidationException(SchemaValidationExceptionType value) {
        return new JAXBElement<SchemaValidationExceptionType>(_SchemaValidationException_QNAME, SchemaValidationExceptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.kingshuk.com/types", name = "theRequest")
    public JAXBElement<EmployeeRequest> createTheRequest(EmployeeRequest value) {
        return new JAXBElement<EmployeeRequest>(_TheRequest_QNAME, EmployeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.kingshuk.com/types", name = "employeeResponse")
    public JAXBElement<EmployeeResponse> createEmployeeResponse(EmployeeResponse value) {
        return new JAXBElement<EmployeeResponse>(_EmployeeResponse_QNAME, EmployeeResponse.class, null, value);
    }

}
