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
		}
	
	%>

	function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
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
</form>
