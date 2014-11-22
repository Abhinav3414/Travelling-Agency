<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="formstyle.css">
<title>Registered</title>
<script type="text/javascript">

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
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
			
			</div>
			<div id="bright">
				 <br> <br> <br>
<%

String tempid=(String)session.getAttribute("tempId");
%>
				<div style="color: #3D5C00">
					<h2>Your Login user id is</h2>
					<h1><%=tempid%></h1>
					<h2>&</h2>
					<h2>Password is</h2>
					<h1>password123</h1>


					Login with your username to change password
				</div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>