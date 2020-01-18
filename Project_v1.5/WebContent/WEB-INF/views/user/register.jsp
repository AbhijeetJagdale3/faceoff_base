<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>${requestScope.status}</h5>
	<spf:form method="post" modelAttribute="user" > 
		<table>
			<tr>
				<td>User Name</td>
				<td><spf:input path="username" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><spf:input path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><spf:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register">
			</tr>
		</table>
	</spf:form>
	<h5><a href="<sp:url value='/user/login'></sp:url>">Log In</a></h5>
</body>
</html>