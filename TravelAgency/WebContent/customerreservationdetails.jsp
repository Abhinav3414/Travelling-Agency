<%@page import="com.ata.dao.ReservationDAOImpl"%>
<%@page import="com.ata.dao.DriverDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="java.io.*"
	import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Customer Reservation Details</title>
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
				
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
				else
				{
					
					ArrayList<ReservationBean> alistRes = (ArrayList) session
							.getAttribute("resList");
					ReservationBean resbean = new ReservationBean();
					resbean=(ReservationBean)session.getAttribute("cancelRes");
					
				%>
				<br> <br> <br>
				<table border="1" cellspacing="1" cellpadding="3" align="left">
					<tr>
						<th>Reservation ID</th>
						<th>Vehicle Id</th>
						<th>Booking Date</th>
						<th>Journey Date</th>
						<th>Total Fare</th>
						<th>Boarding point</th>
						<th>Drop Point</th>
						<th>Booking Status</th>
					</tr>
				
					<tr>
						<form name="f14" method="get" action="BookingServlet">

							<td><input name="resId" type="text" size="6" maxlength="6"
								readonly="readonly" value="<%=resbean.getReservationID()%>"></td>
							<td><input name="vid" size="6" maxlength="6" type="text"
								readonly="readonly" value="<%=resbean.getVehicleID()%>"></td>
							<td><input name="bookdate" type="text" readonly="readonly"
								value="<%=resbean.getBookingDate()%>"></td>
							<td><input name="jdate" type="text" readonly="readonly"
								value="<%=resbean.getJourneyDate()%>"></td>
							<td><input name="totalfare" size="6" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resbean.getTotalFare()%>"></td>
							<td><input name="boarding" size="12" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resbean.getBoardingPoint()%>"></td>
							<td><input name="drop" size="12" maxlength="6" type="text"
								readonly="readonly" value="<%=resbean.getDropPoint()%>"></td>
							<td><input name="drop" size="12" maxlength="6" type="text"
								readonly="readonly" value="<%=resbean.getBookingStatus()%>"></td>
							
						<% String msg=""; 
						if(!(resbean.getBookingStatus()).equals("Cancelled") )
						{
							msg="Cancel Booking";
						}
							
							 %>	
							<td><a
								href='BookingServlet?name=delete&resid=<%=resbean.getReservationID()%>'>
									<%=msg %></a></td>
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
		
	</div>
</body>
</html>