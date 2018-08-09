<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<li><a href="<spring:url value="/competitions"/>">konkurencje</a></li>
<li><a href="<spring:url value="/people"/> ">uzytkownicy</a></li>
<li><a href="#">wyniki glosowania</a></li>
<li><a href="#">wyniki konkursu</a></li>
<li><a href="<spring:url value="/competitions/add"/> ">Dodaj konkurencje</a></li>
<li><a href="<c:url value="/j_spring_security_logout"/> ">wyloguj sie</a></li>