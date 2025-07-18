<%--
  Created by IntelliJ IDEA.
  User: linuxul
  Date: 25. 7. 18.
  Time: 오전 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Demo - 회원목록</title>
</head>
<body>

<h2>Spring MVC Demo - 회원목록</h2>
<table>
    <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.email}</td>
            <td>${member.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
