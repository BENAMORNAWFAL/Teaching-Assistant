<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<a href="/song/new">Add new</a>
	<a href="/song/top">Top Song</a>
	
	<form action="/search">
		<input for="search"/>
		<input type="submit" value="Search">
	</form>
	
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${songs}">
			<tr>
				<td><a href="/song/${song.id}"><c:out value="${song.title}"></c:out></a></td>
				<td><c:out value="${song.rating}"></c:out></td>
				<td>
				<form:form action="/song/${song.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete"/>
					<input type=submit value="delete" />
				
				</form:form>
			
		</c:forEach>
		</tbody>
	</table>
</body>
</html>