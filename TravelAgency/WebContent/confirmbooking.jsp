<%@page import="com.ata.service.CustomerImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.ata.bean.*" import="com.ata.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Your Booking</title>

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

				<%
		if(session.getAttribute("userid")==null)
		{
			response.sendRedirect("index.jsp");
		}	
		else
		{
					
					String bookingId = (String) session.getAttribute("resId");
					ReservationDAOImpl resDao = new ReservationDAOImpl();
					
					CustomerImpl customerImpl=new CustomerImpl();
					ReservationBean rBean = new ReservationBean();
					rBean =customerImpl.viewBookingDetails(bookingId);

					RouteDAOImpl routeDao = new RouteDAOImpl();
					RouteBean routeBean = new RouteBean();
					routeBean = routeDao.findByID(rBean.getRouteID());
					String source = (String) routeBean.getSource();
					String destination = (String) routeBean.getDestination();
					String route = source + "-" + destination;

					VehicleDAOImpl vehicleDao = new VehicleDAOImpl();
					VehicleBean vehicleBean = new VehicleBean();
					vehicleBean = vehicleDao.findByID(rBean.getVehicleID());
					String vehiclename = (String) vehicleBean.getName();
				%>

				<br>
				<br>
				<form name="f13" method="post" action="confirmbooking.jsp" onClick=" window.print(); return false">
					<br>
					<table align="center">
						<tr>
							<td>Vehicle</td>
							<td><input name="bookdate" type="text"
								value="<%=vehiclename%>"></td>
						</tr>
						<tr>
							<td>Route</td>
							<td><input name="bookdate" type="text" value="<%=route%>"></td>
						</tr>
						<tr>
							<td>Booking Date</td>
							<td><input name="bookdate" type="text"
								value="<%=rBean.getBookingDate()%>"></td>
						</tr>
						<tr>
							<td>Journey Date</td>
							<td><input name="journeydate" type="text"
								value="<%=rBean.getJourneyDate()%>"></td>
						</tr>

						<tr>
							<td>Boarding Point</td>
							<td><input name="boarding" type="text"
								value="<%=rBean.getBoardingPoint()%>"></td>
						</tr>
						<tr>
							<td>Dropping Point</td>
							<td><input name="dropping" type="text"
								value="<%=rBean.getDropPoint()%>"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit"
								value="Print Your Details"></td>
						</tr>
					</table>
					<br>
				</form>
			</div>
		</div>
		<div id="footer">
		<% } %>
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>