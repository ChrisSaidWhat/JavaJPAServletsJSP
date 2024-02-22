<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Manager</title>
</head>
<body>
	<form action="editManServlet" method="post">
		<h1>Make Edits To Entry: </h1>
		<label for="firstName">First Name: </label>
		<input type="text" id="firstName" name="firstName" value="${manToEdit.firstName}">
		
		<label for="lastName">Last Name: </label>
		<input type="text" id="lastName" name="lastName" value="${manToEdit.lastName}">
		
		<input type="hidden" name="manNo" value="${manToEdit.manNo}">
		<input type="submit" value="Save Changes">
	</form>
</body>
</html>