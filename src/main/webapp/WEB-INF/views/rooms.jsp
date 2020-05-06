<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>
<html>
<head>

</head>


<body>


<div class="container" ng-controller="roomCtrl">
        <div class="row">
            <c:forEach items="${rooms}" var="room">
                <tr ng-repeat="room in rooms">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail" style="width: 270px; height: 300px">
                            <div class="panel-heading">
                              Number: <p style="font-size: 20px"><strong>${room.number}</strong></p>
                            </div>
                            <div class="panel-heading">
                                Seating capacity: <p style="font-size: 20px"><strong>${room.seatingCapacity}</strong></p>
                            </div>

                            <a href="#" class="label label-danger"
                               ng-click="clearRooms('${room.id}')"> <span
                                    class="glyphicon glyphicon-remove"></span> remove
                            </a>
                        </div>
                    </div>
                </tr>
            </c:forEach>
        </div>
</div>
</body>
</html>
