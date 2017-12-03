package HW2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditSnippet
 */
@WebServlet("/HW2/EditSnippet")
public class EditSnippet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSnippet() {
        super();
        // TODO Auto-generated constructor stub
    }
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
    
    
    @SuppressWarnings("unchecked")
    private CodeSnippet getSnippet( Integer id )
    {
        List<CodeSnippet> snippets = (List<CodeSnippet>) getServletContext().getAttribute(
            "snippets" );
        for( CodeSnippet snippet : snippets )
            if(snippet.getId()==(id)) 
             //System.out.println(snippet);
             return snippet;
        return null;
    }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  
  // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        CodeSnippet snippet = getSnippet( id );
        // form display
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Edit Snippet</title></head><body>" );
        out.println( "<form action='EditSnippet' method='post'>" );
        
        out.println("<div class=\"form-group\">");
  out.println("<h1>Edit Snippet</h1>");
  out.println("          Title: <input type=\"text\"  name=\"title\""+ snippet.getTitle() +  ">");
  
  out.println("         <br /><br/>");
  out.println("         Languages:" );
  out.println("          <select name=\"languages\">");
  out.println("        <option value=\" " + snippet.getLanguages()+ " \"></option> ");
  out.println("        <option value=\"java\">java</option>");
  out.println("        <option value=\"html\">html</option>");
  out.println("        <option value=\"css\">css</option>");
  out.println("      </select>");
  out.println("       <br /><br/>");
  out.println("      Code: <br/> <textarea name=\"code\">" + snippet.getCode() + "</textarea> ");
  out.println("         <br /><br/>");
  
  
  out.println(" </form>");
       
        // hidden form field
        out.println( "<input type='hidden' name='id' value='" + id
            + "' /> <br />" );
        out.println( "<input type='submit' name='save' value='Save' /><br />" );
        out.println("</div>");
        out.println( "</form>" );
        out.println( "</body></html>" );
  
 }
 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
  // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        CodeSnippet snippet = getSnippet( id );
        // change the entry based on user input
        snippet.setTitle( request.getParameter( "title" ) );
        snippet.setLanguages( request.getParameter( "languages" ) );
        snippet.setCode( request.getParameter( "code" ) );
        // send the user back to the guest book page
        response.sendRedirect( "CodeSnippets" );
  
  
  //doGet(request, response);
 }
}