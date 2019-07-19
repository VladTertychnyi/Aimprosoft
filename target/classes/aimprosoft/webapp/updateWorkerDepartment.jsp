<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change worker department</title>
</head>
<body>
<form action="controller">
    <input type="text" pattern="^[ 0-9]+$" name="newDepartmentId" value="${worker.department_id}" placeholder="Print ID of new department" required/><br>
    <input type="hidden" name="curWorker_id" value="${curWorker_id}">
    <input type="submit" name="command" value="editWorker"/>
</form>
</body>
</html>
