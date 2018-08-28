<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>1. Test CSS</h1>

<h2>2. Test JS</h2>
<div id="msg"></div>
konkurencje
<c:forEach items="${competitions}" var="competition">
    <p></p>

    <img src="<c:url value="/resource/images/${competition.competitionId}.jpg"></c:url> " alt="image" style="width: 100px"/>
    <h2>${competition.name}</h2>
    <%--<p>${competition.author.name}</p>--%>
    <%--<p>--%>
        <%--<a href="<spring:url value="/people/person?personId=${person.nameId}"/>">--%>
            <%--Opis--%>
        <%--</a>--%>
    <%--</p>--%>
    <p>
        <a href="<spring:url value="/competitions/competition?id=${competition.competitionId}"/>" class="btn btn-primary">
            <span class="glyphicon-info-sing glyphicon"/></span> Szczegóły
        </a>
    </p>
</c:forEach>
</body>
</html>
