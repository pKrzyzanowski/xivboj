<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<html>
<head>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<div class="container" ng-controller="courseCtrl">
    <div class="row">
        <c:forEach items="${courses}" var="course">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail" style="width: 270px; height: 300px">
                    <div class="panel-heading"><p style="font-size: 20px">
                        Name: <strong>${course.name}</strong></p>
                    </div>
                    <div class="panel-heading"><p style="font-size: 20px">
                        Max num. of stu.: <strong>${course.maxNumberOfStudents}</strong></p>
                    </div>
                    <div class="panel-heading"><p style="font-size: 20px">
                        number of hours: <strong>${course.numberOfHours}</strong></p>
                    </div>


                    <a href="#" class="label label-danger"
                       ng-click="clearCourses('${course.id}')"> <span
                            class="glyphicon glyphicon-remove"></span> remove
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
