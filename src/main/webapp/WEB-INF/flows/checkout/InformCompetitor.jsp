<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
            <h1>Thanks for voting</h1>
            <p>now, train to competition</p>
        </div>
    </div>
</section>
<div class="thumbnail" style="width:600px; height: auto; position: relative;text-align: center">
    <section class="container">
        <img src="<c:url value="/resource/images/goodLuck.jpg"></c:url>  " alt="image" style="width: 300px"/>
        <p><a href="<spring:url value="/competitions" />" class="btn btn-primary">
            <span class="glyphicon-hand-left glyphicon"></span> Competitions
        </a>
        </p>
    </section>
</div>
</body>


</html>
