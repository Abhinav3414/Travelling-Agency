<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  import="java.util.*"  import="com.ata.bean.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Viewing Vehicle Details</title>

</head>
<body>
	<div id="full">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div id="subheader">

			<%@ include file="subheaderadmin.jsp"%>
		</div>
		<div id="body">
			<div id="bodyleft">
				<%@ include file="adminbodyleft.jsp"%>
			</div>
			<div id="bodyright">
			
			<%

			if (session.getAttribute("userid") == null) {
				response.sendRedirect("index.jsp");
			}
			else
			{
				ArrayList<VehicleBean> alistVehicle= (ArrayList)session.getAttribute("vehicleList");
				VehicleBean vbean = new VehicleBean();
				Iterator itr= alistVehicle.iterator();
			%>
			<br>
			Viewing Vehicle Details
			<br>
			<br>
			
		<table border="1" cellspacing="1" cellpadding="3" align="left">
		<tr>

			<th>ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Registration Number</th>
			<th>Seating Capacity</th>
			<th>Fare Per Km</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<%
			while (itr.hasNext()) 
			{
				
				vbean = (VehicleBean) itr.next();
		%>
		<tr>
			<form name="f4" method="post">

				<td><input name="id" type="text" size="6" maxlength="6"
					readonly="readonly" value="<%=vbean.getVehicleID()%>"></td>
				<td><%=vbean.getName()%></td>
				<td><%=vbean.getType()%></td>
				<td><%=vbean.getRegistrationNumber()%></td>
				<td><%=vbean.getSeatingCapacity()%></td>
				<td><%=vbean.getFarePerKM()%></td>
				<td><a href='VehicleServlet?VehilceID=<%=vbean.getVehicleID()%>'>Update</a></td>
				<td><a href='VehicleDeleteServlet?vehicleID=<%=vbean.getVehicleID()%>'>Delete</a></td>
			</form>
		</tr>
		<%	
			}}
		%>
	</table>	
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>