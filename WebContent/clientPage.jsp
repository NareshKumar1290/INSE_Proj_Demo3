<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.TaskDetailBean"%>
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<script language="JavaScript">
	
	<%
	
		if(request.getParameter("taskId") != null && request.getParameter("taskStatus") != null){
			
			boolean taskStatus = TaskDetailDao.updateTaskStatus(request.getParameter("taskId"), request.getParameter("taskStatus"));
			if(taskStatus)
				pageContext.setAttribute("taskStatus", taskStatus);
			
			boolean workerTaskSaveDetails = TaskDetailDao.insertIntoWorkerTaskDetails(request.getParameter("taskId"), request.getParameter("taskStatus"), request.getParameter("workerId"));
			if(workerTaskSaveDetails)
				pageContext.setAttribute("workerTaskSaveDetails", workerTaskSaveDetails);
		}
	
		if(request.getParameter("taskRating") != null && request.getParameter("taskRating").length() > 0
				&& request.getParameter("taskFeedBack") != null && request.getParameter("taskFeedBack").length() > 0
					&& request.getParameter("transactionAmount") != null && request.getParameter("transactionAmount").length() > 0){
			
			boolean saveTaskRatingAndFeedBack = TaskDetailDao.updateClientStatusAndFeedbackOfTaskByClient(request.getParameter("taskId"), request.getParameter("taskRating"), request.getParameter("taskFeedBack"));
			
			boolean transactionOfAmount = TaskDetailDao.transactionByClient(request.getParameter("taskId"), request.getParameter("transactionAmount"));
		}
	
	%>

	function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId") != null && request.getParameter("loginId").length() > 0 ? request.getParameter("loginId") : request.getParameter("clientId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType;
    }
</script>

<form>
	<c:if test="${not empty taskStatus}">
    	Information has been saved into the database !!!!
	</c:if>
	
	<h1>Welcome to Client Page !!!!!</h1>
	
	<Input type="button" name = "Add Tasks" value="Add Tasks" onClick="openPage('TaskDetail.jsp');">
	<Input type="button" name = "View Tasks" value="View Tasks" onClick="openPage('viewTaskDetail.jsp');">
	<Input type="button" name = "Client Rating & FeedBack" value="Client Rating & FeedBack" onClick="openPage('feedBackAndTransaction.jsp');">
	<Input type="button" name = "Logout" value="Logout" onClick="openPage('index.jsp');">
</form>
