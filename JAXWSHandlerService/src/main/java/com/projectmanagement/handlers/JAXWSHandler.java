package com.projectmanagement.handlers;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kingshuk on 11/19/17.
 */
public class JAXWSHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        System.out.println("The getHeaders was called");
                return null;
    }

    /**
     * This handleMessage method gets called both on the request and response. So we need a way to determine
     * if the method has been called during incoming request or outgoing response
     *
     * @param context
     * @return
     */
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        /**
         * first step would be to determine if this method is being called during the incoming request
         *or the response. because that would help us determine what logic to run.
         *
         * If the message outbound property is true, that indicates it's an outgoing message, else an incoming message
         * Here we want to handle incoming message logic
         */

        Boolean ifMessageOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (!ifMessageOutbound) {
            System.out.println("It's an incoming message so processing is done");

            //Let's get the SOAP headers and body parts one by one from the SOAP envelope
            try {

                /*SOAPMessage message = context.getMessage();

                SOAPPart soapPart = message.getSOAPPart();

                SOAPEnvelope envelope = soapPart.getEnvelope();

                SOAPHeader header = envelope.getHeader();*/

                //SOAPHeader soapHeader = context.getMessage().getSOAPHeader(); does the same thing as other four steps above

                SOAPHeader soapHeader = context.getMessage().getSOAPPart().getEnvelope().getHeader();

                Iterator childElements = soapHeader.getChildElements();

                while (childElements.hasNext()) {
                    Node node = (Node) childElements.next();

                    System.out.println("This SOAP header part is: " + node.getLocalName());
                    System.out.println("This SOAP header value is: " + node.getValue());

                    String nodeName=node.getLocalName();

                    if(nodeName!=null && "RequestingCompany".equals(nodeName)){
                        System.out.println("The company requesting project information is: "+ node.getValue());
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("It's an outgoing message so nothing is done");
        }
        return true;    //This method should always return true otherwise the webservices end point will not be called
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
