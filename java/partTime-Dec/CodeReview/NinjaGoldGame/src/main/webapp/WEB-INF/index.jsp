<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Your Gold :<c:out value="${gold }"></c:out> </h2>
	<table>
		<tbody>
			<tr>
				<td>
					<h3>Farm</h3>
					<p>(earn 10-20 gold)</p>
					<form action="/" method="post">
						<input type="submit" name="farm" value="Find gold"/>
					</form>
				
				</td>
				<td>
					<h3>Cave</h3>
					<p>(earn 5-10 gold)</p>
					<form action="/" method="post">
						<input type="submit" name="cave" value="Find gold"/>
					</form>
				
				</td>
				<td>
					<h3>House</h3>
					<p>(earn 2-5 gold)</p>
					<form action="/" method="post">
						<input type="submit" name="house" value="Find gold"/>
					</form>
				
				</td>
				<td>
					<h3>Quest</h3>
					<p>(earn 0-50 gold)</p>
					<form action="/" method="post">
						<input type="submit" name="quest" value="Find gold"/>
					</form>
				
				</td>
			
			</tr>
		</tbody>
	
	</table>
	
	<h1>Activities :</h1>
	<iframe src="/activities" width=<%="50%" %>>
	
	</iframe>
</body>
</html>