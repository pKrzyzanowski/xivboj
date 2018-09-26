<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springc" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>

<html lang="pl-PL">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<section class="container" ng-app="cartApp">
    <section class="row">
        <c:forEach items="${competitions}" var="competition">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail" style="width: 270px; height: 300px">
                    <div class="panel-heading"><p style="font-size: 20px"><strong>${competition.name}</strong></div>
                    </p>
                    <img src="<c:url value="/resource/images/competitions/${competition.competitionId}.jpg"></c:url>  "
                         alt="image"
                         style="width: 150px; max-height: 140px;  padding-top: 5px"/>


                    <div class="button" style="position: absolute ;; bottom: 10px;text-align: center">
                        <p data-ng-controller="cartCtrl">
                            <a href="#" class="btn btn-primary"
                               ng-click="addToCart('${competition.competitionId}')"> <springc:message
                                    code="competition.voteNow"/></a>
                        </p>
                        <a
                                href="<spring:url value="/competitions/competition?id=${competition.competitionId}"/>"
                                class="btn btn-primary">
                            <span class="glyphicon-info-sing glyphicon"/></span> <springc:message
                                code="competitions.button.details"/>
                        </a>

                    </div>

                </div>
            </div>

        </c:forEach>
    </section>


</section>
</body>
</html>
