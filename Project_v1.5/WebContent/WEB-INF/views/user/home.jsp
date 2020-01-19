<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<a href="<sp:url value='/user/profile'/>">Profile</a>
	</h3>
	<h3>Home Page Under construction</h3>
<table>
		<tr>
			<td><a href="<sp:url value='/shayari/add'/>">Add New Shayari</a></td>
		</tr>
		<tr>
			<td><a href="<sp:url value='/poem/add'/>">Add New Poem</a></td>
		</tr>
		<tr></tr>
		</table>
	<h3>
		<a href="<sp:url value='/user/logout'/>">Log Out</a>
	</h3>
</body>
</html>