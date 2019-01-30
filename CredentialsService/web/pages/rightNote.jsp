<%-- 
    Document   : rightNote
    Created on : 6 Oct, 2011, 2:14:54 AM
    Author     : Kingshuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<link href="${pageContext.request.contextPath}/style/credential_css.css" rel="stylesheet" type="text/css">
<div class="rightnote">
<table class="tableinfo">
<th  bgcolor="#50A6C2">Choose other update options</th>
<tr>
    <td><a  href="${pageContext.request.contextPath}/pages/enterCredentials.html?functionality=ADD_CREDENTIALS&subfunctionality=navigate" ><font color="#50A6C2">Add security questions</font></a></td></tr>
<tr> <td> <a  href="${pageContext.request.contextPath}/pages/viewCredentials.html?functionality=VIEW_CREDENTIALS&subfunctionality=navigate" ><font color="#50A6C2">Modify security questions</font></a></td></tr>
<tr><td> <a  href="${pageContext.request.contextPath}/pages/viewCredentials.html?functionality=VIEW_CREDENTIALS&subfunctionality=navigate" ><font color="#50A6C2">Delete security questions</font></a></td></tr>

</table>
</div>
