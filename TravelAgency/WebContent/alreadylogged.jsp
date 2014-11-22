<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Already Logged</title>
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
		

			
				<div style="color: #3D5C00">
													
							<br><br><br>
							<h1>User <%=session.getAttribute("userid") %> was already logged in.</h1>	
					
						<%session.invalidate(); %>
						You Have Been Logged out.
					<h2>	Please <a href="index.jsp">Login </a> Again to Continue...</h2>
								 <br>

					</div>		
			
			
			
			</div>
			<div id="footer">
				<%@ include file="footer.jsp"%>
			</div>
		</div>
		
</body>
</html>
