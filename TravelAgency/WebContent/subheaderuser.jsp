<%@page import="com.ata.bean.ProfileBean"%>
<%@page import="com.ata.dao.ProfileDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userid=(String)session.getAttribute("userid");
ProfileDAOImpl profileDAOImpl= new ProfileDAOImpl();
ProfileBean profileBean = new ProfileBean();
profileBean = profileDAOImpl.findByID(userid);
%>

<table border="0" width="100%" align="center" cellpadding="5" id="subheaderadmin">
		<tr>

			<td>Welcome <%=profileBean.getFirstName()%> !!! </td>
			<td></td>
			<td></td>
			<td width="120px" align="center"><div
					style="background-color: white"><a href="userhome.jsp">Home</div></td>

			<td width="120px" align="center">
				<div style="background-color: white"><a href="LogoutServlet"> Logout</div>
			</td>
		</tr>
	</table>
</body>
</html>