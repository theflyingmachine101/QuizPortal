<%@page import="org.base.entities.QuizInfo"%>
<%@include file="reusables/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<h1>Quizzes created by you are:</h1>
<%List<QuizInfo> reqList=(List)request.getAttribute("quiz");%> 
<c:forEach items="<%=reqList%>" var="quiz">
		<form action="<%=request.getContextPath()%>/User" method="get">
		<input type="hidden" value="${quiz.getQid()}" name="qid"/>
		<input type="hidden" value="${quiz.getAid()}" name="aid"/>
		<input type="hidden" value="${quiz.getQname()}" name="qname"/>
		<input type="hidden" value="takeQuiz" name="select"/>
		<p>${quiz.getQname()}</p>
		<button type="submit">Take this Quiz</button>
		<br/>
		------------
		</form>
	</c:forEach>
<%@include file="reusables/footer.jsp"  %>