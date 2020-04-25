<%@include file="reusables/header.jsp" %>
<h1>What do you want to do</h1>
<form action="<%=request.getContextPath()%>/User" method="get">
<input type="hidden" name="select" value="showallquiz"/>
<button type="submit">Take a quiz</button>
</form>
<%@include file="reusables/footer.jsp" %>