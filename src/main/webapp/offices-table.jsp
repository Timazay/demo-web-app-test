<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: st
  Date: 11.07.2024
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Offices</title>
</head>
<body>
<%-- Declaration --%>
<%--<%!
    int counter = 0;
%>--%>


<!--- Scriptlet --->
<c:if test="${offices == null}">
    <h3>No offices found</h3>
</c:if>

<c:if test="${offices != null}">
    <h3>offices to viev</h3>
</c:if>
<%--<%--%>
<%--    //java is here--%>
<%--    counter++;--%>
<%--    List<String> cars = (List<String>) request.getAttribute("cars");--%>
<%--    System.out.println("Hello from JSP Scriptlet");--%>
<%--    int x = (int) (Math.random() * 10) + 1;--%>
<%--    response.getWriter().println(x);--%>
<%--%>--%>

<table border="1">
    <th>OFFICE CODE</th>
    <th>CITY</th>
    <th>PHONE</th>
    <th>ADDRESS LINE #1</th>
    <th>ADDRESS LINE #2</th>
    <th>STATE</th>
    <th>COUNTRY</th>
    <th>POSTAL CODE</th>
    <th>TERRITORY</th>
    <%--UDATE/DELETE--%>
    <c:forEach var="car" items="${offices}">
        <tr>
            <td>
                <c:out value="${offices.officeCode}"/>
            </td>
            <td>
                <c:out value="${offices.city}"/>
            </td>
            <td>
                <c:out value="${offices.phone}"/>
            </td>
            <td>
                <c:out value="${offices.addressLine1}"/>
            </td>
            <td>
                <c:out value="${offices.addressLine2}"/>
            </td>
            <td>
                <c:out value="${offices.state}"/>
            </td>

            <td>
                <c:out value="${offices.country}"/>
            </td>
            <td>
                <c:out value="${offices.postalCode}"/>
            </td>
            <td>
                <c:out value="${offices.territory}"/>
            </td>
        </tr>
    </c:forEach>


</table>


<%--HTML is starting--%>


</body>
</html>
