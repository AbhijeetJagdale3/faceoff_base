<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>${requestScope.status}</h5>
	<form method="post" action="<sp:url value='/user/login'/>">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" />
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password" />
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>

		</table>

	</form>
	
<h5><a href="<sp:url value='/user/register'></sp:url>">Register New User</a></h5>
</body>
</html>