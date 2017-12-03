package Lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Lab4/Members")
public class Members extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Wel Come!</title></head>" );
        out.println( "<body>" );
        out.println( "<h1>Wel Come! Hello," );
        out.println(session.getAttribute("username"));
//        out.println( "<h1>Hello! Welcome in page!</h1>" );
        out.println( "</h1><a href='Logout'>Logout</a>" );
        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}