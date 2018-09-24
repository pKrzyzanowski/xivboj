<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
    <style>
        {
            margin-bottom: 50px
        ;
            border-radius: 0
        ;
        }
        {
            margin-bottom: 0
        ;
        }

        footer {
            background-color: #ffffff;
            padding: 15px;
        }
    </style>
</head>
<body>

<section class="container" data-ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">


        <table class="table table-hover">
            <tr>
                <th>Twoje głosy</th>
                <div><strong>{{cartId}}</strong></div>
                <div><strong>${cart.cartId}</strong></div>
                <div><strong>${cart}</strong></div>
            </tr>


            ${competition.name}


            <%--<tr ng-repeat="competition in ${cart.allCartCompe}">--%>
            //
            <%--<tr ng-repeat="item in cart.allCartCompe">--%>
            <c:forEach items="${cart.allCartCompe}" var="competition">
                <tr>
                    <td>
                        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                            <div class="thumbnail" style="width: 170px; height: 160px">
                                <div class="panel-heading"><p>
                                    <div><strong>{{competition.name}}</strong></div>
                                        ${competition.name}
                                        <%--<strong>{{competition.name}}</strong></div>--%>
                                    </p>
                                    <img src="<c:url value="/resource/images/competitions/${competition.competitionId}.jpg" ></c:url>  "
                                         alt="image"
                                         style=" max-height: 80px;  padding-bottom: 30px"/>
                                    <div class="button" style="position: absolute ;; bottom: 10px;text-align: center">
                                        <a href="#" class="label label-danger"
                                           ng-click="removeFromCart(competition.competitionId)"> <span
                                                class="glyphicon glyphicon-remove"></span> <spring:message
                                                code="cart.backOffVote"/>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>


            <td>

            </td>
            <%--</tr>--%>

        </table>

        <a href="<spring:url value="/competitions" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> <spring:message code="cart.return"/>
        </a>

        <a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"> <span
                class="btn btn-success btn-right"></span> <spring:message code="cart.vote"/>
        </a>

        <a href="<spring:url value="/competitions/vote"/>" class="btn btn-success pull-right"> <span
                class="btn btn-success btn-right"></span>oddaj glosy
        </a>


    </div>
</section>
</body>
</html>