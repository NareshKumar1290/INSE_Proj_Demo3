<%@page import="bean.SearchForWorker"%>
<%@page import="bean.TaskDetailBean"%>
<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.TaskDetailBean"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	ArrayList<HashMap<String, String>> arrayListMapOfTaskAndWorker2 = SearchForWorker.getWorkerDetailList(request.getParameter("taskId"));
	pageContext.setAttribute("arrayListMapOfTaskAndWorker", arrayListMapOfTaskAndWorker2);
	
	ArrayList<TaskDetailBean> taskDetailDaoObj = TaskDetailDao.fetchClientTaskRecords(request.getParameter("loginId"));
	pageContext.setAttribute("taskDetailDao", taskDetailDaoObj);
%>

<script language="JavaScript">
	
	function openPage(pageURL)
    {	
    	debugger;
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
    	var taskId = <%=request.getParameter("taskId")%>;
    	var taskStatus = document.getElementById("taskStatus").value;
   		
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType+"&taskStatus="+taskStatus+"&taskId="+taskId;
    }
</script>

<html>
  <head>
    <title>Welcome to List of Worker's List</title>
  </head>
  <body bgcolor="white">
  	 Here are the Task Details
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
          <td headers="domainOfWork"><c:out value="${taskDetailDao.clientId}" /><td>
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
    <br/>
    Welcome to List of Worker's List
    <table>
    <tr>
    	<th headers="workerName">Worker Name</th>
     	<th headers="domainOfWork">Domain Of Work</th>
      	<th headers="specificTask">Task Description</th>
      	<th headers="credibility">Credibility</th>
      	<th headers="yearsOfExperience">Years of Experience</th>
      	<th headers="chargedFee">Charged Fee</th>
      	<th hidden="hidden" headers="loginId">Login Id</th>
    </tr>
      <c:forEach items="${arrayListMapOfTaskAndWorker}" var="arrayListMapOfTaskAndWorker">
        <tr>
          <td headers="workerName"><c:out value="${arrayListMapOfTaskAndWorker.workerName}" /><td>	
          <td headers="domainOfWork"><c:out value="${arrayListMapOfTaskAndWorker.domainOfWork}" /><td>
          <td headers="specificTask"><c:out value="${arrayListMapOfTaskAndWorker.specificTask}" /><td>	
          <td headers="credibility"><c:out value="${arrayListMapOfTaskAndWorker.credibility}" /><td>
          <td headers="yearsOfExperience"><c:out value="${arrayListMapOfTaskAndWorker.yearsOfExperience}" /><td>	
          <td headers="chargedFee"><c:out value="${arrayListMapOfTaskAndWorker.chargedFee}" /><td>
          <td headers="loginId" hidden="hidden"><c:out value="${arrayListMapOfTaskAndWorker.loginId}" /><td>
        </tr>
      </c:forEach>
    </table>
    
    <br/>
    <br/>
    
    Task Status : <input type="text" id="taskStatus" name="taskStatus" /><br/><br/>
    
    <br/>
    <br/>
    
    <input type="submit" value="Change Status" onclick="openPage('clientPage.jsp')"/>
  </body>
</html>
