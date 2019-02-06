<%-- 
    Document   : enterCredentials
    Created on : 25 Aug, 2011, 12:16:43 AM
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
                    <input type="hidden" name="functionality" value="ADD_CREDENTIALS" />
                    <input type="hidden" name="subfunctionality" value="save_credentials"  />
                    <table class="tableinfo">
                        <th colspan="2" >enter your credentials</th>

                        <tr>
                            <td>Account</td>
                            <td align="left"><input type="text" name="account" size="25" /></td>
                        </tr>
                        <tr>
                            <td>Password Type</td>
                            <td align="left"><input type="text" name="password_type" size="25"  /></td>
                        </tr>
                        <tr>
                            <td>user id</td>
                            <td align="left"><input type="text" name="user_id" size="25" /></td>
                        </tr>
                        <tr>
                            <td>password</td>
                            <td align="left"><input type="password" name="password" size="25"  /></td>
                        </tr>
                        <tr>
                            <td>URL</td>
                            <td align="left"><input type="text" name="URL" size="35"  /></td>
                        </tr>
                        <tr >
                            <td>&nbsp;&nbsp;</td>
                            <td align="left"><input type="checkbox" name="securityQuestionsCheck" />
                                I have security questions set for this account</td>
                        </tr>
                        <tr>
                            <td>&nbsp;&nbsp;</td>
                            <td align="left"><input type="button" name="save" value="save" onClick="doSubmit(thisForm)" />
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
