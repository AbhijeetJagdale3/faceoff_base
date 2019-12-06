<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${sessionScope.user}</h3>

	<table>
		<tr>
			<td><a href="<sp:url value='/shayari/add'/>">Add New Shayari</a></td>
			<td></td>
			<td><a href="<sp:url value='/shayari/show'/>">Show My
					Shayari</a></td>
		</tr>
		<tr>
			<td><a href="<sp:url value='/poem/add'/>">Add New Poem</a></td>
			<td></td>
			<td><a href="<sp:url value='/poem/show'/>">Show My poem</a></td>
		</tr>
	</table>
	<%-- <h3>${requestScope.shayariList}</h3> --%>
	<table>
	<c:forEach  var="s"  items="${requestScope.shayariList}">
			<tr>
				<td>${s.sh}</td>
				<td><a href="<sp:url value='/shayari/remove?sid=${s.id}'/>">remove</a></td>
			</tr>
		
	</c:forEach>
	</table>
	<table>
	<c:forEach var="p" items="${requestScope.poemList}">
			<tr>
				<td>${p.pm}</td>
				<td><a href="<sp:url value='/poem/remove?pid=${p.id}'/>">remove</a></td>
			</tr>
		
	</c:forEach>
	</table>
	<h3>
		<a href="<sp:url value='/user/logout'/>">Log Out</a>
	</h3>
</body>
</html>