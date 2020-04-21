<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Portal</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/User" method="post">
<input type="hidden" name="page" value="userSignup"/>
Your email:<input type="email" name="userEmail"/>
<br/>
Your password:<input type="password" name="userPassword"/>
<br/>
<button type="submit">Login</button>
<br/>
</form>
</body>
</html>