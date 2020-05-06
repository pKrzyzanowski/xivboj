<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>

<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>
<html lang="pl">
<head>

    <%--<meta charset="ISO-8859-2, windows-1250, UTF8"/>--%>
    <%--<meta name="viewport" content="width=device-width,initial scale=1.0"/>--%>
    <%--<meta http-equiv="Content-Type" content="text/html;charset=utf-8">--%>
    <link href="https://fonts.googleapis.com/css?family=Baloo+Tammudu|Lemon|Short+Stack" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lemon|Short+Stack" rel="stylesheet">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/css/myCss.css">
    <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
    <link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
        <script src="/resource/js/controllers.js"></script>

    <title><tiles:insertAttribute name="title"/></title>
    <style>
        /* Remove the navbar's default rounded borders and increase the bottom margin */
        .navbar {
            margin-bottom: 50px;
            border-radius: 0;
        }

        /* Remove the jumbotron's default bottom margin */
        .jumbotron {
            margin-bottom: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #ffffff;
            padding: 15px;
        }



    </style>
</head>
<body  data-ng-app="scheduleApp">
<div class="jumbotron">
    <div class="container text-center">
        <h1>Czternastobój Klasyczny</h1>
        <p>odkryj swoje granice</p>
    </div>
</div>
<tiles:insertAttribute name="navigation"/>
<div class="container">
    <div class="row"><tiles:insertAttribute name="content"/></div>
    <footer class="container-fluid text-center">
        <tiles:insertAttribute name="footer"/>
    </footer>
</div>

</body>
</html>
