<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>${requestScope.status}</h5>
	<spf:form method="post" modelAttribute="shayari" >
		<table>
			<tr>
				<td>Shayari</td>
				<td><spf:input path="sh" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</spf:form>
	<h3>
		<a href="<sp:url value='/user/profile'/>">Profile</a>
	</h3>
</body>
</html>