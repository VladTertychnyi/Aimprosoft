<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change workers login</title>
</head>
<body>
<form action="controller">
    <input type="text" name="newWorkerLogin" value="${worker.login}" placeholder="Print new login" required/><br>
    <input type="hidden" name="curWorker_id" value="${curWorker_id}">
    <input type="submit" name="command" value="editWorkerLogin"/>
</form>
</body>
</html>
