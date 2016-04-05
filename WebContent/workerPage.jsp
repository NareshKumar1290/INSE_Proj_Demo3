<form>
	<h1>Welcome to Worker Page !!!!!</h1>
	
	<Input type="button" name = "Add Skills" value="Add Skills" onClick="openPage('WorkerSkillExperience.jsp');">
	<Input type="button" name = "View Tasks" value="View Tasks" onClick="openPage('ViewWorkersTaskList.jsp');">
	<Input type="button" name = "Logout" value="Logout" onClick="openPage('index.jsp');">
</form>


<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType;
    }
</script>
