<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="pl">
<head>

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link href="http://fonts.googleapis.com/css?family=Corben:bold" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Nobile" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
    <link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">




    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
    <div class="container" style="height: 100%">

        <div class="header">
            <ul class="nav nav-pills pull-right"><tiles:insertAttribute name="navigation"/></ul>
        </div>

        <div class="jumbotron">
            <h2><tiles:insertAttribute name="heading"/></h2>
            <p><tiles:insertAttribute name="tagline"/></p>
        </div>

        <div class="row"><tiles:insertAttribute name="content"/></div>


        <div class= "footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>

    </body>
</html>
