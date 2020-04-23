<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Portal</title>
</head>
<body>
<h1>Welcome to Quiz Portal</h1>
<h2>Admin Section:</h2>
<form action="<%=request.getContextPath()%>/Home" method="get">
<input type="hidden" name="select" value="alogin"/>
<button type="submit">Login</button>
</form>
<br/>
<form action="<%=request.getContextPath()%>/Home" method="get">
<input type="hidden" name="select" value="asignup"/>
<button type="submit">Signup</button>
</form>
<h2>User Section:</h2>
<form action="<%=request.getContextPath()%>/Home" method="get">
<input type="hidden" name="select" value="ulogin"/>
<button type="submit">Login</button>
</form>
<br/>
<form action="<%=request.getContextPath()%>/Home" method="get">
<input type="hidden" name="select" value="usignup"/>
<button type="submit">Signup</button>
</form>
<br/>
<%@include file="reusables/footer.jsp" %>