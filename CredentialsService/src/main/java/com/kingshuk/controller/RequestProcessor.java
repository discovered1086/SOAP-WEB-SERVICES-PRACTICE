/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingshuk.controller;

import com.credentialservice.business.Credentials;
import com.kingshuk.business.CredentialServiceBusinessDelegate;
import com.kingshuk.business.CredentialServiceBusinessDelegateImpl;
import com.kingshuk.utility.CredentialsConstants;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Kingshuk
 */
public class RequestProcessor {
    private CredentialServiceBusinessDelegate businessDelegate;

    public RequestProcessor() {
        businessDelegate=new CredentialServiceBusinessDelegateImpl();
    }

    public String respondToRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        boolean isSessionNew = session.isNew();
        String requestedURL = request.getServletPath();
        String functionality = request.getParameter(CredentialsConstants.FUNCTIONALITY);
        String subFunctionality = request.getParameter(CredentialsConstants.SUB_FUNCTIONALITY);
        
        if ((CredentialsConstants.ADD_CREDENTIALS_FUNCTIONALITY.equals(functionality)
                || CredentialsConstants.VIEW_CREDENTIALS_FUNCTIONALITY.equals(functionality))
                && CredentialsConstants.NAVIGATE.equals(subFunctionality)) {
            return convertToHtml(requestedURL);
        } else if (CredentialsConstants.ADD_CREDENTIALS_FUNCTIONALITY.equals(functionality)) {
            if (CredentialsConstants.SAVE_CREDENTIALS.equals(subFunctionality)) {
                try {
                    Credentials credential = new Credentials();
                    credential.setAccount(request.getParameter(CredentialsConstants.ACCOUNT));
                    credential.setPasswordType(request.getParameter(CredentialsConstants.PASSWORD_TYPE));
                    credential.setPassword(request.getParameter(CredentialsConstants.PASSWORD));
                    credential.setUserId(request.getParameter(CredentialsConstants.USER_ID));
                    credential.setUrl(request.getParameter(CredentialsConstants.URL));

                    businessDelegate.saveCredentials(credential);
                    
                    request.setAttribute(CredentialsConstants.TRANSACTION_RESULT, CredentialsConstants.SUCCESS);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.SUCCESS_MESSAGE);
                    return convertToHtml(requestedURL);
                } catch (Exception e) {
                    e.printStackTrace();
                    //throw new RuntimeException("The credentials you entered could not be saved in database due to an error");
                    request.setAttribute(CredentialsConstants.TRANSACTION_RESULT, CredentialsConstants.FAILURE);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.FAILURE_MESSAGE);
                }
            }
        } else if (CredentialsConstants.VIEW_CREDENTIALS_FUNCTIONALITY.equals(functionality)) {
            if (CredentialsConstants.SEARCH_CREDENTIALS.equals(subFunctionality)) {
                try {
                    List<Credentials> searchResults = businessDelegate.getCredentialsList(request.getParameter(CredentialsConstants.SEARCH_VALUE));
                    if (searchResults.size() > 0) {
                        session.setAttribute(CredentialsConstants.SEARCH_RESULTS, searchResults);
                        request.setAttribute(CredentialsConstants.SEARCH_SUCCESS, CredentialsConstants.TRUE_SMALL);
                    } else {
                        request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.SEARCH_FAILURE_MESSAGE);
                        request.setAttribute(CredentialsConstants.SEARCH_SUCCESS, CredentialsConstants.FALSE_SMALL);
                    }
                    return convertToHtml(requestedURL);
                } catch (Exception e) {
                    e.printStackTrace();
                    //throw new RuntimeException("An error occurred while searching for your credentials");
                    request.setAttribute(CredentialsConstants.SEARCH_SUCCESS, CredentialsConstants.FALSE_SMALL);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.SEARCH_FAILURE_MESSAGE);
                }
            } else if (CredentialsConstants.UPDATE_CREDENTIALS.equals(subFunctionality)) {
                try {
                    String account_id = request.getParameter(CredentialsConstants.ACCOUNT_ID);
                    List<Credentials> searchResults = (List<Credentials>) session.getAttribute(CredentialsConstants.SEARCH_RESULTS);
                    
                    
                    request.setAttribute(CredentialsConstants.CREDENTIALS_INFO, businessDelegate.getCredentialForStorage(searchResults, account_id));
                    
                    request.setAttribute(CredentialsConstants.ACCOUNT_ID, account_id);
                    request.setAttribute(CredentialsConstants.UPDATE_ACTION, CredentialsConstants.TRUE_SMALL);
                    
                    return convertToHtml(requestedURL);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (CredentialsConstants.DELETE_CREDENTIALS.equals(subFunctionality)) {
                String account_id = request.getParameter(CredentialsConstants.ACCOUNT_ID);
                List<Credentials> searchResults = (List<Credentials>) session.getAttribute(CredentialsConstants.SEARCH_RESULTS);
                
               
                request.setAttribute(CredentialsConstants.CREDENTIALS_INFO, businessDelegate.getCredentialForStorage(searchResults, account_id));
                
                request.setAttribute(CredentialsConstants.DELETE_ACTION, CredentialsConstants.TRUE_SMALL);
                return convertToHtml(requestedURL);
            } else if (CredentialsConstants.SAVE_UPDATES.equals(subFunctionality)) {
                try {
                    Credentials credential = new Credentials();
                    credential.setAccountId(request.getParameter(CredentialsConstants.ACCOUNT_ID));
                    credential.setAccount(request.getParameter(CredentialsConstants.ACCOUNT));
                    credential.setPasswordType(request.getParameter(CredentialsConstants.PASSWORD_TYPE));
                    credential.setPassword(request.getParameter(CredentialsConstants.PASSWORD));
                    credential.setUserId(request.getParameter(CredentialsConstants.USER_ID));
                    credential.setUrl(request.getParameter(CredentialsConstants.URL));
                    
                    businessDelegate.updateCredentials(credential);
                    
                    request.setAttribute(CredentialsConstants.UPDATE_STATUS, CredentialsConstants.SUCCESS);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.UPDATE_SUCCESS_MESSAGE);
                    
                    return convertToHtml(requestedURL);
                } catch (Exception e) {
                    e.printStackTrace();
                    //throw new RuntimeException(e.getMessage());
                    request.setAttribute(CredentialsConstants.UPDATE_STATUS, CredentialsConstants.FAILURE);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.UPDATE_SUCCESS_MESSAGE);
                }
            } else if (CredentialsConstants.DELETE_SAVED_CREDENTIALS.equals(subFunctionality)) {
                try {
                   
                    businessDelegate.deleteCredentials(request.getParameter(CredentialsConstants.ACCOUNT_ID));
                    
                    request.setAttribute(CredentialsConstants.UPDATE_STATUS, CredentialsConstants.SUCCESS);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, CredentialsConstants.DELETE_SUCCESS_MESSAGE);
                    return convertToHtml(requestedURL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (CredentialsConstants.SEND_EMAIL_FUNCTIONALITY.equals(functionality)) {
            if (CredentialsConstants.ADD_EMAIL_ID.equals(subFunctionality)) {
                try {
                    String accountId = request.getParameter(CredentialsConstants.ACCOUNT_ID);
                    List<Credentials> searchResults = (List<Credentials>) session.getAttribute(CredentialsConstants.SEARCH_RESULTS);
                    
                    session.setAttribute(CredentialsConstants.CREDENTIALS_INFO, businessDelegate.getCredentialForStorage(searchResults, accountId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return convertToHtml(requestedURL);
            } else if (CredentialsConstants.SEND_EMAIL.equals(subFunctionality)) {
                try {
                    Credentials credential = (Credentials) session.getAttribute(CredentialsConstants.CREDENTIALS_INFO);
                    String emailAddress = request.getParameter(CredentialsConstants.EMAIL_ADDRESS);
                    request.setAttribute(CredentialsConstants.TRANSACTION_RESULT, CredentialsConstants.SUCCESS);
                    request.setAttribute(CredentialsConstants.PAGE_MESSAGE, businessDelegate.sendEmail(credential, emailAddress));
                    return convertToHtml(requestedURL);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        //return null;
        return convertToHtml(requestedURL);
    }

    private String convertToHtml(String URL) {
       return URL.replaceFirst("html", "jsp");
    }
}
