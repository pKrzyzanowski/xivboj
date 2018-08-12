<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<form:form modelAttribute="newCompetition">
    <fieldset>
        <form:input id="competitionId" path="competitionId" type="text"/>
        <form:input id="name" path="name" type="text"/>
        <%--<form:input id="authorName" path="authorName" type="text"/>--%>
        <%--<form:input id="rules" path="rules" type="text"/>--%>



<input type="submit" value="Dodaj">

    </fieldset>
</form:form>
</body>
</html>
