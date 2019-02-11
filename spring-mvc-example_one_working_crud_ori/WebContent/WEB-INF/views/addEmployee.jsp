<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add an Employee</title>
</head>
<body>
	<form:form action="saveEmployee" modelAttribute="employee" method="POST">
	<form:hidden path="empId"/>
		<table>
			<tr>
				<td>First Name:</td> 
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="Submit"></td>			
			</tr>		
		</table>
	</form:form>
</body>
</html>