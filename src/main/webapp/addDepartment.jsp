<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD NEW DEPARTMENT</title>
</head>
<body>
<br>
<a href="<c:url value="/controller"/>">start page</a>
<br>
<br>
<form action="/controller">
    <input type="text" name="name" value="${department.name}" placeholder="name of department" required/><br>
    <input type="text" pattern="^[ 0-9]+$" name="curDepartment_id" value="${department.id}"
           placeholder="id of department" required/><br>
    <input type="submit" name="command" value="addDepartment"/>
</form>
</body>
</html>
