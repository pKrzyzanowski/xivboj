<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<li><a href="<spring:url value="/competitions"/>"><spring:message code="navigation.competitions"/></a></li>
<li><a href="<spring:url value="/people"/> "><spring:message code="navigation.competitors"/></a></li>
<li><a href="#"><spring:message code="navigation.votingResults"/></a></li>
<li><a href="#"><spring:message code="navigation.competitionResults"/></a></li>
<li><a href="<spring:url value="/competitions/add"/> "><spring:message code="navigation.addCompetition"/></a></li>
<li><a href="<c:url value="/j_spring_security_logout"/> "><spring:message code="navigation.logIn"/></a></li>
</body>
</html>


