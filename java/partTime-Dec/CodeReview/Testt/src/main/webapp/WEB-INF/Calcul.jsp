<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Calculator Result</h2>
	
	<c:choose>
		<c:when test="${operation eq 'add'}">
			<p>This is an addition operation ===> ${a} + ${b} = ${result}</p>
		</c:when>
		<c:when test="${operation eq 'subtract'}">
			<p>This is a subtraction operation ===> ${a} - ${b} = ${result}</p>
		</c:when>
		<c:when test="${operation eq 'multiply'}">
			<p>This is a multiplication operation ===> ${a} * ${b} =
				${result}</p>
		</c:when>
		<c:when test="${operation eq 'divide'}">
			<p>This is a division operation ===> ${a} / ${b} = ${result}</p>
		</c:when>
		<c:otherwise>
			<p>Unknown operation.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>