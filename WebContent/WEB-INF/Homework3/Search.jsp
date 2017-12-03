<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<form action="../Homework3/search" method="post">
<table border="1" style= "margin-left: 300px;">
  <tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email Address</th><th>Operations</th></tr>
  <c:set var="entry" value="id" scope="application" />
  <c:set var="entry" value="fname" scope="application" />
  <c:set var="entry" value="lname" scope="application" />
  <c:set var="entry" value="emailAddress" scope="application" />
 <c:forEach items="${entries}" var="entry" >
  <tr>
  
    <td><c:out value="${entry.id}"/></td>
    <td><c:out value="${entry.fname}"/></td>
    <td><c:out value="${entry.lname}"/></td>
    <td><c:out value="${entry.emailAddress}"/></td>
    <td>
    <a href="../Homework3/EditCustomer?id=${entry.id}">Edit</a>
    <a href="../Homework3/DeleteCustomer?id=${entry.id}">Delete</a></td>
  </tr>
</c:forEach> 
 
</table>
</form>
</body>
</html>