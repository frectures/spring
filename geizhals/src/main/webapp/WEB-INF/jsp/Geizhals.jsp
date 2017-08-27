<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Geizhals</title>
</head>
<body>

<h2>Hello to my
	<c:if test="${isFormal}">acquaintances</c:if>
	<c:if test="${not isFormal}">buddies</c:if>
</h2>
<ul>
	<c:forEach items="${greetees}" var="greetee">
		<li><c:out value="${greetee}" /></li>
	</c:forEach>
</ul>

</body>
</html>
