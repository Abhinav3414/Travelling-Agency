<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Make Payment</title>
<script type="text/javascript">

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
function validte()
{
	var a1=document.f13.cno.value;
	var a2=document.f13.validfrom.value;
	var a3=document.f13.validto.value;
	var a4=document.f13.creditbal.value;
		
	if(a1==""||a1.length==0)
		{
		alert("Enter CreditCard Number !!");
		return false;
		}
	if(a2==""||a2.length==0||a2=="MM/YYYY")
	{
	alert("Enter valid From !!");
	return false;
	}
	if(a3==""||a3.length==0||a3=="MM/YYYY")
	{
	alert("Enter valid To !!");
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
			<%@ include file="subheaderuser.jsp"%>
		</div>
		<div id="body">
			<div id="bodyleft">
				<%@ include file="userbodyleft.jsp"%>
			</div>
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			
			%>
			<div id="bodyright">
				<%
					Double fare = (Double) session.getAttribute("sessionfare");
				%>
				<br>
				<br>
				<form name="f13" method="post" action="PaymentServlet"
					onsubmit="return validte();">
					<br>
					<table align="center">
						<tr>
							<td>Credit Card No.</td>
							<td><input name="cno" type="text" maxlength="16"></td>
						</tr>
						<tr>
							<td>Valid From</td>
							<td><select name="mm1" id="valid">
									<option value="01">Jan</option>
									<option value="02">Feb</option>
									<option value="03">Mar</option>
									<option value="04">Apr</option>
									<option value="05">May</option>
									<option value="06">Jun</option>
									<option value="07">Jul</option>
									<option value="08">Aug</option>
									<option value="09">Sep</option>
									<option value="10">Oct</option>
									<option value="11">Nov</option>
									<option value="12">Dec</option>
							</select> 
							<select name="yyyy1" id="valid">
									<option value="2000">2000</option>
									<option value="2001">2001</option>
									<option value="2002">2002</option>
									<option value="2003">2003</option>
									<option value="2004">2004</option>
									<option value="2005">2005</option>
									<option value="2006">2006</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
							</select></td>
						</tr>
						<tr>
							<td>Valid To</td>
							<td><select name="mm2" id="valid">
									<option value="01">Jan</option>
									<option value="02">Feb</option>
									<option value="03">Mar</option>
									<option value="04">Apr</option>
									<option value="05">May</option>
									<option value="06">Jun</option>
									<option value="07">Jul</option>
									<option value="08">Aug</option>
									<option value="09">Sep</option>
									<option value="10">Oct</option>
									<option value="11">Nov</option>
									<option value="12">Dec</option>
							</select> 
							<select name="yyyy2" id="valid">
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
									<option value="2024">2024</option>
									<option value="2025">2025</option>
									<option value="2026">2026</option>
									<option value="2027">2027</option>
									<option value="2028">2028</option>
									<option value="2029">2029</option>
							</select></td>
						</tr>
						<tr>
							<td>Credit Balance</td>
							<td><input name="creditbal" type="text" readonly="readonly"
								value="<%=fare%>"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit" value="Pay Now">
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