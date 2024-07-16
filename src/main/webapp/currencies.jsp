<%@ page import="com.example.demowebapp.services.XMLCurrencyParser" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="static com.example.demowebapp.utils.ServletUtils.forward" %>
<%@ page import="static com.example.demowebapp.utils.ServletUtils.getLongParameter" %>
<%@ page import="static com.example.demowebapp.utils.ServletUtils.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: st
  Date: 11.07.2024
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency table</title>
</head>
<body>
<table border="1">
  <tr>
    <th>CURRENCY CODE</th>
    <th>CURRENCY RATE</th>
  </tr>
  <tr>
  <td><%=XMLCurrencyParser.getCurrency("840")%></td>
  <td>840</td>

  </tr>
  <%

  %>
</table>
</body>
</html>
