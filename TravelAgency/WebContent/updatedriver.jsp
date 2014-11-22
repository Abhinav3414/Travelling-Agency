<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"  import="com.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Update Driver Here</title>
<script type="text/javascript">
function validate()
{
	var a=document.f6.did.value;
	var b=document.f6.uname.value;
	var c=document.f6.ustreet.value;
	var d=document.f6.ulocation.value;
	var e=document.f6.ucity.value;
	var f=document.f6.ustate.value;
	var g=document.f6.upincode.value;
	var h=document.f6.umno.value;
		var h=document.f6.ulno.value;
				
	if(a=="" || a.lenght==0)
	{
		alert("Enter Driver ID!!");
		return false;
	}
	if(b=="")
	{
		alert("Enter Name !!");
		return false;
	}
	if(c=="")
	{
		alert("Enter Street!!");
		return false;
	}
	if(d=="")
	{
		alert("Enter Location !!");
		return false;
	}
	if(e=="")
	{
		alert("Enter City !!");
		return false;
	}
	if(f=="")
	{
		alert("Enter State !!");
		return false;
	}
	if(g=="")
	{
		alert("Enter Pincode !!");
		return false;
	}
		if(h=="")
	{
		alert("Enter Mobile !!");
		return false;
	}
		if(i=="")
	{
		alert("Enter License Number!!");
		return false;
	}
	if(isNaN(g) )
	{	
		alert("Enter only digits in Pin Code");
		return false;
	}
	if(g.length!=6 )
	{	
		alert("Enter 6 digits in Pin Code");
		return false;
	}
	if(isNaN(h) )
	{	
		alert("Enter only digits in Mobile No.");
		return false;
	}
	if(h.length!=10 )
	{	
		alert("Enter 10 digits in mobile number");
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
				else
				{
			%>
			<div id="bodyright">
				<%
					DriverBean dbean = new DriverBean();
					dbean = (DriverBean) session.getAttribute("updatedDriverBean");
				%>				
			Update <%=dbean.getName()%>'s Details
			
	<form name="f6" method="post" action="DriverUpdateServlet">
	<br>
		<table align="center">
			<tr>
				<td>Driver Id</td>
				<td><input name="did" type="text" readonly="readonly" value="<%=dbean.getDriverID()%>"></td>
			</tr>
			
			<tr>
				<td>Name</td>
				<td><input name="uname" type="text" value="<%=dbean.getName()%>"></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input name="ustreet" type="text" value="<%=dbean.getStreet()%>"></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input name="ulocation" type="text" value="<%=dbean.getLocation()%>"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input name="ucity" type="text" value="<%=dbean.getCity()%>"></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input name="ustate" type="text" value="<%=dbean.getState()%>"></td>
			</tr>
			<tr>
				<td>PinCode</td>
				<td><input name="upincode" type="text" value="<%=dbean.getPincode()%>"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input name="umno" type="text" value="<%=dbean.getMobileNo()%>"></td>
			</tr>
			<tr>
				<td>Licence Number</td>
				<td><input name="ulno" type="text" value="<%=dbean.getLicenseNumber()%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" type="submit" value="Update Driver">
				</td>
			</tr>
		</table>
		
	</form>
	
	<% }  %>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
		
	</div>
</body>
</html>