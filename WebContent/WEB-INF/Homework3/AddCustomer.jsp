<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Customer</title>
</head>
<body>
<h1 Style = "text-align: center;">Add Customer Details</h1><br/>
<form action="../Homework3/AddCustomer" method="post">
 
 <c:if test="${not empty fnameError}">
        <p style="color: red;">${fnameError}</p>
    </c:if>
    
    First Name: <input type="text" name="fname" value="${param.fname}" /> <br />
     <br/>
    
     <c:if test="${not empty lnameError}">
        <p style="color: red;">${lnameError}</p>
    </c:if>
    
    Last Name: <input type="text" name="lname" value="${param.lname}" /> <br />
     <br/>
     <c:if test="${not empty emailAddressError}">
        <p style="color: red;">${emailAddressError}</p>
    </c:if>
    
   Email Address: <input type="text" name="emailAddress" value="${param.emailAddress}" /> <br />
   
     <br/>
    <input type="submit" name="add" value="Add" />
</form>
</body>
</html>