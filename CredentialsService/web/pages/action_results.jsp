<%-- 
    Document   : confirmCredentials
    Created on : 26 Aug, 2011, 10:09:13 PM
    Author     : Kingshuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Your credential view</title>
        <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/style/credential_css.css" >
        <script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
    </head>

    <body>
        <div id="allcontent">
            <%@include file="/pages/header.jsp" %>
            <div id="actual_content">
                <%@include file="/pages/cr_leftnav.jsp" %>
                <div id="content-body">
                    <div class="success_notifications">
                        <h4><img src="${pageContext.request.contextPath}/images/correct.jpg" />&nbsp;&nbsp;
                            <span class="green"><c:out  value="${page_message}"  /></span></h4>
                    </div>   
                </div>
            </div>
    </body>
</html>
