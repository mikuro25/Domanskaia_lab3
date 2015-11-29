<%--
  Created by IntelliJ IDEA.
  User: Hanna
  Date: 14.10.15
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8" />
</head>
<body>
    <form action="list">
        <label>
            Search by name
            <input type="text" name="name"/>
        </label>
        <input type="submit" value="Search"/>
    </form>
    <form action="list">
        <label>
            Search by type
            <input type="text" name="type"/>
        </label>
        <input type="submit" value="Search"/>
    </form>
</body>
</html>
