<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8" />
</head>
<body>
    <c:if test="${role == 'admin'}">
        <h3>Finded events:</h3>(<a href="add">add</a>)<br>
    </c:if>
    (<a href="search">search</a>)<br>
    (<a href="logout">logout</a>)
    <ol>
        <c:forEach items="${enterprises}" var="enterprise">
            <li>
                ${enterprise.name} - ${enterprise.type} - ${enterprise.mdate}
                <c:if test="${role == 'admin'}">
                    <a href="add?id=${enterprise.eventId}">edit</a> | <a href="delete?id=${enterprise.eventId}">delete</a>
                </c:if>
            </li>
        </c:forEach>
    </ol>
</body>
</html>
