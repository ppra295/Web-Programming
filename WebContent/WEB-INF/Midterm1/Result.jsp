<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<h1 style= "text-align: center;">Hello ${currentStudent.name}  </h1>
		<h2><p style= "text-align: center;">${currectQuestion.op1} ${currectQuestion.op} ${currectQuestion.op2} : ${currectQuestion.currectAnswer} </p>
		<p style= "text-align: center;">${param.answer} which is ${result} </p> </h2>
		<p style= "text-align: center;"><a href="Quiz">Next</a>
		<a  href="Leaderboard">Leaderboard</a></p>
</body>
</html>