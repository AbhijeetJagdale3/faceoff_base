<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Poem</title>
</head>
<body>
<h5>${requestScope.status}</h5>
	<spf:form method="post" modelAttribute="poem">
		<table>
			<tr>
				<td>Poem Name</td>
				<td><spf:input path="pname" /></td>
			</tr>
			<tr>
				<td>poem</td>
				<td><spf:input path="myPoem" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit">
			</tr>
		</table>
	</spf:form>
	<h3>
		<a href="<sp:url value='/user/profile'/>">Profile</a>
	</h3>
</body>
</html>