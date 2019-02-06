/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credentialservice.business;


import com.credentialservice.model.Credentials;
import com.credentialservice.model.NotificationRequest;
import com.credentialservice.model.NotificationResponse;
import com.credentialservice.utility.CredentialsConstants;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Kingshuk
 */
public class NotificationSenderImpl implements NotificationSender {
   private static final String user ="sly.mania42@gmail.com";//change accordingly
   private static final String password = "Eyeofdtiger#16";
   private static Authenticator authenticator=null;
    static{
          authenticator= new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
    }

    public NotificationResponse sendEmail(NotificationRequest notificationRequest) {
        String pageMessage = null;
        // Get system properties
        Properties properties = System.getProperties();
        Credentials credential=notificationRequest.getCredential();
        NotificationResponse notificationResponse=new NotificationResponse();
        // Setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        // Get the default Session object.
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(user));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(notificationRequest.getEmailAddress()));

            // Set Subject: header field
            message.setSubject(CredentialsConstants.EMAIL_SUBJECT + credential.getAccount());

            // Now set the actual message
            //message.setContent(buildMessageBody(credential), "text");
            message.setText(buildMessageBody(credential));

            // Send message
            Transport.send(message);
            //System.out.println("Sent message successfully....");
            pageMessage = CredentialsConstants.EMAIL_SUCCESS_MESSAGE;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            pageMessage = CredentialsConstants.EMAIL_FAILURE_MESSAGE;
        }
        notificationResponse.setMessage(pageMessage);
        return notificationResponse;
    }

    private String buildMessageBody(Credentials credential) {
        StringBuffer buffer = new StringBuffer();
        String new_line = System.lineSeparator();
        buffer.append("Hi user,").append(new_line)
                .append("Please find below the credential details requested").append(new_line).append(new_line)
                .append("Account: ").append(credential.getAccount()).append(new_line)
                .append("User ID: ").append(credential.getUserId()).append(new_line)
                .append("Password: ").append(credential.getPassword()).append(new_line)
                .append("Password Type: ").append(credential.getPasswordType()).append(new_line).append(new_line)
                .append("Please logon to the account using the above credentials").append(new_line).append(new_line)
                .append("Thanks & regards,").append(new_line)
                .append("CredentialsSaveTeam");
        System.out.print(buffer.toString());
        return buffer.toString();
    }

   }
