<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<li><a href="<spring:url value="/competitions"/>">Konkurencje</a></li>
<li><a href="<spring:url value="/people"/> ">Uzytkownicy</a></li>
<li><a href="#">Wyniki glosowania</a></li>
<li><a href="#">Wyniki konkursu</a></li>
<li><a href="<spring:url value="/competitions/add"/> ">Dodaj konkurencje</a></li>
<li><a href="<c:url value="/j_spring_security_logout"/> ">wyloguj sie</a></li>