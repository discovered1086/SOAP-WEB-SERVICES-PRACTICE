<%-- 
    Document   : viewCredentials
    Created on : 25 Aug, 2011, 12:17:06 AM
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
                    <form name="view_form" method="post"  action="searchDetails.html"    >
                        <input type="hidden" name="functionality" value="VIEW_CREDENTIALS"  />
                        <input type="hidden" name="subfunctionality" value="search_credentials"  />
                        <table class="tableinfo">
                            <th colspan="2" bgcolor="#50A6C2">Search your credentials</th>

                            <tr>
                                <td>
                                    <input type="text" name="search_value" value="" size="35" />
                                </td>

                                <td><input type="button"  name="search" value="search" size="30"  onClick="doSubmit(view_form)" /></td>
                            </tr>
                            <tr>
                                <td><a  href="${pageContext.request.contextPath}/pages/searchDetails.html?functionality=VIEW_CREDENTIALS&subfunctionality=search_credentials" ><font color="sky blue">View all credentials</font></a>
                                </td>
                                <td>&nbsp;&nbsp;</td></tr>
                        </table>
                    </form>   
                </div>
            </div>
    </body>
</html>
