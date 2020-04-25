<%@include file="reusables/header.jsp" %>
<%@ page import="java.util.List" %>
<%@page import="org.base.entities.QuizQuestion"%>
<%@page import="org.base.entities.QuizInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<% QuizInfo reqQuiz=(QuizInfo)request.getAttribute("reqQuiz");%>
<h1><%=reqQuiz.getQname() %></h1>

<%List<QuizQuestion> reqList=(List)request.getAttribute("quizDetail");
int i=0;
%> 
<form action="<%= request.getContextPath()%>/User?select=getresult" method="post"> 
<input type="hidden" name="qid" value="<%=reqQuiz.getQid()%>"/> 
<input type="hidden" name="qname" value="<%=reqQuiz.getQname()%>"/> 
<ol>
<c:forEach items="<%=reqList%>" var="quiz">
	<li>
	<h3>${quiz.getQuestion()}</h3>
	<h4>Maximum Marks: ${quiz.getMm()}</h4>
	<h4>Negative Marks: ${quiz.getNm()}</h4>
  <input type="radio" id="option1" name="<%=i%>" value="1">
  <label for="option1">${quiz.getOption1()}</label><br>
  <input type="radio" id="option2" name="<%=i%>" value="2">
  <label for="option2">${quiz.getOption2()}</label><br>
  <input type="radio" id="option3" name="<%=i%>" value="3">
  <label for="option3">${quiz.getOption3()}</label>	<br>
	<input type="radio" id="opion4" name="<%=i%>" value="4">
  <label for="option4">${quiz.getOption4()}</label>	<br>
	</li>
	<%i=i+1;%>
	</c:forEach>
</ol>
<button type="submit">Get Result</button>
</form>
<%@include file="reusables/footer.jsp"  %>