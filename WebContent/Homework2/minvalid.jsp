<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../CSS/Register.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="margin-top:40px">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> Sign in to continue</strong>
                    </div>
                    <div class="panel-body">
                       <form action="Register" method="post">
                            <fieldset>
                                <div class="row">
                                    <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                        <div class="form-group">
  <%
  	String n=request.getParameter("name");
  String n2=request.getParameter("user");
  String n3=request.getParameter("pwd");
  String n4=request.getParameter("pwd1");
  
  
	String fullName = request.getParameter("name") == null || request.getAttribute("nameError") != null 
						? "" 
						: request.getParameter("name");
  
		
%>
<%
		
//Do we display an error message?
		if (request.getAttribute("nameError") != null)
		{
%>
		 <label> <p style="color:#f00;">Please enter a valid Fullname</p> </label>
<%
		}
%>
	

                                       
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                </div>
                                       
<input type="text"  class="form-control" name="fname" value="<%out.print(fullName);%>" placeholder="Enter your Fullname" /> <br />

                                        </div>
                                        <div class="form-group">
<% 

		
		
		// If the 'fullName' parameter exists, let's use it as the default value
		// Otherwise, use the empty string
		String user1= request.getParameter("user")== null || request.getAttribute("userError") != null 
						? "" 
						: request.getParameter("user");
	// Do we display an error message?
		if (request.getAttribute("userError") != null)
		{
%>
		<label><p style="color:#f00;">Please enter a valid Username</p></label>
<%
		}
%>
		
 
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-lock"></i>
                                                </span>
                                             <input type="text" class="form-control"  name="username" value="<%out.print(user1);%>" placeholder="Enter your Username" /> <br />
                                             
                                               </div>
                                        </div>
                                        
 <div class="form-group">
<% 

String pwd = request.getParameter("pwd") == null || request.getAttribute("passwordError") != null 
? "" 
: request.getParameter("pwd");

%>
<% 
		if (request.getAttribute("passwordError") != null)
		{
%>
		<label><p style='color:#f00;'>Please enter a valid Password</p> </label>
		
<%
		}
%>
		
 
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-lock"></i>
                                                </span>
                                           <input type="password" class="form-control"  name="password" value="<%out.print(pwd);%>" placeholder="Enter a password" /> <br />
                                               </div>
                                        </div>
<div class="form-group">
<% 

String pwd1 = request.getAttribute("password1Error") != null 
? "" 
: request.getParameter("pwd1");

%>
<% 
		if (request.getAttribute("password1Error") != null)
		{
%>
		<label><p style='color:#f00;'>Please enter a equal Password</p> </label>
		<%
		
		}
		%>
		
 
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-lock"></i>
                                                </span>
      <input type="password"  class="form-control" name="password1" value="<%out.print(pwd1);%>" placeholder="Enter the password again" /> <br />
                                             </div>
                                        </div>
                                      
                                        <div class="form-group">
                                            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Add User" /></div>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>