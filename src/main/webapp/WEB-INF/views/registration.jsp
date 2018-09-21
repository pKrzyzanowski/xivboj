<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<form:form modelAttribute="newPerson" class="form-horizontal" enctype="multipart/form-data">

    <fieldset>

        <legend>
            Dane Osoby
        </legend>
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>


        <div class="form-group">
            <label class="control-label col-lg-2" for="name">Imię</label>
            <div class="col-lg-10">
                <form:textarea id="name" path="name" rows="2"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="surname">
                nazwisko
            </label>
            <div class="col-lg-10">
                <form:input id="surname" path="surname" type="text"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="age">
                wiek
            </label>
            <div class="col-lg-10">
                <form:input id="age" path="age" type="text"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="description">
                opis
            </label>
            <div class="col-lg-10">
                <form:input id="description" path="description" type="text"/>
            </div>
        </div>

            <%--<div class="form-group">--%>
            <%--<label class="control-label col-lg-2 col-lg-2" for="competitionImage">--%>
            <%--<spring:message code="addCompetition.form.competitionImage.label"/>--%>
            <%--</label>--%>
            <%--<div class="col-lg-10">--%>
            <%--<form:input id="competitionImage" path="competitionImage" type="file"/>--%>
            <%--<form:errors path="competitionImage" cssClass="text-danger"/>--%>
            <%--</div>--%>
            <%--</div>--%>



    </fieldset>


    <fieldset>

        <legend>
            Login I haslo
        </legend>
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>


        <div class="form-group">
            <label class="control-label col-lg-2" for="username">Login</label>
            <div class="col-lg-10">
                <form:textarea id="username" path="username" rows="2"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="password">Hasło</label>
            <div class="col-lg-10">
                <form:textarea id="password" path="password" rows="2"/>
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
