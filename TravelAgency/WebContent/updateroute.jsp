<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Update Route Here</title>

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
					RouteBean rbean = new RouteBean();
					rbean = (RouteBean) session.getAttribute("updatedRouteBean");
				%>
				<br>
				<form name="f6" method="post" action="RouteUpdateServlet">
					<br>
					<table align="center">
						<tr>
							<td>Route Id</td>
							<td><input name="rid" type="text" readonly="readonly"
								value="<%=rbean.getRouteID()%>"></td>
						</tr>

						<tr>
							<td>Route Source</td>
							<td><input name="source" type="text"
								value="<%=rbean.getSource()%>"></td>
						</tr>
						<tr>
							<td>Route Destination</td>
							<td><input name="destination" type="text"
								value="<%=rbean.getDestination()%>"></td>
						</tr>
						<tr>
							<td>Route Distance</td>
							<td><input name="distance" type="text"
								value="<%=rbean.getDistance()%>"></td>
						</tr>
						<tr>
							<td>Travel Duration</td>
							<td><input name="duration" type="text"
								value="<%=rbean.getTravelDuration()%>"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit" value="Update Route">
							</td>
						</tr>
					</table>
					<br>
				</form>
				<%} %>

			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>