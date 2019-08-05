<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <style type="text/css">
        <%@include file='style.css'%>
    </style>
</head>
<body>
<br>
<input type="button" onclick="history.back()"; value="previous page"/>
<br>
<br>
<p>Message: <%=request.getParameter("message")%></p>
<p>Cause: <%=request.getParameter("cause") %></p>
</body>
</html>
