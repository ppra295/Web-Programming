<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Details</h1>
<form action="Leaderboard" method="post">
</form>

 <table border="1" ">
  <tr><th>Student Name</th>
  <th>#Total Question</th>
  <th>#Correct</th>
  <th>#InCorrect</th>
  <th>%correct</th></tr>
  <c:forEach items="${students}" var="student">
  <tr>
    <td>${student.name}</td>
    <td>${student.question}</td>
    <td>${student.correct}</td>
    <td>${student.incorrect}</td>
    <td>${student.correct/student.question * 100}</td>
    </tr>
   
</c:forEach>
</table>
</body>

</body>
</html>