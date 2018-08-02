<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right"><tiles:insertAttribute name="navigation"/></ul>
    </div>

    <div class="jumbotron">

        <h2><tiles:insertAttribute name="heading"/></h2>
        <p><tiles:insertAttribute name="tagline"/></p>
    </div>
    <tiles:insertAttribute name="content"/>

    <div class= "footer">
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>
