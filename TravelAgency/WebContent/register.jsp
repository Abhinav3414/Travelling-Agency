<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Register A New User Here !!!</title>
<script type="text/javascript">

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
function validate()
{
	var a=document.f2.fname.value;
	var b=document.f2.lname.value;
	var c=document.f2.dob.value;
	var d=document.f2.gender.value;
	var e=document.f2.street.value;
	var f=document.f2.location.value;
	var g=document.f2.city.value;
	var h=document.f2.state.value;
	var i=document.f2.pincode.value;
	var j=document.f2.mno.value;
	var k=document.f2.email.value;
	var atpos=k.indexOf("@");
	var dotpos = k.lastIndexOf(".");
		
	if(a=="" || a.lenght==0)
	{
		alert("Enter First Name !!");
		return false;
	}
	if(b=="")
	{
		alert("Enter Last Name !!");
		return false;
	}
	if(c=="")
	{
		alert("Enter Date of Birth !!");
		return false;
	}
	if(e=="")
	{
		alert("Enter Street !!");
		return false;
	}
	if(f=="")
	{
		alert("Enter Location !!");
		return false;
	}
	if(g=="")
	{
		alert("Enter City !!");
		return false;
	}
	if(h=="")
	{
		alert("Enter State !!");
		return false;
	}
	if(i=="")
	{
		alert("Enter PinCode !!");
		return false;
	}
	if(isNaN(i) )
	{	
		alert("Enter only digits in Pin Code");
		return false;
	}
	if(i.length!=6 )
	{	
		alert("Enter 6 digits in Pin Code");
		return false;
	}
	if(j=="")
	{
		alert("Enter Mobile No. !!");
		return false;
	}
	if(isNaN(j) )
	{	
		alert("Enter only digits in Mobile No.");
		return false;
	}
	if(j.length!=10 )
	{	
		alert("Enter 10 digits in mobile number");
		return false;
	}
	
	if(k=="")
	{
		alert("Enter Email ID !!");
		return false;
	}
	if(atpos <1 || dotpos<atpos+2 || dotpos+2>=k.length)
	{	
		alert("Not a Valid Email Address");
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

			<%@ include file="subheader.jsp"%>
		</div>
		<div id="body">
			<div id="bodyleft">
				
			</div>
			<div id="bodyright">
				<br>
				<form name="f2" method="post" action="RegisterServlet" onsubmit="return validate();">
					<br>
					<table align="center">
						<tr>
							<td>First Name</td>
							<td><input name="fname" type="text"></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><input name="lname" type="text"></td>
						</tr>
						<tr>
							<td>Date of Birth</td>
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
							<td>Gender</td>
							<td>
							<select name="gender">
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									</select>
									
									</td>
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
							<td>Email Id</td>
							<td><input name="email" type="text"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit" value="Register">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>