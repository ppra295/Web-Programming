<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>
</head>
<body>

<h3 style= "text-align: center;">Hello ${StudentName}, </h3>
<form action="Quiz" method="post">
<h2 style= "text-align: center;">
${currectQuestion.op1}
${currectQuestion.op}
${currectQuestion.op2}
=
</h2>


<input style= "margin-left: 600px ;" type="number" name="answer"><br/><br/>
<input style= "margin-left: 600px ;" type="submit" value="Submit Answer"><br/><br/>
</form></body>
</html>