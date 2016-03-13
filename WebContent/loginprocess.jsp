
<%@page import="bean.LoginDao"%>
<jsp:useBean id="obj" class="bean.LoginBean"/>

<jsp:setProperty property="*" name="obj"/>

<%
Integer loginId = LoginDao.validate(obj);
if(loginId > 0){
out.println("You r successfully logged in");
session.setAttribute("session","TRUE");
session.setAttribute("loginId", loginId);
String url ="http://localhost:8080/INSE_Proj_Demo3/";
Integer loginIdType = LoginDao.getCheckType(loginId);
session.setAttribute("loginIdType", loginIdType);
	if(loginIdType == 1){
		url += "clientPage.jsp"+"?loginId="+loginId+"&loginIdType="+loginIdType;
	}else{ //change back to workerPage.jsp when you are done with the Task Page
		url += "workerPage.jsp"+"?loginId="+loginId+"&loginIdType="+loginIdType;
	}
response.sendRedirect(response.encodeRedirectURL(url));
}
else
{
out.print("Sorry, email or password error");
%>
<jsp:include page="index.jsp"></jsp:include>
<%
}
%>