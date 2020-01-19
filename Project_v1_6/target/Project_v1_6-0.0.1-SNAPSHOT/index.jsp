<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h5>${requestScope.status}</h5>
	<form method="post" action="user/login">
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
	
<h5><a href=user/register>Register New User</a></h5>
</body>
</html>
