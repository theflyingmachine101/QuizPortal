  <%@include file="reusables/header.jsp" %>
<%@page import="org.base.entities.QuizInfo"%>



<%QuizInfo reqQuiz=(QuizInfo)(request.getAttribute("reQuiz")); %>

<h1><%=reqQuiz.getQname() %></h1>

<form action="<%=request.getContextPath()%>/Admin?select=addquestion" method="post">
<input type="hidden" name="qid" value="<%=reqQuiz.getQid()%>"/>
<input type="hidden" name="aid" value="<%=reqQuiz.getAid()%>"/>
<input type="hidden" name="qname" value="<%=reqQuiz.getQname()%>"/>
Enter the question: <input name="question" type="text" />
<br/>
Enter the option 1: <input name="option1" type="text"/>
<br/>
Enter the option 2: <input name="option2" type="text" />
<br/>
Enter the option 3: <input name="option3" type="text"/>
<br/>
Enter the option 4: <input name="option4" type="text"/>
<br/>
<label for="answeroption">Choose your answer:</label>

<select id="answeroption" name="answer" >
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select>
<br/>
Enter maximum marks:<input name="mm" type="number" />
<br/>
Enter negative  marks:<input name="nm" type="number" />
<br/>
<button type="submit">Add Question</button>
</form>
<form action="<%=request.getContextPath()%>/Admin" method="get">
<input type="hidden" name="select" value="showquiz">
<button type="submit"> Done</button>
</form>
<%@include file="reusables/footer.jsp" %>