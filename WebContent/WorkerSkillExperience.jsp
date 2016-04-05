
<script language="JavaScript">
	
    function openPage(pageURL)
    {
    	var loginId = <%=request.getParameter("loginId")%>;
    	var loginIdType = <%=request.getParameter("loginIdType")%>;
   		
    	window.location.href = pageURL+"&loginId="+loginId+"&loginIdType="+loginIdType;
    }
</script>

<form action="WorkerSkillExperienceSave.jsp">
	<h1>Welcome to Worker Page !!!!!</h1>
	
	Please list down your skill and experience - MAX 5
<br/><br/> 

Domain <Input type="input" id ="domainOfWork1" name = "domainOfWork1" >
<br/><br/>
Skill <Input type="input" id ="specificTask1" name = "specificTask1">
<br/><br/>
Years of Experience <Input type="input" id ="yearsOfExperience1" name = "yearsOfExperience1">
<br/><br/>
Charged Fee <Input type="input" id ="chargedFee1" name = "chargedFee1">
<br/><br/><br/><br/>

Domain <Input type="input" id ="domainOfWork2" name = "domainOfWork2" >
<br/><br/>
Skill <Input type="input" id ="specificTask2" name = "specificTask2">
<br/><br/>
Years of Experience <Input type="input" id ="yearsOfExperience2" name = "yearsOfExperience2">
<br/><br/>
Charged Fee <Input type="input" id ="chargedFee2" name = "chargedFee2">
<br/><br/><br/><br/>

Domain <Input type="input" id ="domainOfWork3" name = "domainOfWork3" >
<br/><br/>
Skill <Input type="input" id ="specificTask3" name = "specificTask3">
<br/><br/>
Years of Experience <Input type="input" id ="yearsOfExperience3" name = "yearsOfExperience3">
<br/><br/>
Charged Fee <Input type="input" id ="chargedFee3" name = "chargedFee3">
<br/><br/><br/><br/>

Domain <Input type="input" id ="domainOfWork4" name = "domainOfWork4" >
<br/><br/>
Skill <Input type="input" id ="specificTask4" name = "specificTask4">
<br/><br/>
Years of Experience <Input type="input" id ="yearsOfExperience4" name = "yearsOfExperience4">
<br/><br/>
Charged Fee <Input type="input" id ="chargedFee4" name = "chargedFee4">
<br/><br/><br/><br/>

Domain <Input type="input" id ="domainOfWork5" name = "domainOfWork5" >
<br/><br/>
Skill <Input type="input" id ="specificTask5" name = "specificTask5">
<br/><br/>
Years of Experience <Input type="input" id ="yearsOfExperience5" name = "yearsOfExperience5">
<br/><br/>
Charged Fee <Input type="input" id ="chargedFee5" name = "chargedFee5">
<br/><br/><br/><br/>

Available <select id=available name="available">
  <option id="availableYes" name="availableYes" value="availableYes">Yes</option>
  <option id="availableNo" name="availableNo" value="availableNo">No</option>
</select>

<Input type="input" hidden="hidden" id ="loginId" name = "loginId" value="<%=request.getParameter("loginId")%>">

<br/><br/><br/><br/>

<Input type="submit" name ="Save" value="Save">
<br/><br/>
<Input type="button" name = "Worker Page" value="Back" onClick="openPage('workerPage.jsp?1=1');">
<Input type="button" name = "Logout" value="Logout" onClick="openPage('index.jsp?1=1');">

</form>
