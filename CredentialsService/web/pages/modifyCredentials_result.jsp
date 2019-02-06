<%-- 
    Document   : modifyCredentials_result
    Created on : 3 Sep, 2011, 4:41:58 PM
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
    <center><h2>Enter your credential information</h2></center>

</head>

<body>
    <%@include file="/pages/cr_leftnav.jsp" %>

    <form name="thisForm" method="post" action="">
        <input type="hidden" name="functionality" value="ADD_CREDENTIALS" />
        <input type="hidden" name="subfunctionality" value=""  />
        <center>
        <table class="tableinfo" width="35%">
            <th colspan="2" bgcolor="#50A6C2"> Your transaction result</th>

            <tr>
                <td>
                    <c:if test="${update_status eq 'success'}" >
                       <font color="#006600"> <c:out  value="${page_message}"  /></font>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><a  href="${pageContext.request.contextPath}/pages/searchDetails.html?functionality=VIEW_CREDENTIALS&subfunctionality=search_credentials" ><font color="sky blue">search for other credentials to update </font></a>
               </td>
            </tr>
             </table>



</center>
    </form>
</body>


</html>

