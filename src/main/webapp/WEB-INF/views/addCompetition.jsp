<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
</head>
<body>

<form:form modelAttribute="newCompetition" class="form-horizontal" enctype="multipart/form-data">

    <fieldset>

        <legend>
            Dodaj nową konkurencję
        </legend>
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>


        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="competitionId">
                <spring:message code="addCompetition.form.competitionId.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="competitionId" path="competitionId" type="text"/>
                <form:errors path="competitionId" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">
                <spring:message code="addCompetition.form.name.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="preferedTime">
                <spring:message code="addCompetition.form.preferedTime.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="preferedTime" path="preferedTime" type="text"/>
                <form:errors path="preferedTime" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="rules">
                <spring:message code="addCompetition.form.rules.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="rules" path="rules" type="text"/>
                <form:errors path="rules" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="competitionImage">
                <spring:message code="addCompetition.form.competitionImage.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="competitionImage" path="competitionImage" type="file"/>
                <form:errors path="competitionImage" cssClass="text-danger"/>
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
