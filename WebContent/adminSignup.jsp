<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Portal</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Admin" method="post">
<input type="hidden" name="select" value="adminsignup"/>
Your name:<input type="text" name="adminName" required="required" />
<br/>
Your email:<input type="email" name="adminEmail" required="required"/>
<br/>
Your password:<input type="password" name="adminPassword" required="required"/>
<br/>
<button type="submit">Sign Up</button>
</form>
</body>
</html>