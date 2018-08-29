<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>

</head>
<body>

<c:if test="${not empty error}">
    <spring:message code="login.badCredintials"/>
</c:if>

<form action="<c:url value="/j_spring_security_check"></c:url> " method="post">
    <fieldset>
        <input class="form-control" placeholder=<spring:message code="login.placeHolder.userName"/> name="j_username" type="text">
        <input class="form-control" placeholder=<spring:message code="login.placeHolder.password"/> name="j_password" type="password" value="">
        <input class="btn btn-success"   type="submit" value=<spring:message code="login.button.login"/>>
    </fieldset>
</form>


</body>
</html>
