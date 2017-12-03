<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Code Share</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.11.0/styles/qtcreator_dark.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.11.0/styles/qtcreator_dark.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.11.0/highlight.min.js"></script>
  
	<script>hljs.initHighlightingOnLoad();</script>
</head>

<body>
    <div class="container">
        <div class="page-header">
            <h1>Code Share
                <small>Sharing code snippets made simple.</small>
            </h1>
        </div>
        <div class="row">
            <div class="col-xs-3">
                <h3> Snippets
                   <span class="pull-right"> 
                   <a  href="NewSnippetController" class="btn btn-success">  <span class="glyphicon glyphicon-plus-sign"></span></a>
                   </span> 
                </h3>
                <hr>


                <!-- The list of all Snippets -->
                
                <c:forEach items="${snippets}" var="entry">
                <div class="list-group">

                    <!-- You will want to use this block of code repeatedly to display your list of Snippets -->
                    <a href="CodeShareController?id=${entry.id }" class="list-group-item active">
                        <h4 class="list-group-item-heading"> ${entry.title}</h4>
                        <p class="list-group-item-text lead">  ${entry.language}</p>
                        <p class="list-group-item-text">${entry.description}</p>
                    </a>

                </div>
                </c:forEach>

            </div>
           <c:if test="${fn:length(snippets2) > 0}"> 
          
              <c:forEach items="${snippets2}" var="ent">
            <div class="col-xs-9">
                    <h3>
                        <span class="pull-right">
                        <a href="DeleteSnippetController?id=${ent.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>
                        </span>
                        <small>Snippet:</small> ${ent.title}
                        <small>Language:</small> ${ent.language}
                    </h3>
                    <hr>

                 <textarea rows='10' cols='120' class="HTML"> ${ent.codeSnippet}</textarea>
            </div>
            </c:forEach>
        </div>
      
        </c:if>
        
        
         <c:if test="${fn:length(snippets2)==0}"> 
         
         <div class="col-xs-9">
			
				<div class="well">
				<p class="text-center">Create a new Snippet by clicking the
					<a href="NewSnippetController" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span></a>
					
				</p> 
				</div>
			
						
		  </div>
         
         
         </c:if>
    </div>
</body>

</html>