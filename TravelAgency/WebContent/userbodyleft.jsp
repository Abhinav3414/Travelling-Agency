<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1" height="340" width="300">

		<tr>
			<td></td>
			<td> <a href='customervehicletype.jsp'>View Vehicle By Type</a></td>
		</tr>
		<tr>
			<td></td>
			<td> <a href='customervehicleseats.jsp'>View Vehicle By Seats</a> <br>
			</td>
		</tr>
		<tr>
			<td width="50"></td>
			<td><a href='CustomerRouteViewServlet?name=routes'>View All Routes</a></td>
		</tr>
		<tr>
			<td width="50"></td>
			<td><a href="reservation.jsp">Plan your Travel</a><br>
			</td>
		</tr>
		<tr>
			<td width="50"></td>
			<td><a href="BookingServlet?name=view">View Booking Details</a></td>
		</tr>
		
	</table>
</body>
</html>