<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<form:form modelAttribute="newCompetition" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <fieldset>
        <form:input id="competitionId" path="competitionId" type="text"/>
        <form:input id="name" path="name" type="text"/>
        <form:errors path="name" cssClass="text-danger" />
        <form:input id="competitionImage" path="competitionImage" type="file" class="form:input-large"/>
        <%--<form:input id="authorName" path="authorName" type="text"/>--%>
        <%--<form:input id="rules" path="rules" type="text"/>--%>



<input type="submit" value="Dodaj">

    </fieldset>
</form:form>
</body>
</html>
