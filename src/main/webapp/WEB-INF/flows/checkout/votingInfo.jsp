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
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Shipping</h1>
            <p>Shipping details</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="order" class="form-horizontal">


        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <p>konkurencje na ktore zaglosowales to</p>

        <c:forEach items="${order.cart.allCartItems}" var="CartItemCompe">
            <p>*${CartItemCompe.competition.name}</p>
        </c:forEach>

        <p>czy jestes pewien ze chcesz na nei zaglosowac? Nie bedzie juz odwrotu</p>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button id="back" class="btn btn-default" name="_eventId_cancel">cancel</button>

                <input type="submit" id="btnAdd" class="btn btn-primary"
                       value="Add" name="_eventId_next"/>
                <button id="btnCancel" class="btn btn-default" name="_eventId_back">back</button>
            </div>
        </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
