
<%@page import="bean.TaskDetailDao"%>
<%@page import="bean.LoginDao"%>
<jsp:useBean id="obj" class="bean.TaskDetailBean"/>

<jsp:setProperty property="*" name="obj"/>

<%
boolean status = TaskDetailDao.validate(obj);
request.setAttribute("loginId", obj.getClientId());
request.setAttribute("loginType", LoginDao.getCheckType(obj.getClientId()));
	
if(status){
out.println("Information has successfully saved into the database.");
session.setAttribute("session","TRUE");
}
else
{
out.print("Sorry, There are some issues in the information provided. Please check again and submit. Thanks !!!!");
}
%>
<jsp:include page="clientPage.jsp">
	<jsp:param name="loginId" value='<%=request.getParameter("loginId")%>' />
	<jsp:param name="loginType" value='<%=request.getParameter("loginType")%>' />
</jsp:include>
