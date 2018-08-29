<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
</head>
<body>
<c:forEach items="${people}" var="person">
    <img src="<c:url value="/resource/images/${person.nameId}.jpg"></c:url> " alt="image" style="width: 100px"/>
    <h2>${person.name}</h2>
    <p>${person.surname}</p>
    <p>${person.description}</p>
    <p>
        <a href="<spring:url value="/people/person?personId=${person.nameId}"/>">
            <spring:message code="persons.goToDescription"/>
        </a>
    </p>
</c:forEach>
</body>
</html>
