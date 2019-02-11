<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	 <spring:url value="/resources/css/bootstrap.min.css" var="loginCSS" />
	<spring:url value="/resources/js/jquery.min.js" var="loginJS" />
	<spring:url value="/resources/js/bootstrap.min.js" var="loginBootJS" />
	<link href="${loginCSS}" rel="stylesheet" />
	<script src="${loginJS}"></script>
	<script src="${loginBootJS}"></script>


<title>Add an Employee</title>
</head>
<body>
	<form:form action="saveEmployee" modelAttribute="employee" method="POST">
	<form:hidden path="empId"/>
		<div class="form-group">
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
					<td>Role:</td>
					<td><form:select path="role">
						<form:options items="${roleOptions}" itemValue="role" itemLabel="role"/>
					</form:select></td>
					<td><form:errors path="role" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" name="Submit"></td>			
				</tr>
					
			</table>
		</div>
	</form:form>
	<table>
		<tr><td><a href="${pageContext.request.contextPath}/employee/employee">Home Page</a></td></tr>
		</table>
</body>
</html>