<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Forgot Password</title>
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
			<div id="bleft"></div>
			<div id="bright">
			<H2>Forgot Password Page</H2>
			
<form name="forgot Form" method="POST" action="ForgotPasswordServlet">

<br>
					<table>
						<tr>
							<td>Enter userid</td>
							<td><input type="text" name="userid"></td>
						</tr>
						<tr>
							<td>What is ur favourite color?</td>
							<td><input type="text" name="ans"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="SUBMIT"></td>
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
