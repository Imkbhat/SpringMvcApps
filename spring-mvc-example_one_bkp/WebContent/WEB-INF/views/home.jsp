<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</p>

	<!-- <form action="user" method="post">
		<input type="text" name="userName"><br> <input
			type="submit" value="Login">
	</form> -->
	
	<table>
		<tr><td><a href="${pageContext.request.contextPath}/employee">Add Customer</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath}/listEmployee">List Employees</a></td></tr>
	</table>
	
</body>
</html>