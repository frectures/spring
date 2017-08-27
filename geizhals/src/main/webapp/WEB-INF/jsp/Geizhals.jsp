<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Geizhals</title>
</head>
<body>

<h2>Price Infos</h2>
<table style="border:2px solid black; border-spacing:20px">
	<tr>
		<th></th>
		<c:forEach items="${allDiscounters}" var="discounter">
			<th><c:out value="${discounter}" /></th>
		</c:forEach>
	</tr>
	<c:forEach items="${allProducts}" var="product">
		<tr>
			<td><c:out value="${product}" /></td>
			<c:forEach items="${allDiscounters}" var="discounter">
				<td>?</td>
			</c:forEach>
		</tr>
	</c:forEach>
</table>

</body>
</html>
