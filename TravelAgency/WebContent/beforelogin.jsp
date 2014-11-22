<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Home</title>
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
	function validate() {
		var user = document.f1.uname.value;
		var password = document.f1.pass.value;

		if (user == "" || user.length == 0 || user == "First Name") {
			alert("Enter Username !!");
			return false;
		}
		if (password == "" || password.length == 0 || user == "First Name"
				|| password == "Password") {
			alert("Enter Password !!");
			return false;
		} else {
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
			<div id="bleft">
			
			
			
			<%
					
			String message="";
					
			
					if(!(session.getAttribute("UpdateStatus")).equals("None"))
					{
						message=(String)session.getAttribute("UpdateStatus");
					}

				%>
			
				<br> <br>
				<div style="color: #3D5C00">
				
					<h3><%=message  %>
					</h3>
				</div>
			
			
			
			
			
			
			
			
			
			
			
			
			</div>
			<div id="bright">
				<br> <br> <br>

				<table border="0" cellpadding="15" id="logintable">
					<tr>
						<td>
							<form method="post" action="LoginServlet" name="f1" onsubmit="return validate();">
								<table align="center" cellpadding="5" id="login">
									<tr>
										<td>Login</td>
									</tr>
									<tr>
										<td><input name="uname" value="First Name" type="text"
											style="color: #888;" onfocus="inputFocus(this)"
											onblur="inputBlur(this)"><br></td>
									</tr>
									<tr>
										<td><input name="pass" type="password" value="Password"
											style="color: #888;" onfocus="inputFocus(this)"
											onblur="inputBlur(this)"><br></td>
									</tr>
									<tr>
										<td>
											<table border="0">
												<tr>
													<td width="85px"></td>
													<td><input name="sub" type="submit" value="Login">
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>New User ? <a href="register.jsp"> Register Here
										</a></td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>
