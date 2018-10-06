<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<html>
<head>
</head>
<body>


<section class="container">
    <div class="row">
        <p></p>
        <p></p>
        <p></p>
        <div class="col-md-3">
            <h1>${person.name}</h1>
            <p></p>
            <p></p>
            <p style="font-size: 20px"><strong><spring:message code="person.surmane"/></strong>${person.surname}
            </p>
            <p style="font-size: 20px"><strong><spring:message code="person.description"/></strong>${person.description}
            </p>
            <p style="font-size: 20px"><strong><spring:message code="person.age"/></strong>${person.age}</p>


            <p>
                <br>
                <br>
                <a href="<spring:url value="/people"/>">
                    <button type="button" class="btn btn-outline-secondary">
                        <spring:message
                                code="person.button.backToPeople"/>
                    </button>
                </a>


        </div>

        <div class="col-md-4">
            <br>
            <br>
            <img src="<c:url value="/resource/images/persons/${person.nameId}.jpg"></c:url> " alt="image"
                 style="width: 300px"/>
        </div>
        <div class="col-md-5">
            <h1>Oddane g³osy</h1>
            <br>
            <br>
            <c:forEach items="${person.competitionList}" var="competition">

                <p>
                <div class="col-md-6" style="padding-bottom: 15px">
                    <div class="thumbnail" style="width: 170px; height: 160px">
                        <div class="panel-heading"><strong>${competition.name}</strong></div>
                        <img src="<c:url value="/resource/images/competitions/${competition.competitionId}.jpg"></c:url>  "
                             alt="image"
                             style="width: 100px; max-height: 80px;  padding-top: 15px"/>

                    </div>
                </div>
                </p>
            </c:forEach>
        </div>
        </p>
    </div>
</section>
<p></p>
<p></p>

</body>
</html>
