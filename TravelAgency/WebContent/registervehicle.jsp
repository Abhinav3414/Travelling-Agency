<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Register New Vehicle</title>
<script type="text/javascript">

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
function validation()
{
	var a1=document.f5.name.value;
	var a2=document.f5.type.value;
	var a3=document.f5.rnumber.value;
	var a4=document.f5.capacity.value;
	var a5=document.f5.fpkm.value;
	
	if(a1=="" || a1.length==0)
		{
		alert("Enter Vehicle Name !!");
		return false;
		}
	if(a2=="" || a2.length==0)
	{
	alert("Enter Vehicle Type !!");
	return false;
	}
	if(a3=="" || a3.length==0)
	{
	alert("Enter Vehicle Registration Number !!");
	return false;
	}
	if(isNaN(a4))
	{
	alert("Enter digits in capacity only !!");
	return false;
	}
	if(a4=="" || a4.length==0)
	{
	alert("Enter Vehicle Seating Capacity !!");
	return false;
	}
	if(isNaN(a5))
	{
	alert("Enter digits in fare/km !!");
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

				Register New Vehicle
				<form name="f5" method="post" action="CreateVehicleServlet" onsubmit="return validation();">
					<br>
					<table align="center">
						<tr>
							<td>Name</td>
							<td><input name="name" type="text"></td>
						</tr>
						<tr>
							<td>Type</td>
							<td><select name="type">
									<option value="AC">AC</option>
									<option value="NON-AC">NON-AC</option>
							</select></td>

						</tr>
						<tr>
							<td>Registration Number</td>
							<td><input name="rnumber" type="text"></td>
						</tr>
						<tr>
							<td>Seating Capacity</td>
							<td>
		
							<select name="capacity" >
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
							<td>Fare per Km.</td>
							<td><input name="fpkm" type="text" value="(Rs.)" type="text"
								style="color: #888;" onfocus="inputFocus(this)"
								onblur="inputBlur(this)"></td>

						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit"
								value="Register Vehicle"></td>
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