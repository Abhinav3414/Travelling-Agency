<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Select Vehicle Seats</title>
</head>
<body>
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
				Select Vehicle Seats

				<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%>


				<br> <br>
					<form name="f132" method="post" action="CustomerVehicleSeatsServlet">
					<br>
				<table cellspacing="1" cellpadding="3" align="center"  >
							<tr>
							
							<td><select name="seats">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									</select>
									</td>
						</tr>
						<tr>
							
							<td><input name="submit" type="submit" value="View">
							</td>
						</tr>
						
				</table>
				<br>
				</form>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>