<%@include file="reusables/header.jsp" %>
<form action="<%=request.getContextPath()%>/User" method="post">
<input type="hidden" name="select" value="usersignup"/>
<input type="hidden" name="check" value="no"/>
Your name:<input type="text" name="userName" required="required"/>
<br/>
Your email:<input type="email" name="userEmail" required="required"/>
<br/>
Your password:<input type="password" name="userPassword" required="required"/>
<br/>
<button type="submit">Sign Up</button>
</form>
<%@include file="reusables/footer.jsp" %>