package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Midterm/todolist")
public class todolist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        List<Enter> list = new ArrayList<Enter>();
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
		out.println("		  <li role=\"presentation\" class=\"active\"><a href=\"todolist\">All <span class=\"badge\">"+total+"</span></a></li>");
		out.println("		  <li role=\"presentation\"><a href=\"notdone\">Not Done <span class=\"badge\">"+notdone1+"</span></a></li>");
		out.println("		  <li role=\"presentation\"><a href=\"done\">Done <span class=\"badge\">"+done1+"</span></a></li>");
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
			else{
				out.println("<div>");
				
				out.println("<span>");
				out.println(e.getInfo());
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
		String info = request.getParameter( "info" );
		
		if(info==null || info.trim().length()==0){
        	doGet(request, response);
        }
        
        else
        {
        	
        	
        	ArrayList<Enter> list= (ArrayList<Enter>) getServletContext().getAttribute("list");
        	list.add(new Enter(list.size(),info, false));
        	
            getServletContext().setAttribute( "list", list );

            response.sendRedirect( "todolist" );
        }
	}

}
