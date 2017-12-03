<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset = "utf-8">
        <title> New Snippet Controller </title>
       <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->
        <link rel="stylesheet" href="snippets.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <div class="content">
            <div class="jumbotron">
                <h1>Code Share <small>Create a new snippet. </small></h1>
            </div>
            <nav class="navbar navbar-default">
                <div class="container">
                    <form action="NewSnippetController" class="form-horizontal" method="POST" >
                        <div class="form-group">
                        <br/>
                        <br/>
                        
                    <label name="name" class="col-sm-3 control-label" >Title:</label>
                    <div class="col-sm-9">
                        <input type="text" name="title"  placeholder = " Enter the title of your snippet" class="form-control" >
                    </div>
                </div>
                <div class="form-group">
                    <label name="description" class="col-sm-3 control-label">Description:</label>
                    <div class="col-sm-9">
                        <input type="description" placeholder = "What does your code do?" name="description" class="form-control">
                    </div>
                </div>
                
                <div class="form-group">
                    <label name="language:" class="col-sm-3 control-label">Language:</label>
                    <div class="col-sm-9">
                       <select name="language">
                            <option >Java</option>
                            <option >HTML</option>
                            <option>CSS</option>
                            <option >JavaScript</option>
                          </select>
                    </div>
                </div>
                
                <div class="form-group">
                    <label name="code Snippet" class="col-sm-3 control-label" >Code Snippet:</label>
                    <div class="col-sm-9">
                        <textarea name="codeSnippet"  placeholder = "Enter your code here"class="form-control"  ></textarea>
                    </div>
                </div>
                
                 <div class="align-center">
                     <div class="col-sx-8">
                         <button class="btn btn-primary btn-lg" name = submit type="submit" >Submit</button>
                         
                         </form>
                         
                     </div>
                 </div>
            
        </div>
        
        <a href="CodeShareController"><button class="btn btn-primary btn-lg">Cancle</button></a>
                
                
             </nav>
            
        </div>
    </body>
</html>