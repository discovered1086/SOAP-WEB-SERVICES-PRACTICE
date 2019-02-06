<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
    Document   : searchDetails
    Created on : 2 Sep, 2011, 11:44:34 PM
    Author     : Kingshuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Your credential view</title>

        <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/style/credential_css.css" >
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
                            <c:choose>
                                <c:when test="${search_success eq 'true'}" >
                                    <table class="tabledata">
                                        <th bgcolor="#50A6C2">Account id</th>
                                        <th bgcolor="#50A6C2">Account name</th>
                                        <th bgcolor="#50A6C2">User ID</th>
                                        <th bgcolor="#50A6C2">Password</th>
                                        <th bgcolor="#50A6C2">URL</th>
                                        <th bgcolor="#50A6C2">Password type</th>
                                        <th bgcolor="#50A6C2" colspan="2">Modify</th>
                                            <c:forEach var="searchList" items="${search_results}">
                                            <tr>
                                                <td><c:out value="${searchList.accountId}"  /></td>
                                                <td><c:out value="${searchList.account}"  /></td>
                                                <td><c:out value="${searchList.userId}"  /></td>
                                                <td><c:out value="${searchList.password}"  /></td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${searchList.url ne 'N/A'}">
                                                            <a href="<c:out value="${searchList.url}"  />"  target="_blank"><font color="sky blue"><c:out value="${searchList.url}"  /></font></a></td>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:out value="${searchList.url}"  />
                                                                </c:otherwise>
                                                            </c:choose>
                                                <td><c:out value="${searchList.passwordType}"  /></td>
                                                <td><a  href="${pageContext.request.contextPath}/pages/modifyCredentials.html?functionality=VIEW_CREDENTIALS&subfunctionality=update_credentials&accountid=<c:out value="${searchList.accountId}"  />" ><font color="sky blue">Update</font></a></td>
                                                <td><a  href="${pageContext.request.contextPath}/pages/modifyCredentials.html?functionality=VIEW_CREDENTIALS&subfunctionality=delete_credentials&accountid=<c:out value="${searchList.accountId}"  />" ><font color="sky blue">Delete</font></a></td>
                                                <%--<td><a  href="${pageContext.request.contextPath}/pages/sendemail.html?functionality=SEND_EMAIL&subfunctionality=add_email&accountid=<c:out value="${searchList.accountId}"  />" ><font color="sky blue">Send Email</font></a></td>--%>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </c:when>
                                <c:otherwise>
                                    <table class="tableinfo" width="35%">
                                        <th colspan="2" bgcolor="#50A6C2">Your search results</th>

                                        <tr>
                                            <td>
                                                <c:out  value="${page_message}"  />
                                            </td>

                                        <tr>
                                            <td><a  href="${pageContext.request.contextPath}/pages/viewCredentials.html?functionality=VIEW_CREDENTIALS&subfunctionality=navigate" ><font color=" sky blue">Search again </font></a>
                                            </td>
                                        </tr>
                                        </tr>

                                    </table>
                                </c:otherwise>
                            </c:choose>
                                         </form>   
                </div>
            </div>
    </body>
</html>
