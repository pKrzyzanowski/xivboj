<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springc" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<section class="container" ng-app="cartApp">
    <div class="row">

        <div class="col-md-3">
            <h1>${competition.name}</h1>
            <br>
            <br>
            <br>

            <p style="font-size: 20px"><strong><springc:message code="competition.rules"/></strong> ${competition.rules}
            </p>
            <p style="font-size: 20px">
                <strong><springc:message
                        code="competition.preferedTime"/>
                </strong>${competition.preferedTime}
                <springc:message code="competition.min"/></p>
            <p style="font-size: 20px">
                <strong>Autor:
                </strong>
                ${competition.autorsName}
            </p>
            <br>
            <br>
            <p data-ng-controller="cartCtrl">
                <a href="<spring:url value="/competitions"/>" class="btn btn-primary"> <springc:message
                        code="competition.backToCompetitions"/></a>
                <a href="#" ng-click="addToCart('${competition.competitionId}')" class="btn btn-primary">
                    <springc:message
                            code="competition.voteNow"/></a>

        </div>
        <div class="col-md-4">
            <img src="<c:url value="/resource/images/competitions/${competition.competitionId}.jpg"></c:url> "
                 alt="image"
                 style="width: 300px"/>
        </div>
        </p>
        <br>
        <div class="col-md-5">
            <h1>Osoby g³osuj±ce</h1>
            <br>
            <br>

            <c:forEach items="${competition.personList}" var="person">
                <div class=" col-md-6" style="padding-bottom: 15px">
                    <div class="thumbnail" style="width: 170px; height: 160px">


                        <div class="panel-heading"><strong>${person.name}</strong></div>
                        <div style="position: relative;text-align: center">
                            <img src="<c:url value="/resource/images/persons/${person.nameId}.jpg"></c:url> "
                                 alt="image"
                                 style="width: 100px; max-height: 80px;  padding-top: 15px"/>
                        </div>


                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>


</body>
</html>
