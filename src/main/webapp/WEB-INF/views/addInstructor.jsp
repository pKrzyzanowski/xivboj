<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>

<html>
<head>
</head>
<body>

<form:form modelAttribute="newInstructor" class="form-horizontal" enctype="multipart/form-data">

    <fieldset>
        <legend>
            Dane Instructora
        </legend>

        <form:errors path="*" cssClass="alert alert-danger" element="div"/>

        <div class="form-group">
            <label class="control-label col-lg-2" for="name">Imiê</label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text"/>

            </div>
        </div>

<%--        <div class="form-group">--%>
<%--            <label class="control-label col-lg-2 col-lg-2" for="surname">--%>
<%--                Nazwisko--%>
<%--            </label>--%>
<%--            <div class="col-lg-10">--%>
<%--                <form:input id="surname" path="surname" type="text"/>--%>

<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label class="control-label col-lg-2 col-lg-2" for="age">--%>
<%--                Wiek--%>
<%--            </label>--%>
<%--            <div class="col-lg-10">--%>
<%--                <form:input id="age" path="age" type="text"/>--%>

<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label class="control-label col-lg-2 col-lg-2" for="description">--%>
<%--                Opis--%>
<%--            </label>--%>
<%--            <div class="col-lg-10">--%>
<%--                <form:input id="description" path="description" type="text"/>--%>

<%--            </div>--%>
<%--        </div>--%>


<%--        <div class="form-group">--%>
<%--            <label class="control-label col-lg-2 col-lg-2" for="personImage">--%>
<%--                Zdjêcie--%>
<%--            </label>--%>
<%--            <div class="col-lg-10">--%>
<%--                <form:input id="personImage" path="personImage" type="file"/>--%>
<%--            </div>--%>
<%--        </div>--%>


    </fieldset>


    <fieldset>

        <legend>
            Login I has³o
        </legend>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-lg-2" for="username">Login</label>--%>
<%--            <div class="col-lg-10">--%>
<%--                <form:input id="username" path="username" type="text"/>--%>
<%--            </div>--%>
<%--        </div>--%>


<%--        <div class="form-group">--%>
<%--            <label class="control-label col-lg-2 col-lg-2" for="password">--%>
<%--                Has³o--%>
<%--            </label>--%>
<%--            <div class="col-lg-10">--%>
<%--                <form:input id="password" path="password" type="password"/>--%>

<%--            </div>--%>
<%--        </div>--%>


        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" value=<spring:message code="addCompetition.addCompetition"/>>
            </div>
        </div>

    </fieldset>

</form:form>


</body>
</html>
