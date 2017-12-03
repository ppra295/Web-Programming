package Lab3;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab3/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Request Info </title>");
		out.println("<link rel='stylesheet' href='https://bootswatch.com/simplex/bootstrap.css'>");
		
		out.println("</head>");
		out.println("<boady>");
		out.println("<div class = \"container\">");
		out.println("<div class = \"jumbotron\">");
		out.println("<h1  align=\"center\">Request Parameters <small>Lab 3</small></h1>");
		out.println("<p align =\"center\">The following " +request.getMethod()+" request was submitted on " + new Date() + "</p>");
		out.println("<h3>Request Parameters<h3>");
		out.println("<table border='1' class='table table-bordered table-striped table-hover'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println(" <th>Parameter Name</th>");
        out.println("<th>Parameter Value</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
        String parameterName = parameterNames.nextElement();
        
        
        out.println("<tr>");
        out.println("<td>"+ parameterName +"</td>");
        out.println("<td>");
        for (String value:request.getParameterValues(parameterName) )
         out.println("<span class='label label-info'>"+ value + "</span>");
        out.println("</td>");
        out.println("</tr>");
        
      
        
        }
        
        out.println("</tbody>"); 
        out.println("</table>");

        
       
       
        String title = "Header Information";
	      out.println("<table border='1' class='table table-bordered table-striped table-hover'>");
	        out.println("<thead>");
	        out.println("<tr>");
	        out.println(" <th>Header Field</th>");
	        out.println("<th>Header Value</th>");
	        out.println("</tr>");

	        
	        Enumeration<String> headerNames = request.getHeaderNames();
	        while(headerNames.hasMoreElements()){
	            String headerName = headerNames.nextElement();
	        out.println("<tr>");
	        out.println("<td>" +headerName + "</td>");
	        out.println("<td><span class='label label-info'>"+request.getHeader(headerName) + "</span> </td>");
	        out.println("</tr>"); 
	        
	        
	        }
	        out.println("<tr>"); 
	        out.println("<td>connection</td>"); 
	        out.println("<td><span class='label label-info'>"+request.getHeader("Connection")+"</span> </td>"); 
	        out.println("</tr>"); 
	        out.println("<tr>");
	        out.println("<td>Context Path</td>");
	        out.println("<td><span class='label label-info'>"+request.getContextPath()+"</span> </td>");
	        out.println("</tr>"); 
	        out.println("<tr>"); 
	        out.println("<td>user-agent</td>");
	        out.println("<td><span class='label label-info'>"+request.getHeader("user-agent")+"</span> </td>");
	        out.println("<tr>"); 
	        out.println("<td>accept</td>"); 
	        out.println("<td><span class='label label-info'>"+request.getHeader("accept")+"</span> </td>"); 
	        out.println("</tr>"); 
	        out.println("<tr>"); 
	        out.println("<td>accept-encoding</td>"); 
	        out.println("<td><span class='label label-info'>"+request.getHeader("accept-encoding")+"</span> </td>"); 
	        out.println("</tr>");
	        out.println("<tr>"); 
	        out.println("<td>accept-language</td>"); 
	        out.println("<td><span class='label label-info'>"+request.getHeader("accept-language")+"</span> </td>"); 
	        out.println("</tr>");
	        out.println("</tbody>");
	        out.println("</table>");
	        out.println("</div>");
	        out.println("</boady>");
	        out.println("</html>");
	        
	        
	        
	}
	
			
	     


	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}