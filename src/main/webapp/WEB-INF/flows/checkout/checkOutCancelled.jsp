<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=" utf-8
    ">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Invalid cart </title>
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">check out cancelled</h1>
            <p>Your voting is cancaled</p>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/competitions" />" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span> Competitions
            </a>
        </p>
    </div>

</section>
</body>
</html>
