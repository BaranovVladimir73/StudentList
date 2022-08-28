<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<form:form action="add" modelAttribute = "student" >

    <form:hidden path="id"/>
    <br>
    Имя: <form:input path="name"/>
    <br>
    Возраст: <form:input path="age"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>