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
    <title>Cars Table</title>
</head>
<body>
<%-- Declaration --%>
<%--<%!
    int counter = 0;
%>--%>
<c:set var="counter" scope="session" value="${0}"/>

<h4>PAGE COUNTER:
  <c:out value="${counter = counter + 1}"/>
</h4>

<!--- Scriptlet --->
<c:if test="${cars == null}">
    <h3>No cars to viev</h3>
</c:if>
<c:if test="${cars != null}">
    <h3>cars to viev</h3>
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
    <tr>
        <th>NAME</th>
        <th>PRICE</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>
                <c:out value="${car}"/>
            </td>
            <td>
                <c:out value="${2000 + 2000}"/>
              <%--  <%=(int) ((Math.random() * 2000) + 2000)%>--%>
            </td>
        </tr>
    </c:forEach>


</table>


<%--HTML is starting--%>


</body>
</html>
