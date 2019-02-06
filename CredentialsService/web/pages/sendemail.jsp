<%-- 
    Document   : sendemail.jsp
    Created on : Apr 25, 2015, 1:41:23 PM
    Author     : Kingshuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <form name="thisForm" method="post" action="action_results.html">
                        <input type="hidden" name="functionality" value="SEND_EMAIL" />
                        <input type="hidden" name="subfunctionality" value="send_email"  />
                        <table class="tableinfo">
                            <th colspan="2" >Enter your email address</th>

                            <tr>
                                <td>Email Address</td>
                                <td align="left"><input type="text" name="email_address" size="25" /></td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;</td>
                                <td align="left"><input type="button" name="Send Email" value="Send Email" onClick="doSubmit(thisForm)" />
                                    &nbsp;&nbsp;
                                    <input type="reset" name="reset" value="clear"  />
                                </td>
                            </tr>
                        </table>
                    </form>   
                </div>
            </div>
    </body>
</html>
