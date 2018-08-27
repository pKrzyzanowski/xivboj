<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>

<img src="<c:url value="/resource/images/${person.nameId}.jpg"></c:url> " alt="image" style="width: 300px"/>

<h3>${person.name}</h3>
<p>${person.surname}</p>
<p>${person.description}</p>
<p>${person.age}</p>

</body>
</html>
