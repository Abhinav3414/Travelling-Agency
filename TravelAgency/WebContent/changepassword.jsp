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
<title>Change Password</title>
<script>
	function validate() {
		var user = document.f5.newpass.value;
		var password = document.f5.cpass.value;

		if(user="" || user.length==0)
		{
			alert("Enter Password");
			return false;
		}
		if(password="" || password.length==0)
		{
			alert("Enter Password");
			return false;
		}
		if(user!=password)
		{
			alert("Password does not match !!");
			return false;
		}
		if(password.length<4 && user.length<4)
			{
			
		alert("Password has to be 4 characters");
		return false;
			}
		else 
		{
			return true;
		}
	}
</script>
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
				
				<div align="center">
				<br><br>
			
			<div style="color: #3D5C00">
					
					<h3>Change Your Password And Login Again !!!
					</h3>
				</div>

				</div>
				<br><br>
				<form name="f5" method="post" action="ChangePasswordServlet">
				<br>
					<table align="center">
						<tr>
							<td>Old Password</td>
							<td><input name="name" type="text" readonly="readonly"  value="<%=credentialsBean.getPassword()%>"></td>
						</tr>
						<tr>
							<td>New Password</td>
							<td><input name="newpass" type="text"></td>
						</tr>
						<tr>
							<td>Confirm Password</td>
							<td><input name="cpass" type="text"></td>
						</tr>
						<tr>
				<td></td>
				<td><input name="submit" type="submit" value="Change Password">
				</td>
			</tr>
			<%} %>
					</table>
					<br>
				</form>
			</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>
