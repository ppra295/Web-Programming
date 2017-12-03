<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Main</title>
</head>
<body>

<h1 style= "margin-left: 380px;">Customer Details</h1>
<form action="../Homework3/Search" method="post">
<input type="text" name="searchQuery" style= "margin-left: 380px;" placeholder="Enter a search" value="${param.searchQuery}" ></input>
<input type="submit" name="search" value="Search" ></input><br/><br />

</form>

 <table border="1" style= "margin-left: 300px;">
  <tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email Address</th><th>Operations</th></tr>
<c:forEach items="${entries}" var="entry">
  <tr>
    <td>${entry.id}</td>
    <td>${entry.fname}</td>
    <td>${entry.lname}</td>
    <td>${entry.emailAddress}</td>
    <td>
    <a href="../Homework3/EditCustomer?id=${entry.id}">Edit</a>
    <a href="../Homework3/DeleteCustomer?id=${entry.id}">Delete</a></td>
  </tr>
</c:forEach>  
</table>

<p><a href="../Homework3/AddCustomer" style= "margin-left: 450px;">Add Customer</a></p>


</body>
</html>