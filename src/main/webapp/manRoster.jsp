<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Roster</title>
</head>
<body>
<form method="post" action="managerNavigationServlet">
		<table>
			<c:forEach items="${requestScope.manRoster}" var="currentEntry">
				<tr>
					<td><input type="radio" name="manNo" value="${currentEntry.manNo}"></td>
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