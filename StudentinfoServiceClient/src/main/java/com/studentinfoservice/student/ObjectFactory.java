
package com.studentinfoservice.student;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.studentinfoservice.student package. 
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

    private final static QName _ResponseForStudentInfo_QNAME = new QName("http://studentInfoService.com/Student", "ResponseForStudentInfo");
    private final static QName _RequestForStudentInfo_QNAME = new QName("http://studentInfoService.com/Student", "RequestForStudentInfo");
    private final static QName _Student_QNAME = new QName("http://studentInfoService.com/Student", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.studentinfoservice.student
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentRequest }
     * 
     */
    public StudentRequest createStudentRequest() {
        return new StudentRequest();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link StudentResponse }
     * 
     */
    public StudentResponse createStudentResponse() {
        return new StudentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://studentInfoService.com/Student", name = "ResponseForStudentInfo")
    public JAXBElement<StudentResponse> createResponseForStudentInfo(StudentResponse value) {
        return new JAXBElement<StudentResponse>(_ResponseForStudentInfo_QNAME, StudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://studentInfoService.com/Student", name = "RequestForStudentInfo")
    public JAXBElement<StudentRequest> createRequestForStudentInfo(StudentRequest value) {
        return new JAXBElement<StudentRequest>(_RequestForStudentInfo_QNAME, StudentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://studentInfoService.com/Student", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

}
