<%-- 
    Document   : rightNav
    Created on : 5 Jan, 2011, 2:25:32 AM
    Author     : Kingshuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/style/credential_css.css" rel="stylesheet" type="text/css">
<div id="sidebar">
    <ul >
          <li ><a  href="${pageContext.request.contextPath}/pages/enterCredentials.html?functionality=ADD_CREDENTIALS&subfunctionality=navigate" >Add credential</a></li>
          <li ><a  href="${pageContext.request.contextPath}/pages/viewCredentials.html?functionality=VIEW_CREDENTIALS&subfunctionality=navigate" >View credential</a></li>
          </ul>
</div>