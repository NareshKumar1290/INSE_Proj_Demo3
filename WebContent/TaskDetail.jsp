<form action="TaskDetailConfirmation.jsp">
	<h1>Welcome to the Task Page. Kindly submit your task here. Thanks
		!!!!</h1>
	Task Name : <input type="text" name="taskName" /><br />
	<br /> Domain : <input type="text" name="domain" /><br />
	<br /> Task Description : <input type="text" name="taskDescription" /><br />
	<br /> Number of Workers Required : <input type="text"
		name="numberOfWorkerRequired" /><br />
	<br /> Budget Per Worker : <input type="text" name="budgetPerWorker" /><br />
	<br /> Task Status : <input type="text" name="taskStatusString" /><br />
	<input type="text" hidden="hidden" name="clientId" value="<%=request.getParameter("loginId") %>" /><br />
	<input type="text" hidden="hidden" name="loginId" value="<%=request.getParameter("loginId") %>" /><br />
	<br /> <input type="submit" value="Add Task" />
	<Input type="button" name = "Client Page" value="Back" onClick="openPage('clientPage.jsp?1=1');">
	<Input type="button" name = "Logout" value="Logout" onClick="openPage('index.jsp?1=1');">
</form>