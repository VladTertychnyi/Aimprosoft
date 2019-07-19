<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD NEW WORKER</title>
</head>
<body>
<br>
<a href="<c:url value="/controller"/>">Start page</a>
<br>
<br>
<form action="controller">
    <input type="text" pattern="^[ 0-9]+$" name="curWorker_id" value="${worker.id}" placeholder="id of worker" required/><br>
    <input type="text" name="login" value="${worker.login}" placeholder="login of worker" required/><br>
    <input type="text" pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$" name="mail"
           value="${worker.mail}" placeholder="mail of worker" required/><br>
    <input type="date" name="bdate" value="${worker.date}" required/><br>
    <input type="text" pattern="^[ 0-9]+$" name="depIdOfCurWorker" value="${worker.department_id}"
           placeholder="id of workers department" required/><br><br>
    <input type="submit" name="command" value="addWorker"/>
</form>
</body>
</html>
