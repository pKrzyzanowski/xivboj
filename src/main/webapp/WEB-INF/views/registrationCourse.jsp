<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>

<html>
<head>
</head>
<body>

<form:form modelAttribute="newCourse" class="form-horizontal" enctype="multipart/form-data">

    <fieldset>
        <legend>
            Dane Kursu
        </legend>

        <form:errors path="*" cssClass="alert alert-danger" element="div"/>

        <div class="form-group">
            <label class="control-label col-lg-2" for="name">name</label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text"/>

            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="maxNumberOfStudents">maxNumberOfStudents</label>
            <div class="col-lg-10">
                <form:input id="maxNumberOfStudents" path="maxNumberOfStudents" type="text"/>

            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="numberOfHours">
                numberOfHours
            </label>
            <div class="col-lg-10">
                <form:input id="numberOfHours" path="numberOfHours" type="text"/>

            </div>
        </div>


        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" value=<spring:message code="addCompetition.addCompetition"/>>
            </div>
        </div>

    </fieldset>

</form:form>


</body>
</html>
