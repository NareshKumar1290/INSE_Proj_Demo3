<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.TaskDetailBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<HashMap<String, String>> assignedTaskToWorkerObj = TaskDetailDao.assignedTaskToWorker(request.getParameter("loginId"), request.getParameter("taskDetailId"));
	pageContext.setAttribute("assignedTaskToWorker", assignedTaskToWorkerObj);
%>

<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
    	var taskDetailId = <%=request.getParameter("taskDetailId")%>;
    	var taskStatus = document.getElementById("taskStatus").value;
    	var taskCompletionPercentage = document.getElementById("taskCompletionPercentage").value;
   		
    	window.location.href = pageURL+"&loginId="+loginId+"&loginIdType="+loginIdType+"&taskDetailId="+taskDetailId+"&taskStatus="+taskStatus+"&taskCompletionPercentage="+taskCompletionPercentage;
    }
</script>

<html>
  <head>
    <title>Welcome to Worker Assigned Task's Page</title>
  </head>
  <body bgcolor="white">
    Here are all the task assigned to you !!!!
    <table>
    <tr>
    	<th headers="taskDetailId">Task Id</th>
     	<th headers="taskName">Task Name</th>
      	<th headers="domainOfWork">Domain Of Work</th>
      	<th headers="specificTask">Task Description</th>
      	<th headers="Budget">Budget</th>
      	<th headers="status">Status</th>
      	<th headers="completionPercentage">Completion Percentage</th>
    </tr>
      <c:forEach items="${assignedTaskToWorker}" var="assignedTaskToWorker">
        <tr>
          <td onClick="openPage('updateTaskStatusAndCompletionPercentage.jsp?taskDetailId=<c:out value="${assignedTaskToWorker.taskDetailId}" />');" headers="taskDetailId"><c:out value="${assignedTaskToWorker.taskDetailId}" /><td>	
          <td headers="taskName"><c:out value="${assignedTaskToWorker.taskName}" /><td>
          <td headers="domainOfWork"><c:out value="${assignedTaskToWorker.domainOfWork}" /><td>
          <td headers="specificTask"><c:out value="${assignedTaskToWorker.specificTask}" /><td>	
          <td headers="Budget"><c:out value="${assignedTaskToWorker.Budget}" /><td>
          <td headers="status"><c:out value="${assignedTaskToWorker.status}" /><td>	
          <td headers="completionPercentage"><c:out value="${assignedTaskToWorker.completionPercentage}" /><td>
        </tr>
      </c:forEach>
    </table>
    
    <br/>
    <br/>
    
    Task Status : <input type="text" id="taskStatus" name="taskStatus" /><br/><br/>
    
    <br/>
    <br/>
    
    Task Completion Percentage: <input type="text" id="taskCompletionPercentage" name="taskCompletionPercentage" /><br/><br/>
    
    <br /><br />
    <Input type="button" name = "Worker Page" value="Back" onClick="openPage('workerPage.jsp?1=1');">
	<Input type="button" name = "Logout" value="Logout" onClick="openPage('index.jsp?1=1');">
    <input type="submit" value="Change Status" onclick="openPage('ViewWorkersTaskList.jsp?1=1')"/>
  </body>
</html>
