<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Register A Route</title>
<script type="text/javascript">


function inputFocus(i) {
	if (i.value == i.defaultValue) {
		i.value = "";
		i.style.color = "#000";
	}
}
function inputBlur(i) {
	if (i.value == "") {
		i.value = i.defaultValue;
		i.style.color = "#888";
	}
}

function validation()
{
	var a1=document.f7.source.value;
	var a2=document.f7.destination.value;
	var a3=document.f7.distance.value;
	var a4=document.f7.duration.value;
	if(a1="" || a1.length==0)
	{
	alert("Enter Source !!");
	return false;
	}
	if(a2="" || a2.length==0)
	{
	alert("Enter Destination !!");
	return false;
	}
	if(isNaN(a3))
	{
	alert("Enter digits in Distance !!");
	return false;
	}
	if(isNaN(a4))
	{
	alert("Enter digits in Duration !!");
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

				Register Route Details
				<form name="f7" method="post" action="CreateRouteServlet" onsubmit="return validation();">
					<br>
		<table align="center">
			<tr>
				<td>Source</td>
				<td><input name="source" type="text"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input name="destination" type="text"  ></td>
			</tr>
			<tr>
				<td>Distance(in Km.)</td>
				<td><input name="distance" type="text" value="in (Kms)"
											style="color: #888;" onfocus="inputFocus(this)"
											onblur="inputBlur(this)"></td>
			</tr>
			<tr>
				<td>Travel Duration</td>
				<td><input name="duration" type="text" value="in (hrs)" 
											style="color: #888;" onfocus="inputFocus(this)"
											onblur="inputBlur(this)"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input name="submit" type="submit" value="Register Route">
				</td>
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