<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" import="com.ata.bean.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Viewing all Reservation Details</title>

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
						ArrayList<ReservationBean> alistReservation = (ArrayList) session
								.getAttribute("reservationList");
						ReservationBean resBean = new ReservationBean();
						Iterator itr = alistReservation.iterator();
				%>
				<br> Viewing Reservation Details <br> <br>
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
					<%
						while (itr.hasNext()) {
								resBean = (ReservationBean) itr.next();
					%>
					<tr>
						<form name="f14" method="get">

							<td><input name="resId" type="text" size="6" maxlength="6"
								readonly="readonly" value="<%=resBean.getReservationID()%>"></td>
							<td><input name="vid" size="6" maxlength="6" type="text"
								readonly="readonly" value="<%=resBean.getVehicleID()%>"></td>
							<td><input name="bookdate" type="text" readonly="readonly"
								value="<%=resBean.getBookingDate()%>"></td>
							<td><input name="jdate" type="text" readonly="readonly"
								value="<%=resBean.getJourneyDate()%>"></td>
							<td><input name="totalfare" size="6" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resBean.getTotalFare()%>"></td>
							<td><input name="boarding" size="12" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resBean.getBoardingPoint()%>"></td>
							<td><input name="drop" size="12" maxlength="6" type="text"
								readonly="readonly" value="<%=resBean.getDropPoint()%>"></td>
							<td><input name="drop" size="12" maxlength="6" type="text"
								readonly="readonly" value="<%=resBean.getBookingStatus()%>"></td>

						</form>
					</tr>

					<%  	
						}}%>
				</table>

			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>

</html>
