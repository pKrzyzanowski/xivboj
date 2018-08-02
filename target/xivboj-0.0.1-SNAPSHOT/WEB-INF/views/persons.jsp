<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
</head>
<body>
<c:forEach items="${people}" var="person">
    <h2>${person.name}</h2>
    <p>${person.surname}</p>
    <p>${person.description}</p>
    <p>
        <a href="<spring:url value="/people/person?personId=${person.nameId}"/>">
            Opis
        </a>
    </p>
</c:forEach>
</body>
</html>
