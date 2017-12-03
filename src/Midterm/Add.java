package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import models.CustomerEntry;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Add
 */
@WebServlet("/Midterm/Add")
public class Add extends HttpServlet {
	
		 private static final long serialVersionUID = 1L;
		 
		 public void init( ServletConfig config ) throws ServletException
		    {
		        super.init( config );
		        List<Todo> todoList = new ArrayList<Todo>();
		        getServletContext().setAttribute( "todoList", todoList );
		    }
		       
		 private static int idSeed = 3;
		 @SuppressWarnings("unchecked")
		 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
 List<Todo>todoList = (List<Todo>)getServletContext().getAttribute("todoList");
			 
			 int total=0;
			 int doneDescription =0;
			 int notdoneDescription =0;
			 	
			 for(int i=0;i<todoList.size();i++)
				{
					if(todoList.get(i).isDone()== false)
					{
						notdoneDescription++;
						
					}
					else
					{
						doneDescription++;
					}
				}

			 total=doneDescription + notdoneDescription;
		  
		  PrintWriter out = response.getWriter();
		  response.setContentType("text/html");
		  out.println("<!DOCTYPE html>");
		  out.println("<html lang=\"en\">");
		  out.println("<head>");
		  out.println("    <title>Midterm</title>");
		  out.println("    <meta charset=\"UTF-8\">");
		  out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		  out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		  out.println("</head>");
		  out.println("<body>");
		  out.println("<div class=\"container\">");
		  out.println("    <div class=\"page-header\">");
		  out.println("        <h1>Todo <small>CS3220 Midterm</small></h1>");
		  out.println("    </div>");
		  out.println("<div class=\"panel panel-default\">");
		  out.println("  <div class=\"panel-heading\">");
		  out.println("<p class=\"text-center\">There are no Todos in your list.</p>");
		  out.println("  </div>");
		  out.println("<div class=\"panel panel-default\">");
			 out.println("  <div class=\"panel-heading\">");
			 out.println("<ul class=\"nav nav-pills\">");
			 out.println("    <li class=\"active\"><a href=\"ToDos\"><span class=\"badge\"> "+total + " </span></a></li>");
			 out.println("    <li><a href=\"NotDone\">Not Done <span class=\"badge\"> "+notdoneDescription+"</span></a></li>");
			 out.println("    <li><a href=\"Add\">Done <span class=\"badge\"> " + doneDescription+ "</span></a></li>");
			 out.println("    <li><a href=\"ClearCompletedTodos\">Clear Completed</a></li>");
			 out.println("</ul>");
			 
			 

				for( Todo e : todoList )
				{
					if(e.isDone()){
						out.println("<div>");
						out.println("<span> <s>");
						out.println(e.getDescription());
						out.println("</s></span>");
						out.println("&nbsp");
						out.println("&nbsp");
						out.println("<span>");
						out.println("<a href='tick?id="+e.getId()+"'>  <span class='glyphicon glyphicon-ok' aria-hidden='true'></span></a>");
						out.println("</span>");
						out.println("&nbsp");
						out.println("&nbsp");
						out.println("<span>");
						out.println("<a href='remove?id="+e.getId()+"'>  <span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a>");
						out.println("</span>");

						out.println("</div>");

					}
					else{
						out.println("<div>");
						
						out.println("<span>");
						out.println(e.getDescription());
						out.println("</span>");
						out.println("&nbsp");
						out.println("&nbsp");
						out.println("<span>");
						out.println("<a href='tick?id="+e.getId()+"'>  <span class='glyphicon glyphicon-ok' aria-hidden='true'></span></a>");
						out.println("</span>");
						out.println("&nbsp");
						out.println("&nbsp");
						out.println("<span>");
						out.println("<a href='remove?id="+e.getId()+"'>  <span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a>");
						out.println("</span>");
					
						out.println("</div>");

					}
					
		            
		        }

				out.println("<br /><br/>");
				out.println("<form class=\"form-inline\" action=\"ToDos\" method=\"post\">");
				  out.println("<input class=\"form-control\"  type=\"text\" name=\"todo\" placeholder=\"Add a todo\">");
				  out.println("<input class=\"btn btn-primary\"  type=\"submit\" value=\"Add Todo\">");
				  out.println("</form>");
				  out.println("</div>");
				  out.println("</body>");
				  out.println("</html>");
		 }
	
		  
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // TODO Auto-generated method stub
	  doGet(request, response);
	  
	  
	  String description = request.getParameter( "description" );
	  boolean validDescription = description != null && description.trim().length() > 0;
	  
	  if (validDescription){

          
         // Todo todoLists = new Todo( idSeed++, description, validDescription );
          
          ArrayList<ToDos> todoList=  (ArrayList<ToDos>) getServletContext().getAttribute("todoList");
          
         
	  }
	 }
}
		 
	