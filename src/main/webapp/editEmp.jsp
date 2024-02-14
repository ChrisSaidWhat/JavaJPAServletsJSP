<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
	<form action="editEmpServlet" method="post">
		<h1>Make Edits To Entry: </h1>
		<label for="firstName">First Name: </label>
		<input type="text" id="firstName" name="firstName" value="${empToEdit.firstName}">
		
		<label for="lastName">Last Name: </label>
		<input type="text" id="lastName" name="lastName" value="${empToEdit.lastName}">
		
		<input type="hidden" name="empNo" value="${empToEdit.empNo}">
		<input type="submit" value="Save Changes">
	</form>
</body>
</html>