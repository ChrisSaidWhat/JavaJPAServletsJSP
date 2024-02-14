<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Roster</title>
</head>
<body>
<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.empRoster}" var="currentEntry">
				<tr>
					<td><input type="radio" name="empNo" value="${currentEntry.empNo}"></td>
					<td>${currentEntry.firstName}</td>
					<td>${currentEntry.lastName}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem">
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>