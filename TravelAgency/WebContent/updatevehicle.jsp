<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Update Vehicle Here</title>

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
					VehicleBean vbean = new VehicleBean();
					vbean = (VehicleBean) session.getAttribute("updatedVehicleBean");
				%>

			<br>
				<form name="f11" method="post" action="VehicleUpdateServlet">
					<br>
					<table align="center">
						<tr>
							<td>Vehicle Id</td>
							<td><input name="vid" type="text" readonly="readonly"
								value="<%=vbean.getVehicleID()%>"></td>
						</tr>

						<tr>
							<td>Name</td>
							<td><input name="vname" type="text"
								value="<%=vbean.getName()%>"></td>
						</tr>
						
						<tr>
							<td>Type</td>
							<td><select name="vtype">
									
									<option value="AC">AC</option>
									<option value="NON-AC">NON-AC</option>
							</select></td>

						</tr>
						
						
						
						
						
						<tr>
							<td>Registration No.</td>
							<td><input name="vrno" type="text"
								value="<%=vbean.getRegistrationNumber()%>"></td>
						</tr>
						<tr>
							<td>Seating Capacity</td>
							<td>
									<select name="vscap" >
									<option value="<%=vbean.getSeatingCapacity()%>"> </option>								
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>							
							</select>									
							</td>
						</tr>
						<tr>
							<td>Fare Per Km</td>
							<td><input name="vfpk" type="text"
								value="<%=vbean.getFarePerKM()%>"></td>
						</tr>

						<tr>
							<td></td>
							<td><input name="submit" type="submit"
								value="Update Vehicle"></td>
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