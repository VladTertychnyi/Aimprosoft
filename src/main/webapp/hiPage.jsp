<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Start page</title>
    <style type="text/css">
        <%@include file='style.css'%>
    </style>
</head>
<body>
 <form action="/controller">
     <input type="submit" name="command" value="GetAllDepartments"/><br><br>
     <input type="submit" name="command" value="GetAllWorkers"/>
 </form>
</body>
</html>
