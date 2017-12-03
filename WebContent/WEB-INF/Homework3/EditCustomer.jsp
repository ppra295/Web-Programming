<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>

<h1 Style = "text-align: center;"> Edit Customer Details</h1>
<form action="../Homework3/EditCustomer" method="post">


First Name: <input type="text" name="fname" value="${entry.fname}"/> <br />
<br/>
Last Name: <input type="text" name="lname" value="${entry.lname}"/> <br />
<br/>
Email Address: <input type="text" name="emailAddress" value="${entry.emailAddress}"/> <br />
<br/>
<input type="hidden" name="id" value="${entry.id}" />
<input type="submit" name="save" value="Save" />
</form>
</body>
</html>