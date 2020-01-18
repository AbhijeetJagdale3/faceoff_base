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
	<h4>Thanks for your visit ${requestScope.user.username}</h4>
	<h4>You are successfully Logged Out</h4>
	<h3>
		<a href="<sp:url value='/user/login'/>">Log in</a>
	</h3>
</body>
</html>