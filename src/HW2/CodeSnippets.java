package HW2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeSnippets
 */
@WebServlet("/HW2/CodeSnippets")
public class CodeSnippets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<CodeSnippet> snippets = new ArrayList<CodeSnippet>();
		
		

		getServletContext().setAttribute("snippets", snippets);
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CodeSnippet> snippets = (List<CodeSnippet>) getServletContext().getAttribute("snippets");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("    <head>");
		out.println("    <title></title>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"");
		out.println("    crossorigin=\"anonymous\">");
		out.println("    </head>");
		out.println("    <body>");
		out.println("   <div class=\"container\">");
		out.println("       <div class=\"page-header\">");
		out.println("            <h1>Code Snippets</h1>");
		out.println("        </div>");
		out.println("        <div class=\"row\">");
		out.println("<div class=\"col-xs-3\">");
		out.println("  <div class=\"page-header\">");
		out.println(" <h3>");
		out.println(" Snippets");
		out.println(" </h3>");
		
		out.println(" <a class=\"btn btn-primary\" href=\"AddSnippet\">Add Snippet</a>");
		
		
		out.println(" </div>");
	//	ArrayList<CodeSnippet> snippets = (ArrayList<CodeSnippet>) this.getServletContext().getAttribute("snippets");
		
		 
		for(CodeSnippet snippet : snippets){
			
			out.println("<ul>");
		 out.println( "<li>");
		 out.println(" <a href=\"CodeSnippets?id="+ snippet.getId()+"\">" + snippet.getTitle() +"</a><br>");
		 
		out.println("("+snippet.getLanguages()+")");
		out.println("</li>");
		out.println("</ul>");
		
		
		
}
	
	if(request.getParameter("id") != null)
	{ 
		CodeSnippet sni = null;

		Integer id=Integer.parseInt(request.getParameter("id"));
		
		for(CodeSnippet c : snippets){
			if(c.getId() == id){
				sni = c;
				break;
			}
		}
		
		out.println(" </div>");
		out.println(" <div class=\"col-xs-9\">");
		out.println("                <div class=\"page-header\">");
		out.println("                    <h3>"+sni.getTitle()+       "<small>"+sni.getLanguages()+"</small></h3>");
		out.println("                    <p class=\"pull-right\">");
		out.println("                        <a href='DeleteSnippet?id="+id+"'>Delete</a>");
		out.println("                        <a href='EditSnippet?id="+id+"'>Edit</a>");
		out.println("                    </p>");
		out.println("                </div>"); 
		out.println("                <div class=\"well\">");
		out.println(sni.getCode());
		out.println("                </div>");
		
		}
		
		out.println("            </div>");
		out.println("        </div>");
		out.println("            </div>");
		out.println("</body>");
		out.println("</html>");
//    out.println("</div>");	
//		
//	out.println("<div class=\"col-xs-9\">");
//
//	out.println("<div class=\"page-header\">");
//
//	out.println("<h3> "+snippets.get(id).getTitle()  + "<small > " +snippets.get(id).getLanguages() + "</small></h3>");
//
//	out.println(" <p class=\"pull-right\">");
//	out.println(" <a href=\"DeleteSnippet?id="+id+"\">Delete</a>");
//	  out.println(" <a href=\"EditSnippet?id="+id+"\">Edit</a>");
//
//	out.println(" </p>");
//	out.println("</div>");
//	out.println("<div class=\"well\">");
//	out.println("  <br/>");
//	out.println( snippets.get(id).getCode());
//	
//	out.println("              </div>");
//	
//	
//	out.println(" </div>");
//	}
//	
//	out.println("              </div>");
//	out.println(" </div>");
//	out.println("    </div>");
//	out.println("</body>");
//	out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
