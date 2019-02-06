<%-- 
    Document   : modifyCredentials
    Created on : 25 Aug, 2011, 12:17:30 AM
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
                    <form name="thisForm" method="post" action="action_results.html">
                        <input type="hidden" name="functionality" value="VIEW_CREDENTIALS" />
                        <input type="hidden" name="subfunctionality" value=""  />
                        <table class="tableinfo">
                            <th colspan="2" bgcolor="#50A6C2">
                                <c:choose>
                                    <c:when test="${update_action eq 'true'}">
                                        Update your credentials
                                    </c:when>
                                    <c:otherwise>
                                        Delete your credentials
                                    </c:otherwise>
                                </c:choose>
                            </th>
                            <c:choose>
                                <c:when test="${update_action eq 'true'}"  >
                                    <tr>
                                        <td>Account id</td>
                                        <td align="left"><input type="text" name="accountid" size="25" value="<c:out  value='${credential_info.accountId}' />"   readonly="readonly"/></td>
                                    </tr>
                                    <tr>
                                        <td>Account</td>
                                        <td align="left"><input type="text" name="account" size="25" value="<c:out  value='${credential_info.account}' />"/></td>
                                    </tr>
                                    <tr>
                                        <td>Password Type</td>
                                        <td align="left"><input type="text" name="password_type" size="25" value="<c:out  value='${credential_info.passwordType}' />" /></td>
                                    </tr>
                                    <tr>
                                        <td>user id</td>
                                        <td align="left"><input type="text" name="user_id" size="25" value="<c:out  value='${credential_info.userId}' />"/></td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td align="left"><input type="password" name="password" size="25"  value="<c:out  value='${credential_info.password}' />"/></td>
                                    </tr>
                                    <tr>
                                        <td>URL</td>
                                        <td align="left"><input type="text" name="URL" size="35"  value="<c:out  value='${credential_info.url}' />"/></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td>Account id</td>
                                        <td align="left"><input type="text" name="accountid" size="25" value="<c:out  value='${credential_info.accountId}' />"  readonly="readonly"/></td>
                                    </tr>
                                    <tr>
                                        <td>Account</td>
                                        <td align="left"><c:out  value='${credential_info.account}' /></td>
                                    </tr>
                                    <tr>
                                        <td>Password Type</td>
                                        <td align="left"><c:out  value='${credential_info.passwordType}' /></td>
                                    </tr>
                                    <tr>
                                        <td>user id</td>
                                        <td align="left"><c:out  value='${credential_info.userId}' /></td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td align="left"><c:out  value='${credential_info.password}' /></td>
                                    </tr>
                                    <tr>
                                        <td>URL</td>
                                        <td align="left"><c:out  value='${credential_info.url}' /></td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            <tr>
                                <td>&nbsp;&nbsp;</td>
                                <td align="left">
                                    <c:choose>
                                        <c:when test="${update_action eq 'true'}">
                                            <input type="button" name="save" value="update" onClick="doSubmit(thisForm, 'save_updated_credentials')" />
                                        </c:when>
                                        <c:otherwise>
                                            <input type="button" name="save" value="delete" onClick="doSubmit(thisForm, 'delete_saved_credentials')" />
                                        </c:otherwise>
                                    </c:choose>

                                    &nbsp;&nbsp;
                                    <input type="button" name="cancel" value="cancel" onClick="javascript:history.go(-1)"  />
                                </td>
                            </tr>
                        </table>
                    </form>   
                </div>
            </div>
    </body>
</html>

