<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="pl">
<head>

    <meta charset="UTF-8"/>
    <%--<meta name="viewport" content="width=device-width,initial scale=1.0"/>--%>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link href="https://fonts.googleapis.com/css?family=Baloo+Tammudu|Lemon|Short+Stack" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lemon|Short+Stack" rel="stylesheet">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
    <link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">




    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div class="jumbotron">
    <div class="container text-center">
        <h1>Czternastobój Klasyczny</h1>
        <p>odkryj swoje granice</p>
    </div>
</div>


<tiles:insertAttribute name="navigation"/>

    <div class="container"  >
        <div class="row"><tiles:insertAttribute name="content"/></div>




        <footer class="container-fluid text-center">
            <tiles:insertAttribute name="footer"/>
        </footer>
    </div>

    </body>
</html>
