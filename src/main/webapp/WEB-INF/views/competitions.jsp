<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</c:forEach>
</body>
</html>
