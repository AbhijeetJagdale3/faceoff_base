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

<h4 style="color: red;"></h4>
	<table>
		<tr>
			<td><a href="<sp:url value='/comp/invlist'/>">See All
					Invitation</a></td>
		</tr>
		<tr>
			<td><a href="<sp:url value='/user/alluser'/>">See All User</a></td>
		</tr>
	</table>
	
	
	
	
	
	
	
	
	<form  action="<sp:url value='/user/search'/>">
		<table>
			<tr>
				<td>Search user</td>
				<td><input type="text" name="searchstr" />
				<td><input type="submit" value="find" /></td>
			</tr>
		</table>
	</form>

	<%-- <h3>${requestScope.shayariList}</h3> --%>
	<table>
		<c:forEach var="s" items="${requestScope.shayariList}">
			<tr>
				<td>${s.sh}</td>
				<td><a href="<sp:url value='/shayari/remove?sid=${s.id}'/>">remove</a></td>
			</tr>

		</c:forEach>
	</table>
	<table>
		<c:forEach var="p" items="${requestScope.poemList}">
			<tr>
				<td>${p.myPoem}</td>
				<td><a href="<sp:url value='/poem/remove?pid=${p.id}'/>">remove</a></td>
			</tr>

		</c:forEach>
	</table>
	<table>
		<c:forEach var="i" items="${requestScope.invList}">
			<tr>
				<td>${i.username}</td>
				<td><a href="<sp:url value='/comp/remove?uid=${i.id}'/>">remove</a></td>
				<td><a href="<sp:url value='/comp/accept?uid=${i.id}'/>">Accept</a></td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<c:forEach var="i" items="${requestScope.userList}">
			<tr>
				<td>${i.username}</td>
				<td><a href="<sp:url value='/comp/inv?uid=${i.id}'/>">challenge</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<a href="<sp:url value='/user/logout'/>">Log Out</a>
	</h3>
</body>
</html>