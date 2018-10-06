<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<html>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customer</title>
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
</head>
<body>


<div class="jumbotron">
    <div class="container text-center">
        <h1>Regulamin</h1>
        <p>o¶wiadczenie o zgodzie</p>
    </div>
</div>

<div class="col-md-4 col-md-offset-4">

    <section class="container">
        <form:form modelAttribute="order">
            <fieldset>
                <legend>Regulamin</legend>

                <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
                <p>zgodznie z zasada honoru, oraz uscisku dloni zgadam sie na ponizsze zasady konkurencji</p>
                <c:forEach items="${order.cart.allCartCompetition}" var="CartCompe">
                    <p><strong>${CartCompe.name}: </strong>${CartCompe.rules}</p>
                </c:forEach>


                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                               value="Akceptujê" name="_eventId_regulationsAccepted"/>
                        <button id="btnCancel" class="btn btn-default" name="_eventId_backToAcceptRegulations">Powrót
                        </button>
                    </div>
                </div>

            </fieldset>
        </form:form>
    </section>
</div>








</body>
</html>
