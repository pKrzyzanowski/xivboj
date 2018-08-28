<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springc" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div class="container">
    <div class="row">

            <springc:message code="addCompetition.form.competitionName.label"/>

        <c:forEach items="${competitions}" var="competition">
            <div class="col-sm-4 col-md-2" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <img src="<c:url value="/resource/images/${competition.competitionId}.jpg"></c:url> " alt="image"
                         style="width: 100px; padding-top: 15px"/>
                    <div class="description">
                        <p>${competition.name}</p>
                            <%--<p>${competition.author.name}</p>--%>
                            <%--<p>--%>
                            <%--<a href="<spring:url value="/people/person?personId=${person.nameId}"/>">--%>
                            <%--Opis--%>
                            <%--</a>--%>
                            <%--</p>--%>
                    </div>
                    <div class="button">
                        <p>
                            <a href="<spring:url value="/competitions/competition?id=${competition.competitionId}"/>"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sing glyphicon"/></span> Szczegóły
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
