<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.TaskDetailBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<HashMap<String, String>> assignedTaskToWorkerObj = TaskDetailDao.assignedTaskToWorker(request.getParameter("loginId"));
	pageContext.setAttribute("assignedTaskToWorker", assignedTaskToWorkerObj);
	
	if(request.getParameter("taskDetailId") != null && request.getParameter("taskDetailId").length() > 0 
			&& request.getParameter("taskStatus") != null && request.getParameter("taskStatus").length() > 0
			&& request.getParameter("taskCompletionPercentage") != null && request.getParameter("taskCompletionPercentage").length() > 0){
		TaskDetailDao.updatePercentageOfTaskByWorker(request.getParameter("taskDetailId"), request.getParameter("taskCompletionPercentage"));
		TaskDetailDao.updateStatusOfTaskByWorker(request.getParameter("taskDetailId"), request.getParameter("taskStatus"));
		out.println("Information has been updated in the database !!!!");
		
	}
%>

<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"&loginId="+loginId+"&loginIdType="+loginIdType;
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
  </body>
</html>
