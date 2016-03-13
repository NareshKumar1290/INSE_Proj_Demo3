
<form>
	<h1>Welcome to Client Page !!!!!</h1>
	
	<Input type="button" name = "Add Tasks" value="Add Tasks" onClick="openPage('TaskDetail.jsp');">
	<Input type="button" name = "View Tasks" value="View Tasks" onClick="openPage('viewTaskDetail.jsp');">
</form>


<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType;
    }
</script>