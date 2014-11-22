<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Viewing Route Details</title>
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
				Customer Route Details
				<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			
				else
				{
					
				ArrayList<RouteBean> alistRoute = (ArrayList) session.getAttribute("cRouteList");
				RouteBean rbean = new RouteBean();
				Iterator itr = alistRoute.iterator();
				int i = 1;
			%>
				<br> <br>
				<table border="1" cellspacing="1" cellpadding="3" align="left">
					<tr>

						<th width="90">Route ID</th>
						<th>Source</th>
						<th>Destination</th>
						<th>Distance</th>
						<th>Duration</th>

					</tr>
					<%
						while (itr.hasNext()) {

							rbean = (RouteBean) itr.next();
					%>
					<tr>
						<form name="f4" method="post">

							<td width="90"><input name="id" type="text" size="9" maxlength="9"
								readonly="readonly" value="<%=rbean.getRouteID()%>"></td>
							<td><%=rbean.getSource()%></td>
							<td><%=rbean.getDestination()%></td>
							<td><%=rbean.getDistance()%></td>
							<td><%=rbean.getTravelDuration()%></td>
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