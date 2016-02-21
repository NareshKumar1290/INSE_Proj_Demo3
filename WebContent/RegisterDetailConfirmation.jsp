
<%@page import="bean.RegisterDao"%>
<jsp:useBean id="obj" class="bean.RegisterBean"/>

<jsp:setProperty property="*" name="obj"/>

<%
boolean status = RegisterDao.validate(obj);
	
if(status){
out.println("Information has successfully saved into the database.");
session.setAttribute("session","TRUE");
}
else
{
out.print("Sorry, There are some issues in the information provided. Please check again and submit. Thanks !!!!");

}
%>