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
<input type="hidden" name="select" value="userlogin"/>
Your email:<input type="email" name="userEmail" required="required"/>
<br/>
Your password:<input type="password" name="userPassword" required="required"/>
<br/>
<button type="submit">Login</button>
</form>
</body>
</html>