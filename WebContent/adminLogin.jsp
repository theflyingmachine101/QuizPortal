<%@include file="reusables/header.jsp" %>
<form action="<%=request.getContextPath()%>/Admin" method="post">
<input type="hidden" name="select" value="adminlogin"/>
Your email:<input type="email" name="adminEmail" required="required"/>
<br/>
Your password:<input type="password" name="adminPassword" required="required"/>
<br/>
<button type="submit">Login</button>
</form>
<%@include file="reusables/footer.jsp" %>