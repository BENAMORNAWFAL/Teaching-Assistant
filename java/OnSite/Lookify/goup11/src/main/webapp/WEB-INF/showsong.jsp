<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Info</title>
</head>
<body>
	<table>
    <thead>
    	<tr>
            <td class="float-left">Title:</td>
            <td class="float-left"><c:out value="${song.title}"></c:out></td>
        </tr>
        <tr>
            <td class="float-left">Artist:</td>
            <td class="float-left"><c:out value="${song.artiste}"></c:out></td>
        </tr>
        <tr>
            <td class="float-left">Rating (1-10):</td>
            <td class="float-left"><c:out value="${song.rating}"></c:out></td>
        </tr>
    </thead>
</table>
<br>
<a href="/dashboard">Dashboard</a>
<%-- <a href="/song/${song.id}/delete">Delete</a> --%>
</body>
</html>