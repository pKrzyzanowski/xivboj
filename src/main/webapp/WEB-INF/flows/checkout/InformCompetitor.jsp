<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>

<html>
<head>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Invalid cart </title>
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
</head>
<body>

<div class="jumbotron">
    <div class="container text-center">
        <h1>Dziêki za g³osy</h1>
        <p>Trenuj do konkursu!</p>
    </div>
</div>

<div class="container" style="position: relative;text-align: center">
    <div class="col-md-4 col-md-offset-4">
        <section class="container">
            <img src="<c:url value="/resource/images/siteStatic/goodLuck.jpg"></c:url>  " alt="image"
                 style="width: 300px"/>
            <p><a href="<spring:url value="/competitions" />" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span> Konkurencje
            </a>
            </p>
        </section>
    </div>
</div>
</body>


</html>
