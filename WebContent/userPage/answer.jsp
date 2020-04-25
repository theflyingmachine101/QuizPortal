<%@include file="reusables/header.jsp" %>
<%@ page import="java.util.List" %>
<%@page import="org.base.entities.QuizQuestion"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<h1><%=request.getAttribute("qname")%></h1>

<ol>
<%List<QuizQuestion> reqList=(List)request.getAttribute("quizDetail");%> 
<c:forEach items="<%=reqList%>" var="quiz">
	<li>
		<h3>${quiz.getQuestion()}</h3>
		 <p>a) ${quiz.getOption1()}</p>
		 <p>b) ${quiz.getOption2()}</p>
		 <p>c) ${quiz.getOption3()}</p>
		 <p>d) ${quiz.getOption4()}</p>
		 <p>Correct Option: ${quiz.getAnswer()}</p>
		 <p>Maximum Marks: ${quiz.getMm()}</p>
		 <p>Negative Marks: ${quiz.getNm()}</p>
	</li>
	</c:forEach>
</ol>



<h4>You attempted <%=request.getAttribute("attempted")%> out of <%=request.getAttribute("totalquestion") %> question</h4>
<h4>Your scored <%=request.getAttribute("score")%>  out of <%=request.getAttribute("totalScore")%></h4>
<h3>Your accuracy is  <strong><%=request.getAttribute("accuracy")%> %</strong></h3>
<%@include file="reusables/footer.jsp" %>