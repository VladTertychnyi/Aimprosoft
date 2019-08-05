<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Department Name</title>
</head>
<body>
<br>
<a href="<c:url value="/controller"/>">start page</a>
<br>
<br>
<form action="/controller">
    <input type="text" name="name" value="${department.name}" placeholder="Name of Department" required/><br>
    <input type="hidden" pattern="^[ 0-9]+$" name="curDepartment_id" value="${curDepartment_id}">
    <input type="submit" name="command" value="editDepartment"/>
</form>
</body>
</html>
