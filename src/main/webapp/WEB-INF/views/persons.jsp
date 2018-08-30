<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${people}" var="person">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail" style="width: 270px; height: 300px">
                    <div class="panel-heading">${person.name}</div>
                    <img src="<c:url value="/resource/images/${person.nameId}.jpg"></c:url> " alt="image"
                         style="height: 150px; max-width: 250px;  padding-top: 15px"/>
                    <div class="description">
                        <h1>${person.name}</h1>

                    </div>
                    <div class="button">
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
