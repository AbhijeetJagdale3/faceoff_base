<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.button {
  background-color: #11C8E5;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
}
    #outer-div {
      width: 100%; 
      text-align: center;
      }
      
.button:hover {opacity: 1}
.mainDiv{
float:inline-block;
}

</style>
<body>
	<div id="outer-div">
	
	<button type="button" class="button" onclick="window.location.href = 'user/login';">Login</button>
	<button type="button" class="button" onclick="window.location.href = 'user/register';">Register</button>

</div>
</body>
</html>
