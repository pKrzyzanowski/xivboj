<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="login.title.login"/></h3>
                </div>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <spring:message code="login.badCredintials"/><br/>
                    </div>
                </c:if>

                <form action="<c:url value="/j_spring_security_check"></c:url> " method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder=
                            <spring:message code="login.placeHolder.userName"/> name="j_username" type="text">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder=
                            <spring:message code="login.placeHolder.password"/> name="j_password" type="password"
                                   value="">
                        </div>
                        <input class="btn btn-lg btn-success btn-block" type="submit" value=<spring:message code="login.button.login"/>>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
