<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  import="java.util.*"  import="com.ata.bean.*"
	pageEncoding="ISO-8859-1"%>
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
					ArrayList<RouteBean> alistRoute= (ArrayList)session.getAttribute("routeList");
					RouteBean rbean = new RouteBean();
					Iterator itr= alistRoute.iterator();
					int i=1;
				%>
			<br>
			 Viewing Route Details
			<br>
			<br>			
		<table border="1" cellspacing="1" cellpadding="3" align="left">
		<tr>		
			<th>Route ID</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Distance</th>
			<th>Duration</th>
			<th>Update</th>
			<th>Delete</th>						
		</tr>
		<%
			while (itr.hasNext()) 
			{
				i++;
				rbean = (RouteBean) itr.next();
		%>
		<tr>
			<form name="f4" method="post">				
				
				<td ><input name="id" type="text"  size="8" maxlength="8" readonly="readonly"  value="<%=rbean.getRouteID()%>"></td>
				<td ><%=rbean.getSource()%></td>
				<td><%=rbean.getDestination()%></td>
				<td><%=rbean.getDistance()%></td>
				<td ><%=rbean.getTravelDuration()%></td>
				<td><a href='RouteServlet?RouteID=<%=rbean.getRouteID()%>'> Update</a></td>
				<td><a href='RouteDeleteServlet?routeID=<%=rbean.getRouteID()%>'> Delete</a></td>				
			</form>
		</tr>
		
	<%  	}	}	%>
	</table>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>