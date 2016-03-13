
<form>
	<h1>Welcome to Search For Worker Page !!!!!</h1>
	
</form>


<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"?loginId="+loginId+"&loginIdType="+loginIdType;
    }
</script>