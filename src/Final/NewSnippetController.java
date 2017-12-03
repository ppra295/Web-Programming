package Final;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewSnippetController
 */
@WebServlet("/NewSnippetController")
public class NewSnippetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/WEB-INF/Final/NewSnippetView.jsp")
     	.forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String title = request.getParameter("title");
    	String description = request.getParameter("description");
    	String language = request.getParameter("language");
    	String codeSnippet = request.getParameter("codeSnippet");
        Connection c = null;
        try
        {
        	 String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu105";
	         String username = "cs3220stu105";
	         String password =  "ggUFWao5";


	         String sql = "Insert into Snippers (title,description,language,codeSnippet) values(?,?,?,?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, title );
            pstmt.setString( 2, description );
            pstmt.setString( 3, language );
            pstmt.setString( 4, codeSnippet );
            pstmt.executeUpdate();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        // send the user back to the guest book page
        response.sendRedirect( "CodeShareController" );
	}

}
