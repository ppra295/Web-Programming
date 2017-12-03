<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./Register" method="post">
<%
	String fullName = request.getParameter("fullName") == null || request.getAttribute("nameError") != null 
						? "" 
						: request.getParameter("fullName");
		
%>
<input type="text" name="fullName" value="<%out.print(fullName);%>" placeholder="Enter your name" /> <br />
<%
		
		// Do we display an error message?
		if (request.getAttribute("nameError") != null)
		{
%>
			<p style="color:#f00;">Please enter your full name</p>
<%
		}
		
		
		
		// If the 'fullName' parameter exists, let's use it as the default value
		// Otherwise, use the empty string
		String user = request.getParameter("user") == null || request.getAttribute("user") != null 
						? "" 
						: request.getParameter("user");
		
%>
<input type="text" name="email" value="<%out.print(user);%>" placeholder="Enter your email" /> <br />

<%
		// Do we display an error message?
		if (request.getAttribute("emailError") != null)
%>
		<p style="color:#f00;">Please enter a valid Email Address</p>
		
<% 

String pwd = request.getParameter("pwd") == null || request.getAttribute("passwordError") != null 
? "" 
: request.getParameter("pwd");

%>
<input type="password" name="password1" value="<%out.print(pwd);%>" placeholder="Enter a password" /> <br />
<% 
		if (request.getAttribute("passwordError") != null)
%>
		<p style='color:#f00;'>Please enter a valid Email Address</p> 
<input type="password" name="password2" placeholder="Enter the password again" /> <br />
<input type="submit" value="Add User" />

</form>
</body>
</html>