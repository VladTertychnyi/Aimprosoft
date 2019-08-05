<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers</title>
    <style type="text/css">
        <%@include file='style.css'%>
    </style>
</head>
<body>
<br>
<form action="addWorker.jsp">
    <button>add worker </button>
</form>
<br>
<a href="<c:url value="/controller"/>">start page</a>
<br>
<br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>LOGIN</th>
        <th>MAIL</th>
        <th>BIRTHDAY DATE</th>
        <th>ACTIONS</th>
    </tr
    <c:forEach items="${workersList}" var="worker">
        <tr>
            <td>${worker.id}</td>
            <td>${worker.login}</td>
            <td>${worker.mail}</td>
            <td>${worker.date}</td>
            <td>
                <form action="/controller">
                    <input type="submit" name="command" value="deleteWorker"/>
                    <input type="submit" name="command" value="changeWorker"/>
                    <input type="submit" name="command" value="changeWorkerLogin"/>
                    <input type="hidden" name="curWorker_id" value="${worker.id}"/>
                    <input type="hidden" name="curWorker_login" value="${worker.login}">
                    <input type="hidden" name="curWorker_mail" value="${worker.mail}"/>
                    <input type="hidden" name="curWorkerDepartment_id" value="${worker.department_id}">
                </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
