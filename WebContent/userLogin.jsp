<%@include file="reusables/header.jsp" %>
<form action="<%=request.getContextPath()%>/User" method="post">
<input type="hidden" name="select" value="userlogin"/>
Your email:<input type="email" name="userEmail" required="required"/>
<br/>
Your password:<input type="password" name="userPassword" required="required"/>
<br/>
<button type="submit">Login</button>
</form>
<%@include file="reusables/footer.jsp" %>