package HW2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddSnippet
 */
@WebServlet("/HW2/AddSnippet")
public class AddSnippet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int id=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSnippet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		 
		out.println("<!DOCTYPE html\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title>Add Snippet</title>");

		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"AddSnippet\" method=\"post\" >");
		out.println("<div class=\"form-group\">");
		out.println("<h1>Add Snippet</h1>");
		out.println("          Title: <input type=\"text\" name=\"title\"  required placeholder=\"Enter you title\">");
		
		out.println("         <br /><br/>");
		out.println("         Languages:");
		out.println("          <select name=\"languages\" required placeholder=\"Enter you language\">");
		out.println("        <option value=\"\"></option>");
		out.println("        <option value=\"java\">java</option>");
		out.println("        <option value=\"html\">html</option>");
		out.println("        <option value=\"css\">css</option>");
		out.println("      </select>");
		out.println("       <br /><br/>");
		out.println("      Code: <br/> <textarea name=\"code\" required placeholder=\"Enter you code\"></textarea> ");
		out.println("         <br /><br/>");

		out.println("  <input type=\"submit\" value=\"Submit now\" style=\"float: center;\" />");
		out.println("</div>");
		out.println(" </form>");

		out.println("</body>");
		out.println("</html>");
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean hasError = false;
		String title = request.getParameter("title"); 
		 String language = request.getParameter("languages");
		 String code = request.getParameter("code");
		 
		
		
		if (title == null || title.trim().length() == 0) {
			 hasError = true;
			request.setAttribute("titleError", true);
		}
		if(	language == null || language.trim().length() == 0 ){
			 hasError = true;
			request.setAttribute("languageError", true);
		}
		if(code == null || code.trim().length() == 0){
			 hasError = true;
			request.setAttribute("codeError", true);
		}
			
			
		
		
	
	
	if (hasError)
	{
		 request.setAttribute("title",title);
		 request.setAttribute("language",language);
		 request.setAttribute("code",code);
	}
		else
		{
			
			ArrayList<CodeSnippet> snippets = (ArrayList<CodeSnippet>) getServletContext().getAttribute("snippets");
			snippets.add(new CodeSnippet(id++,title, language,code ) );
			
			response.sendRedirect("CodeSnippets");
		}
		
	}

}
