<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${people}" var="person">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail" style="width: 270px; height: 300px">
                    <div class="panel-heading"><p style="font-size: 20px"><strong>${person.name}</strong></div></p>
                    <div style="position: relative;text-align: center">
                    <img src="<c:url value="/resource/images/persons/${person.nameId}.jpg"></c:url> " alt="image"
                         style="height: 150px; max-width: 250px;  padding-top: 15px"/>
                    </div>
                    <div class="button" style="position: absolute ;right:120px; bottom: 10px;text-align: center">
                        <p>
                            <a href="<spring:url value="/people/person?personId=${person.nameId}"/>"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sing glyphicon"/></span> <spring:message
                                    code="persons.goToDescription"/>
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
