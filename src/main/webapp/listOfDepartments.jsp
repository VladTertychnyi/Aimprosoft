<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of departments</title>
    <style type="text/css">
        <%@include file='style.css'%>
    </style>
</head>
<body>
<br>
<form action="addDepartment.jsp">
    <button>add new department</button>
</form>
<a href="<c:url value="/controller"/>">start page</a>
<br>
<br>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${departmentsList}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>
                <form action="/controller">
                    <input type="submit" name="command" value="deleteDepartment"/>
                    <input type="submit" name="command" value="updateDepartment"/>
                    <input type="submit" name="command" value="GetAllWorkersFromDepartment"/>
                    <input type="hidden" name="curDepartment_id" value="${department.id}"/>
                    <input type="hidden" name="curDepartment_name" value="${department.name}"/>
                    <input type="hidden" name="defaultDepartment" value="999"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
