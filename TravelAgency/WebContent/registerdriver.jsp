<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Register Driver</title>
<script>
function validation()
{
	var a1=document.f3.name.value;
	var a2=document.f3.street.value;
	var a3=document.f3.location.value;
	var a4=document.f3.city.value;
	var a5=document.f3.state.value;
	var a6=document.f3.pincode.value;
	var a7=document.f3.mno.value;
	var a8=document.f3.lno.value;
	
	if(a1==""||a1.length==0)
		{
		alert("Enter Driver Name !!");
		return false;
		}
	if(a2==""||a2.length==0)
	{
	alert("Enter Street Name !!");
	return false;
	}
	if(a3==""||a3.length==0)
	{
	alert("Enter Location Name !!");
	return false;
	}
	if(a4==""||a4.length==0)
	{
	alert("Enter City Name !!");
	return false;
	}
	if(a5==""||a5.length==0)
	{
	alert("Enter State Name !!");
	return false;
	}
	if(a6==""||a6.length==0)
	{
	alert("Enter PinCode Name !!");
	return false;
	}
	if(a6.length!=6)
	{
	alert("Enter 6 digits in Pin Code");
	return false;
	}
	if(isNaN(a6))
	{
	alert("Only digits allowed in Pin Code");
	return false;
	}
	if(a7==""||a7.length==0)
	{
	alert("Enter Mobile Number !!");
	return false;
	}
	if(a7.length!=10)
	{
	alert("Enter 10 digits in Mobile Number !!");
	return false;
	}
	if(isNaN(a7))
	{
	alert("Only digits allowed in Mobile Number");
	return false;
	}
	if(a8==""||a8.length==0)
	{
	alert("Enter License Number!!");
	return false;
	}
	else
	{
	return true;
	}
}

</script>
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
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%>
			<div id="bodyright">

				Register Driver Details
				<form name="f3" method="post" action="CreateDriverServlet" onsubmit="return validation();">
					<br>
					<table align="center">
						<tr>
							<td>Name</td>
							<td><input name="name" type="text"></td>
						</tr>
						<tr>
							<td>Street</td>
							<td><input name="street" type="text"></td>
						</tr>
						<tr>
							<td>Location</td>
							<td><input name="location" type="text"></td>
						</tr>
						<tr>
							<td>City</td>
							<td>
							
							<select name="city" id="city">
									<option value="Lucknow">Lucknow</option>
									<option value="Ludhiana">Ludhiana</option>
									<option value="Agra">Agra</option>
									<option value="Chennai">Chennai</option>
									<option value="Bangalore">Bangalore</option>
									<option value="Pune">Pune</option>
									<option value="Vishakhapatnam">Vishakhapatnam</option>
									<option value="Merrut">Merrut</option>
									<option value="Bareily">Bareily</option>
									<option value="Ghaziabad">Ghaziabad</option>
									<option value="Mumbai">Mumbai</option>
									<option value="Srinagar">Srinagar</option>
									<option value="Kolkata">Kolkata</option>
									<option value="Kochi">Kochi</option>
									<option value="Patna">Patna</option>
									<option value="Bhubhaneshwar">Bhubhaneshwar</option>
									<option value="Dharbhanga">Dharbhanga</option>
									<option value="Hyderabad">Hyderabad</option>
									<option value="Durgapur">Durgapur</option>
									<option value="Jaipur">Jaipur</option>
								</select>
								</td>
						</tr>
						<tr>
							<td>State</td>
							<td>
							
							<select name="state" id="state">
									<option value="andhrapradesh">Andhra Pradesh</option>
									<option value="arunachalpradesh">Arunachal Pradesh</option>
									<option value="delhi">Delhi</option>
									<option value="westbengal">West Bengal</option>
									<option value="jharkhand">Jharkhand</option>
									<option value="uttarpradesh">Uttar Pradesh</option>
									<option value="utrakhand">Utrakhand</option>
									<option value="punjab">Punjab</option>
									<option value="tamilnadu">Tamil Nadu</option>
									<option value="haryana">Haryana</option>
									<option value="assam">Assam</option>
									<option value="jammuandkashmir">Jammu and Kashmir</option>
									<option value="himachalpradesh">Himachal Pradesh</option>
									<option value="kerala">Kerala</option>
									<option value="karnataka">Karnataka</option>
									<option value="maharastra">Maharastra</option>
									<option value="bihar">Bihar</option>
									<option value="orrisa">Orrisa</option>
									<option value="gujarat">Gujarat</option>
									<option value="rajasthan">Rajasthan</option>
								</select>
								</td>
						</tr>
						<tr>
							<td>PinCode</td>
							<td><input name="pincode" type="text" maxlength="6"></td>
						</tr>
						<tr>
							<td>Mobile Number</td>
							<td><input name="mno" type="text" maxlength="10"></td>
						</tr>
						<tr>
							<td>Licence Number</td>
							<td><input name="lno" type="text"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit"
								value="Register Driver"></td>
						</tr>
					</table>
					<br>
				</form>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>

