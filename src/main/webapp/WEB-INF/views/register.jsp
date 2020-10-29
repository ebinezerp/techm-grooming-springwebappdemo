<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<spring:form action="register" method="POST" modelAttribute="customer">
		<spring:input path="fullname" />
		<spring:input path="email" />
		<spring:input path="password" />
		<spring:input type="hidden" path="role" value="CUSTOMER" />
		<spring:input type="hidden" path="status" value="true" />
		<spring:button type="submit">Register</spring:button>
	</spring:form>
</body>
</html>