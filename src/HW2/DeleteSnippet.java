package HW2;

import java.io.IOException;
import java.util.List;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteSnippet
 */
@WebServlet("/HW2/DeleteSnippet")
public class DeleteSnippet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 
//	private CodeSnippet getEntry( Integer id )
//	    {
//	        List<CodeSnippet> snippets = (List<CodeSnippet>) getServletContext().getAttribute(
//	            "snippets" );
//
//	        for( CodeSnippet entry : snippets )
//	            if( entry.getId()==( id ) ) 
//	            	return entry;
//
//	        return null;
//	    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		int id = Integer.valueOf(request.getParameter("id"));
	    
		@SuppressWarnings("unchecked")
		List<CodeSnippet> snippets = (List<CodeSnippet>) getServletContext().getAttribute(
				"snippets");
        for( CodeSnippet snippet : snippets )
            if(snippet.getId()==( id ))
            {
            	snippets.remove( snippet );
                break;
            }

        response.sendRedirect( "CodeSnippets" );
    }
	    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);  
	}
}


