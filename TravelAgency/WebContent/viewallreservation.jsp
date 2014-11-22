<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  import="java.util.*"  import="com.ata.bean.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
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
			{ %>
			Input Details<br><br><br>
				<form name="f30" method="post" action="ReservationViewAllServlet">
					<br>
					<table align="center">
						<tr>
							<td>Select Date</td>
							<td>
							
							
								<select name="dd" id="date">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									
									
								</select>
								
									<select name="mm" id="datemonth">
									<option value="1">Jan</option>
									<option value="2">Feb</option>
									<option value="3">Mar</option>
									<option value="4">Apr</option>
									<option value="5">May</option>
									<option value="6">Jun</option>
									<option value="7">Jul</option>
									<option value="8">Aug</option>
									<option value="9">Sep</option>
									<option value="10">Oct</option>
									<option value="11">Nov</option>
									<option value="12">Dec</option>
								</select>
								
								<input name="yyyy" type="text" size="6" maxlength="4" id="dateyear">
								</td>					
						</tr>
						<tr>
							<td>Enter Boarding Point</td>
							<td><input name="board" type="text"></td>
						</tr>
						<tr>
							<td>Enter Dropping Point</td>
							<td><input name="drop" type="text"></td>
						</tr>
						
						<tr>
							<td></td>
							<td><input name="submit" type="submit"
								value="Show Details"></td>
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
