package Homework3;
import models.CustomerEntry;
import java.io.IOException;
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
 * Servlet implementation class Main
 */
@WebServlet("/Homework3/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        // create some test data for display
        List<CustomerEntry> entries = new ArrayList<CustomerEntry>();
        entries.add( new CustomerEntry( 1, "Sonu","Prajapati", "Sonu@gmail.com" ) );
        entries.add( new CustomerEntry( 2, "Div","Swami", "Div@gmail.com" ) );

        // stored the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "entries", entries );
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "../WEB-INF/Homework3/Main.jsp" ).forward(
            request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	doGet(request,response);
    }
}
