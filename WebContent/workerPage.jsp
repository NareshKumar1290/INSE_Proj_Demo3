<form>
	<h1>Welcome to Worker Page !!!!!</h1>
	
	<Input type="button" name = "Add Skills" value="Add Skills" onClick="openPage('WorkerSkillExperience.jsp');">
	
</form>


<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType;
    }
</script>
