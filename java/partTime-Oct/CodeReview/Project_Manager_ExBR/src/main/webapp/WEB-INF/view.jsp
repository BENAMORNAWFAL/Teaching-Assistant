<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h2><a href="/dashboard">Dashboard</a></h2>

<h1>Project Details</h1>
<table>
    <tbody>
    	<tr>
            <td>Project: <c:out value="${project.title}"></c:out></td>
        </tr>
        
        <tr>
            <td>Description: <c:out value="${project.description}"></c:out></td>
        </tr>
        
        <tr>
            <td>Due Date: <fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
        </tr>
    </tbody>
</table>

<c:if test = "${project.lead.id==userId}">
    <h2><a href="/projects/delete/${project.id}">Delete Project</a></h2>
</c:if>
</body>
</html>

