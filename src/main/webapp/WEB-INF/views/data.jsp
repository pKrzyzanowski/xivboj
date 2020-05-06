<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<html>
<head>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${data.rooms}" var="room">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail" style="width: 270px; height: 300px">
                    <div class="panel-heading"><p style="font-size: 20px"><strong>${room}</strong></div>
                    </p>


                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
