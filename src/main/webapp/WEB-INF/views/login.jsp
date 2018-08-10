<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

</head>
<body>

<c:if test="${not empty error}">
    zle credincials
</c:if>

<form action="<c:url value="/j_spring_security_check"></c:url> " method="post">
    <fieldset>
        <input class="form-control" placeholder="nazwa uzytkownika" name="j_username" type="text">
        <input class="form-control" placeholder="haslo" name="j_password" type="password" value="">
        <input class="btn btn-success"   type="submit" value="zaloguj sie">
    </fieldset>
</form>


</body>
</html>
