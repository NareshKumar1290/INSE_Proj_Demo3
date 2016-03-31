<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.TaskDetailBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<TaskDetailBean> taskDetailDaoObj = TaskDetailDao.fetchClientTaskRecords(request.getParameter("loginId"), "Completed");
	pageContext.setAttribute("taskDetailDao", taskDetailDaoObj);
%>

<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
    	var taskId = <%=request.getParameter("taskId")%>;
    	var taskRating = document.getElementById("taskRating").value;
    	var taskFeedBack = document.getElementById("taskFeedBack").value;
    	var transactionAmount = document.getElementById("transactionAmount").value;
    	
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType+"&taskId="+taskId+"&taskRating="+taskRating+"&taskFeedBack="+taskFeedBack+"&transactionAmount="+transactionAmount;
    }
</script>

<html>
  <head>
    <title>Welcome to Client's Page</title>
  </head>
  <body bgcolor="white">
    Here are all tasks Given By You:
    <table>
    <tr>
    	<th headers="taskName">Task Name</th>
     	<th headers="domainOfWork">Domain Of Work</th>
      	<th headers="taskDescription">Task Description</th>
      	<th headers="workerRequired">Worker Required</th>
      	<th headers="budget">Budget</th>
      	<th headers="taskStatus">Status</th>
      	<th hidden="hidden" headers="taskId">Task Id</th>
    </tr>
      <c:forEach items="${taskDetailDao}" var="taskDetailDao">
        <tr>
          <td headers="taskName"><c:out value="${taskDetailDao.taskName}" /><td>	
          <td headers="domainOfWork"><c:out value="${taskDetailDao.domain}" /><td>
          <td headers="taskDescription"><c:out value="${taskDetailDao.taskDescription}" /><td>	
          <td headers="workerRequired"><c:out value="${taskDetailDao.numberOfWorkerRequired}" /><td>
          <td headers="budget"><c:out value="${taskDetailDao.budgetPerWorker}" /><td>	
          <td headers="taskStatus"><c:out value="${taskDetailDao.taskStatusString}" /><td>
          <td headers="taskId" hidden="hidden"><c:out value="${taskDetailDao.taskId}" /><td>
        </tr>
      </c:forEach>
    </table>
    
    
    <br/>
    <br/>
    
    Client Rating (out of 5) : <input type="text" id="taskRating" name="taskRating" /><br/><br/>
    
    <br/>
    <br/>
    
    Client FeedBack : <input type="text" id="taskFeedBack" name="taskFeedBack" /><br/><br/>
    
    <br/>
    <br/>
    
    Transaction Amount : <input type="text" id="transactionAmount" name="transactionAmount" /><br/><br/>
    
    <br/>
    <br/>
    
    <input type="submit" value="Submit Rating and FeedBack" onclick="openPage('clientPage.jsp')"/>
  </body>
</html>
