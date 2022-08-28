<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students List</title>
    <style type="text/css">
        .box div { display:inline-block; }
        .btn {
            display: inline-block;
            background: #8C959D;
            color: #fff;
            padding: 0.1rem 0.5rem;
            text-decoration: none;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<h1>Students List</h1>
<ul>
    <c:forEach var="student" items="${students}">
        <c:url var="editUrl" value="/student/">
            <c:param name="id" value="${student.id}"/>
        </c:url>
        <c:url var="deleteUrl" value="/student/delete/">
            <c:param name="id" value="${student.id}"/>
        </c:url>
        <li>
            <div class="box">
                <div>${student.id} ${student.name} ${student.age} лет</div>
                <div><a href="${editUrl}" class="btn">Изменить</a></div>
                <div><a href="${deleteUrl}" class="btn">Удалить</a></div>
            </div>
            <br>
        </li>
    </c:forEach>

    <c:url var="createUrl" value="/student/add"/>
    <form action="${createUrl}">
        <div><button type="submit">Добавить</button></div>
    </form>

</ul>
<br>

</body>
</html>