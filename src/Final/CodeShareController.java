package Final;

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


@WebServlet("/CodeShareController")
public class CodeShareController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Connect to the database
		
		 ArrayList<Snippet> snippets = new ArrayList<Snippet>();
		 ArrayList<Snippet> snippets2 = new ArrayList<Snippet>();
		
		 Connection c = null;
		 if(request.getParameterMap().containsKey("id"))
		 {
			 int i=Integer.parseInt(request.getParameter("id"));
			 try
		        {
		            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu105";
		            String username = "cs3220stu105";
		            String password =  "ggUFWao5";

		            c = DriverManager.getConnection( url, username, password );
		            
		            
		         // Query the database for all cars
		            
		            String sql = "SELECT * FROM Snippers where id="+i;
		            
		               		
		            
		            Statement stmt = c.createStatement();           
		            ResultSet rs = stmt.executeQuery( sql );
		            
		         // Construct a collection of Car Objects
		           
		            		
		            while( rs.next() )
		            {
		            	int id = rs.getInt("id");
		            	String title = rs.getString("title");
		            	String description = rs.getString("description");
		            	String language = rs.getString("language");
		            	String codeSnippet = rs.getString("codeSnippet");
		            	
		            	snippets2.add( new Snippet(id, title, description, language, codeSnippet));
		                
		            }

		            // Attach the cars collection to the request scope for consumption by the view
		            
		            // Close the connection to the database
		            c.close();
		            
		            //Send car collection to a view for rendering
		            
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
			 
			 
		 }
		 
		 
				
		        try
		        {
		            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu105";
		            String username = "cs3220stu105";
		            String password =  "ggUFWao5";

		            c = DriverManager.getConnection( url, username, password );
		            
		            
		         // Query the database for all cars
		            
		            String sql = "SELECT * FROM Snippers order by language";
		            
		               		
		            
		            Statement stmt = c.createStatement();           
		            ResultSet rs = stmt.executeQuery( sql );
		            
		         // Construct a collection of Car Objects
		           
		            		
		            while( rs.next() )
		            {
		            	int id = rs.getInt("id");
		            	String title = rs.getString("title");
		            	String description = rs.getString("description");
		            	String language = rs.getString("language");
		            	String codeSnippet = rs.getString("codeSnippet");
		            	
		            	snippets.add( new Snippet(id, title, description, language, codeSnippet));
		                
		            }

		            
		            
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
		        
		     // Attach the cars collection to the request scope for consumption by the view
	            request.setAttribute("snippets", snippets);
	            request.setAttribute("snippets2", snippets2);
	            
		        
		        request.getRequestDispatcher("/WEB-INF/Final/CodeShareView.jsp")
            	.forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
