<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>activities</title>
</head>
<body>
	<c:forEach var="one_activity" items="${activities}">
		
		
		<c:if test="${one_activity.contains('lost')}">
			<p style="color:red"><c:out value="${one_activity}"></c:out></p>
		</c:if>
		<c:if test="${one_activity.contains('earned')}">
			<p style="color:green"><c:out value="${one_activity}"></c:out></p>
		</c:if>
	
	</c:forEach>
</body>
</html>