<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springc" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<section class="container" ng-app="cartApp">
    <div class="row">
        <br>
        <br>
        <br>
        <div class="col-md-5">
            <h1>${competition.name}</h1>


            <p style="font-size: 20px"><strong><springc:message code="competition.rules"/></strong> ${competition.rules}
            </p>
            <p style="font-size: 20px"><strong><springc:message
                    code="competition.preferedTime"/> </strong>${competition.preferedTime}
                <springc:message code="competition.min"/></p>

            <br>
            <br>
            <p data-ng-controller="cartCtrl">
                <a href="<spring:url value="/competitions"/>" class="btn btn-primary"> <springc:message
                        code="competition.backToCompetitions"/></a>
                <a href="#" ng-click="addToCart('${competition.competitionId}')" class="btn btn-primary"> <springc:message
                        code="competition.voteNow"/></a>

        </div>
        <div class="col-md-5">
            <img src="<c:url value="/resource/images/${competition.competitionId}.jpg"></c:url> " alt="image"
                 style="width: 300px"/>
        </div>
        </p>
        <br>
        <br>
        <br>
    </div>
</section>


</body>
</html>
