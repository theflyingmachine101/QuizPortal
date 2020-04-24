<%@include file="reusables/header.jsp" %>
<h1>What do you want to do</h1>
<form action="<%=request.getContextPath()%>/Admin" method="get">
<input type="hidden" name="select" value="createquiz"/>
<button type="submit">Create a Quiz</button>
</form>
<br/>
<form action="<%=request.getContextPath()%>/Admin" method="get">
<input type="hidden" name="select" value="showquiz"/>
<button type="submit">Show your Quizzes</button>
</form>
<%@include file="reusables/footer.jsp"  %>