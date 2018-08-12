<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

konkurencje
<c:forEach items="${competitions}" var="competition">
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
