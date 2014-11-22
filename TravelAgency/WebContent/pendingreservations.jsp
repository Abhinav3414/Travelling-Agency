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
<title>Pending Reservations</title>

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
					} else {

						ArrayList<ReservationBean> alistRes = (ArrayList) session
								.getAttribute("pendingRes");
						ReservationBean resbean = new ReservationBean();
						Iterator<ReservationBean> itr = alistRes.iterator();

						ReservationDAOImpl reDaoImpl1 = new ReservationDAOImpl();
						ReservationBean reservationBeans = new ReservationBean();
				%>
				<br> Viewing Pending Reservations <br> <br>


				<table border="1" cellspacing="1" align="left" cellpadding="1">
					<tr>
						<th>Reservation ID</th>
						<th>User Id</th>
						<th>Vehicle Id</th>
						<th>Route Id</th>
						<th>Booking Date</th>
						<th>Journey Date</th>
						<th>Driver Id</th>
						<th>Booking Status</th>
						<th>Total Fare</th>
						<th>Boarding point</th>
						<th>Drop Point</th>
					</tr>
					<%
						while (itr.hasNext()) {
								//ReservationDAOImpl reDaoImpl= new ReservationDAOImpl();
								ReservationBean reservationBean = new ReservationBean();
								resbean = (ReservationBean) itr.next();
					%>
					<tr>
						<form name="f14" method="get" action="ReservationServlet">

							<td width="20"><input name="resId" type="text" size="6"
								maxlength="6" readonly="readonly"
								value="<%=resbean.getReservationID()%>"></td>
							<td width="20"><input name="uid" size="5" maxlength="6"
								type="text" readonly="readonly" value="<%=resbean.getUserID()%>"></td>

							<td width="20"><input name="vid" size="6" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resbean.getVehicleID()%>"></td>
							<td width="20"><input name="rid" size="8" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resbean.getRouteID()%>"></td>
							<td width="20"><input name="bookdate" type="text"
								readonly="readonly" size="8"
								value="<%=resbean.getBookingDate()%>"></td>
							<td width="20"><input name="jdate" type="text"
								readonly="readonly" size="8"
								value="<%=resbean.getJourneyDate()%>"></td>

							<td width="20"><select name="driverid">
									<option value="">-Allot Driver-</option>

									<%
										DriverDAOImpl driverDAOImpl = new DriverDAOImpl();

												ArrayList<DriverBean> alistDriver = new ArrayList<DriverBean>();
												alistDriver = driverDAOImpl.findAll();
												ListIterator<DriverBean> itrDriver = alistDriver
														.listIterator();

												ArrayList<String> driverList = new ArrayList<String>();

												driverList = reDaoImpl1.driverAvailable(resbean
														.getJourneyDate());

												Iterator<String> it = driverList.iterator();

												while (itrDriver.hasNext()) {
													DriverBean dbean = new DriverBean();
													dbean = (DriverBean) itrDriver.next();

													while (it.hasNext()) {
														String dd = it.next();
														if ((dd).equals(dbean.getDriverID())) {
															itrDriver.previous();
															itrDriver.remove();
															dbean = (DriverBean) itrDriver.next();
														}
													}
									%>
									<option value="<%=dbean.getDriverID()%>">
										<%=dbean.getName()%>
									</option>
									<%
										}
									%>
							</select></td>

							<td width="20"><select name="status">
									<option value="pending"><%=resbean.getBookingStatus()%></option>
									<option value="approved">Approve</option>
									<option value="completed">Completed</option>
							</select></td>

							<td width="20"><input name="totalfare" size="6"
								maxlength="6" type="text" readonly="readonly"
								value="<%=resbean.getTotalFare()%>"></td>
							<td width="23"><input name="boarding" size="7" maxlength="6"
								type="text" readonly="readonly"
								value="<%=resbean.getBoardingPoint()%>"></td>
							<td width="23"><input name="drop" size="9" maxlength="9"
								type="text" readonly="readonly"
								value="<%=resbean.getDropPoint()%>"></td>
							<td><input type="submit" value="Update"></td>
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
		<%
			}
		%>
	</div>
</body>
</html>