<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<c:forEach items="${competitionList}" var="competition">
    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
        <div class="thumbnail" style="width: 270px; height: 300px">
            <c:if test="${competition.personList.size()>treshHold}">
                <div class="alert alert-success" role="alert">
                    Przechodzi
                </div>
            </c:if>
            <c:if test="${competition.personList.size()==treshHold}">
                <div class="alert alert-secondary" role="alert">
                    Ex aequo
                </div>
            </c:if>
            <c:if test="${competition.personList.size()<treshHold}">
                <div class="alert alert-danger" role="alert">
                    Odpada
                </div>
            </c:if>
            <div class="panel-heading"><p style="font-size: 20px"><strong>${competition.name}</strong></div>

            </p>
            <img src="<c:url value="/resource/images/competitions/${competition.competitionId}.jpg"></c:url>  "
                 alt="image"
                 style="width: 150px; max-height: 140px;  padding-top: 5px"/>

            <div class="button" style="position: absolute ;; bottom: 10px;text-align: center">
                <h3>${competition.personList.size()}</h3> - Ilość głosów
            </div>


        </div>
    </div>

</c:forEach>
</body>
</html>
