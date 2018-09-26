<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="ISO-8859-2, windows-1250, UTF8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<body>
<div class="container" style="position: relative;text-align: center">
    <img src="<c:url value="/resource/images/siteStatic/welcomePic.png"></c:url>  " alt="image"/>
    <br><br><br>
    <h1>O konkursie</h1>
    <br><br>
    <p>Czternastobój klasyczny sięga swoimi korzeniami do 2017 roku.</p>
    <p>Jest to kombinacja czternastu konkurencji wybranychprzez uczestników.</p>
    <p>Ideą konkursu jest zakończenie sporów o to, kto jest ogólnie najlepszy.</p>
    <p>Oprócz samych rozgrywek jest faza głosowania na konkurencje.</p>
    <p>Jest to nieodłącznyi i nie mniej ważny niż reszta etap konkursu.</p>
    <p>Niniejsza strona ma usprawnić proces głosowania i uczynić go bardzień oficjalnym.</p>
</div>
<br><br>

</body>
</html>
