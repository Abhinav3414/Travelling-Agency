<%@page import="java.io.PrintWriter"%>
<%@page import="com.ata.bean.CredentialsBean"%>
<%@page import="com.ata.dao.CredentialDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>User Home</title>

</head>
<body>
	<%
	if(session.getAttribute("userid")==null)
	{
		response.sendRedirect("index.jsp");
	}	
	else
	{
	
		String userId = (String) session.getAttribute("userid");
		CredentialDAOImpl credentialDAOImpl = new CredentialDAOImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean = credentialDAOImpl.findByID(userId);
	%>

	<div id="full">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div id="subheader">

			<%@ include file="subheaderuser.jsp"%>
		</div>
		<div id="body">
			<div id="bodyleft">
				<%@ include file="userbodyleft.jsp"%>
			</div>
			<div id="bodyright">
				<%
				String message="";
					if (credentialsBean.getPassword().equals("password123")) {
						response.sendRedirect("changepassword.jsp");
					}
					if(!(session.getAttribute("UpdateStatus")).equals("None"))
					{
						message=(String)session.getAttribute("UpdateStatus");
					}
				%>
					<br>
				<br>
				<div style="color:#3D5C00" >
				Your Last Activity:
			<h3><%=message %>	</h3>
				</div>
		<% } %>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>
