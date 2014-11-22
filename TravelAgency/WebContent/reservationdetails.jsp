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
<title>Reservation Details</title>
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
					Iterator<ReservationBean> itr = alistRes.iterator();
				%>
				<br> <br> <br>
			
					
			
						<form name="f14" method="post" action="ReservationViewServlet">

						
								
									<table border="1" cellspacing="1" cellpadding="3" align="center">
										<tr>
									<td width="20"><select name="resId">
									<option value="">-Select Reservation Id-</option>

								<%
						while (itr.hasNext()) {

							resbean = (ReservationBean) itr.next();
					%>
									<option value="<%=resbean.getReservationID()%>">
										<%=resbean.getReservationID()%>
									</option>
									<%
										}
									%>
							</select></td>
								
								
							
								
							
						<% String msg=""; 
						if(!(resbean.getBookingStatus()).equals("Cancelled") )
						{
							msg="Cancel Booking";
						}
							
							 %>	
							<td><input type="submit" name="sub" value="Show"></td>
						</tr>
						</table>
						</form>
					
					<%
						}
					%>
				
				<%// } %>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
		
	</div>
</body>
</html>