package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/DeleteSnippetController")
public class DeleteSnippetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteSnippetController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Connection c = null;
		try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu105";
            String username = "cs3220stu105";
            String password =  "ggUFWao5";

            c = DriverManager.getConnection( url, username, password );
            
            
         // Query the database for all cars
            
            String sql = "delete  from Snippers where id="+id;
            
               		
            
            PreparedStatement pstmt = (PreparedStatement) c.prepareStatement( sql );
	            pstmt.executeUpdate();
            
         // Construct a collection of Car Objects
           
            		
           
            
            // Close the connection to the database
            c.close();
            
            
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
		
		response.sendRedirect("CodeShareController");;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
