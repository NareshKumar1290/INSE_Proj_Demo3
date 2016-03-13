<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.TaskDetailBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<TaskDetailBean> taskDetailDaoObj = TaskDetailDao.fetchClientTaskRecords(request.getParameter("loginId"));
	pageContext.setAttribute("taskDetailDao", taskDetailDaoObj);
%>
<html>
  <head>
    <title>Welcome to Client's Page</title>
  </head>
  <body bgcolor="white">
    Here are all tasks Given By You:
    <table>
    <tr>
    	<th>Task Name</th>
     	<th>Domain Of Work</th>
      	<th>Task Description</th>
      	<th>Worker Required</th>
      	<th>Budget</th>
      	<th>Status</th>
    </tr>
      <c:forEach items="${taskDetailDao}" var="taskDetailDao">
        <tr>
          <td><c:out value="${taskDetailDao.taskName}" /><td>	
          <td><c:out value="${taskDetailDao.clientId}" /><td>
          <td><c:out value="${taskDetailDao.taskDescription}" /><td>	
          <td><c:out value="${taskDetailDao.numberOfWorkerRequired}" /><td>
          <td><c:out value="${taskDetailDao.budgetPerWorker}" /><td>	
          <td><c:out value="${taskDetailDao.taskStatusString}" /><td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
