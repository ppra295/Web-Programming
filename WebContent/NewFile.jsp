<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function getComment()
{
  <% String locate=request.getParameter("locate"); %>
  var location = "<%= locate%>";
  document.getElementById('commentarea').value = location;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myForm" method="post">
        <textarea id="commentarea"></textarea>
        <input type="text" name="locate" value="parry">
        <input type="button" value="View Comment" onclick="getComment()">
    </form>




</body>
</html>