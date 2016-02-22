
<%@page import="bean.RegisterDao"%>
<jsp:useBean id="obj" class="bean.RegisterBean" />

<jsp:setProperty property="*" name="obj" />

<%
	boolean status = RegisterDao.validate(obj);

	if (status) {
		out.println("Information has successfully saved into the database. Please login to continue");
		session.setAttribute("session", "TRUE");
		%>
		<jsp:include page="index.jsp"></jsp:include>
		<%
	} else {
		out.print("Sorry, There are some issues in the information provided. Please check again and submit. Thanks !!!!");
		%>
		<jsp:include page="RegisterDetail.jsp"></jsp:include>
		<%

	}
%>