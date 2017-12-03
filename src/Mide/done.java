package Mide;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.Counter;

import Midterm.Enter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Homework2.Entry;


@WebServlet("/Mide/done")
public class done extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Counter counter;
	
	
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        // create some test data for display
        List<Enter> list = new ArrayList<Enter>();
        

        // stored the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "list", list );
    }

       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Enter> list = (List<Enter>) getServletContext().getAttribute("list" );
		int done1=0,notdone1=0,total=0;

		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).isDone()==true)
			{
				done1++;
			}
			else
			{
				notdone1++;
			}
		}
		total=done1+notdone1;
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <title></title>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("    <!-- Latest compiled and minified CSS -->");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"");
		out.println("        crossorigin=\"anonymous\">");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("    <div class=\"container\">");
		out.println("        <div class=\"page-header\">");
		out.println("            <h1>TodoList Info</h1>");
		out.println("        </div>");
		
		out.println("<ul class=\"nav nav-pills\" role=\"tablist\">");
		out.println("		  <li role=\"presentation\" ><a href=\"todolist\">All <span class=\"badge\">"+total+"</span></a></li>");
		out.println("		  <li role=\"presentation\"><a href=\"notdone\">Not Done <span class=\"badge\">"+notdone1+"</span></a></li>");
		out.println("		  <li role=\"presentation\" class=\"active\"><a href=\"done\" >Done <span class=\"badge\">"+done1+"</span></a></li>");
		out.println("		  <li role=\"presentation\"><a href=\"clear\">Clear Completed <span class=\"badge\"></span></a></li>");
		out.println("		</ul>");
		
		for( Enter e : list )
		{
			if(e.isDone()){
				out.println("<div>");

				out.println("<span>");
				out.println("<s>");
				out.println(e.getInfo());
				out.println("</s>");
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
		out.println("<br /><br/>");
		
		
		
		
		out.println("<form action=\"todolist\" method=\"post\">");
		out.println("<input type=\"text\" name=\"info\" required placeholder=\"Enter your Info\">");
		out.println("<input type=\"submit\" value=\"Submit now\" style=\"float: center;\" />");
		
		out.println("        </div>");
		out.println("      </form>");
		out.println("</body>");
		out.println("</html>");
		
      
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
