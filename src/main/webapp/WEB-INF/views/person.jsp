<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
</head>
<body>


<section class="container">
    <div class="row">
        <p></p>
        <p></p>
        <p></p>
        <div class="col-md-5">
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
                <a href="<spring:url value="/people"/>" class="btn btn-primary"> <spring:message
                        code="person.button.backToPeople"/></a>

        </div>
        <div class="col-md-5">
            <img src="<c:url value="/resource/images/persons${person.nameId}.jpg"></c:url> " alt="image" style="width: 300px"/>
        </div>
        </p>
    </div>
</section>
<p></p>
<p></p>

</body>
</html>
