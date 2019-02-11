<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employees</title>
</head>
	<body>
		<form>
			<h1>List of Employees</h1>
			<table border="1px"  width="100%" style="text-align: center">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Update | Delete</th>
				</tr>
				<c:forEach var="employee" items="${empList}">
					<c:url var="updateLink" value="/edit">
						<c:param name="empId" value="${employee.empId}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/delete">
						<c:param name="empId" value="${employee.empId}"/>
					</c:url>
				
					<tr>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this Employee?'))) return false;">Delete</a>
					</tr>
				</c:forEach>		
			</table>
		</form>
		<table>
		<tr><td><a href="${pageContext.request.contextPath}/employee">Add Employee</a></td></tr>
		</table>
	</body>
</html>