package com.studentinfoservice.client;

import com.studentinfoservice.student.StudentInfoService;
import com.studentinfoservice.student.StudentInfoServices;
import com.studentinfoservice.student.StudentRequest;
import com.studentinfoservice.student.StudentResponse;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandler;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingshuk on 6/24/17.
 */
public class StudentServiceClient {

    public static void main(String[] args) {

        try {

            //Step 1: Generate a student service class instance which should
            //be provided with the URL of the WSDL file

            /**
             * What happens behind the scenes:
             *The StudentInfoServices class extends the class Service from the JAX-WS API
             *When the StudentInfoServices class is being instantiated, we're just passing the WSDL URL
             *It in turn calls the constructor of the Service class with the WSDL URL and a QName object
             * which has the namespace and the name of the service, service being the
             *StudentInfoServices in this case. Then from the constructor of the Service class the Provider implementation object
             *
             * The algorithm used to locate the provider object is as follows
             * If a resource with the name of
             *   <code>META-INF/services/javax.xml.ws.spi.Provider</code>
             *   exists, then its first line, if present, is used as the UTF-8 encoded
             *   name of the implementation class.
             *
             *   In our case that is org.apache.cxf.jaxws22.spi.ProviderImpl located in the META-INF/services folder of
             *   cxf-rt-frontend-jaxws-3.0.2.jar in the maven repository
             *
             *   So this class ProviderImpl takes the WSDL name and the QName object (which has the namespace and the
             *   name of the service) and returns a service delegate object. Below is the documentation on the delegate object.
             *
             *   Service delegates are used internally by <code>Service</code> objects
             * to allow pluggability of JAX-WS implementations.
             * <p>
             * Every <code>Service</code> object has its own delegate, created using
             * the {@link javax.xml.ws.spi.Provider#createServiceDelegate} method. A <code>Service</code>
             * object delegates all of its instance methods to its delegate.
             *
             * THIS IS CALLED THE SERVICE PROVIDER MECHANISM
             */
            StudentInfoServices services = new StudentInfoServices(
                                                    new URL("http://localhost:8080/StudentInfoService/services/studentInfoService?wsdl"));

            //Step 2 is to get the port type instance that wraps all the operations performed by the web service, from the
            //Service class
            /**
             * Here is a deeper dive at what happens in background
             *
             * This method call in turn calls the get port method of the service class with the following parameters
             *A QName object with the namespace and the port name in this case, and the port type class that we have
             * defined in the WSDL file
             *
             * getPort method on the Service class is called which in turn calls the delegate object's getPort method. The
             * delegate object was just created in the previous step.
             *
             * the getPort method then returns an Object Proxy instance that
             *  supports the specified service endpoint interface (which in this case is GetStudentDetailsPortType as defined
             *  in the WSDL file)
             *
             *  A service client uses this proxy to invoke operations on the target service endpoint. The serviceEndpointInterface
             * specifies the service endpoint interface (which in this case is GetStudentDetailsPortType as defined
             *  in the WSDL file)that is supported by the created dynamic proxy instance.
             *
             *  The interface uses a proxy pattern to generate code at the run time to perform important stuff like serialize the
             *  SOAP messages, call the appropriate service end point and return the serialized response from the web service
             */
            StudentInfoService studentDetailsPortType=services.getStudentInfoServicePort();

            /**
             * Below part of the code has been done for the user name token profile implementation
             * This uses low level CXF code and usage of low level CXF objects
             */

            /**
             * Here we are creating a map of all the configuration details that we need to pass to the out interceptor
             *
             * The out interceptor is what's gonna handle the intricacies of adding the security header to the request.
             *
             * Below are the list of configurations sent to the interceptor and their explanations.
             * 1. We need to tell the interceptor what are we trying to do. So we tell it that we're trying to share
             * user name token through "ACTION"
             * 2. Next is the user ID that we're going to set in the security header.
             * 3. Next we tell the interceptor that we're sending the password as text
             * 4. Next we share the callback class to the interceptor so that it can use it at the runtime
             * when we call the end point with our main request.
             *
             *
             * After setting up the properties, here's what we're trying to do. We're working on low level CXF API here.
             * So this code will vary from one web service provider to another.
             *
             * 1. First we need to get the access to the CXF client object.
             * 2. The we get an end point object from the client.
             * 3. Then we programmatically configure the interceptors using the properties map we have jus created using a map.
             * We need an out interceptor because we're going to embed the user name token profile when the message goes out
             * 4. Finally we add the interceptor we just configured to the list of interceptors the end point has. That means when
             * the end point is called, the out interceptor will automatically pitch in and do it's work. Just like the in interceptor
             * pitches in when a request is received at the end point.
             *
             */
            Map<String, Object> configuration=new HashMap<>();
            configuration.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
            configuration.put(WSHandlerConstants.USER, "rishi2616");
            configuration.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            configuration.put(WSHandlerConstants.PW_CALLBACK_CLASS, StudentInfoPasswordCallBack.class.getName());
            //Step 1
            Client client= ClientProxy.getClient(studentDetailsPortType);

            //Step 2:
            Endpoint endpoint=client.getEndpoint();

            //Step 3:
            WSS4JOutInterceptor interceptor=new WSS4JOutInterceptor(configuration);

            //Step 4:
            endpoint.getOutInterceptors().add(interceptor);

            /*****************END: User name token profile implementation***********************/

            //Step 3 is to instantiate the request object and set the values to the request object.
            StudentRequest studentRequest=new StudentRequest();
            studentRequest.setStudentId(BigInteger.valueOf(1));
            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            StudentResponse studentResponse=studentDetailsPortType.getStudentDetails(studentRequest);

            //System.out.println("The Student's name is: "+ studentResponse.getStudent().getName());
            System.out.println(studentResponse.getStudent().getAdmissionYear());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
