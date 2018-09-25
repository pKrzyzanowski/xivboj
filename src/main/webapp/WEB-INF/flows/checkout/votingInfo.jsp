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
            <h1>Twoje głosy</h1>
            <p>Zagłosowane konkurencje</p>
        </div>
    </div>
</section>
<section class="thumbnail" style="width: 600px">
    <section class="row">
        <form:form modelAttribute="order" class="form-horizontal">


        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <p>konkurencje na ktore zaglosowales to</p>

        <c:forEach items="${order.cart.allCartCompe}" var="CartCompe">

            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail" style="width: 170px; height: 160px">
                    <div class="panel-heading"><strong>${CartCompe.name}</strong></div>
                    <img src="<c:url value="/resource/images/competitions/${CartCompe.competitionId}.jpg"></c:url>  "
                         alt="image"
                         style="width: 100px; max-height: 80px;  padding-top: 15px"/>

                </div>
            </div>
        </c:forEach>
    </section>

    <p>czy jestes pewien ze chcesz na nei zaglosowac? Nie bedzie juz odwrotu</p>
    <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
            <input type="submit" id="btnAdd" class="btn btn-primary" value="Dalej" name="_eventId_next"/>
            <button id="btnCancel" class="btn btn-default" name="_eventId_back">Powrót</button>
        </div>
    </div>

    </fieldset>
    </form:form>
</section>
</body>
</html>
