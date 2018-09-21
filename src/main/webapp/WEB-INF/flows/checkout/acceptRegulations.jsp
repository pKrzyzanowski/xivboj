<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=" utf-8
    ">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customer</title>
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
</head>
<body>


<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Regulamin</h1>
            <p>oświadczenie o zgodzie</p>
        </div>
    </div>
</section>
<div class="thumbnail" style="width: 600px">
    <section class="container">
        <form:form modelAttribute="order">
            <fieldset>
                <legend>Regulamin</legend>

                <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
                <p>zgodznie z zasada honoru, oraz uscisku dloni zgadam sie na ponizsze zasady konkurencji</p>
                <c:forEach items="${order.cart.allCartCompe}" var="CartCompe">
                    <%--tutaj bedzie kafelek identyczny jak ten ktory jest w zakladce competitions tyle ze bez przycisku glosow i szczegoly--%>
                    <p><strong>${CartCompe.name}: </strong>${CartCompe.rules}</p>
                </c:forEach>


                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                               value="Akceptuję" name="_eventId_regulationsAccepted"/>
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
