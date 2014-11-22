<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Customer Vehicle Details</title>
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
				Viewing Vehicle Details
				<%
				
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			
				else
				{
				ArrayList<VehicleBean> alistVehicle = (ArrayList) session.getAttribute("cVehicleLists");
				VehicleBean vbean = new VehicleBean();
				Iterator<VehicleBean> itr = alistVehicle.iterator();
			%>
				<br> <br>
				<table border="1" cellspacing="1" cellpadding="3" align="left">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Type</th>
						<th>Registration Number</th>
						<th>Seating Capacity</th>
						<th>Fare Per Km</th>
					</tr>
					<%
						while (itr.hasNext()) {

							vbean = (VehicleBean) itr.next();
					%>
					<tr>
						<form name="f13" method="post">
							<td><input name="id" type="text" size="6" maxlength="6"
								readonly="readonly" value="<%=vbean.getVehicleID()%>"></td>
							<td><%=vbean.getName()%></td>
							<td><%=vbean.getType()%></td>
							<td><%=vbean.getRegistrationNumber()%></td>
							<td><%=vbean.getSeatingCapacity()%></td>
							<td><%=vbean.getFarePerKM()%></td>
						</form>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
		<% } %>
	</div>
</body>
</html>