package Homework3;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerEntry;

/**
 * Servlet implementation class DeleteCustomer
 */
@WebServlet("/Homework3/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
    private CustomerEntry removeEntry( Integer id )
    {
        List<CustomerEntry> entries = (List<CustomerEntry>) getServletContext().getAttribute("entries" );

        for( CustomerEntry entry : entries )
            if( entry.getId().equals( id ) ) {
            	entries.remove(entry);
            	break;
            }
        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 removeEntry(Integer.valueOf(request.getParameter("id")));
		 request.getRequestDispatcher( "../WEB-INF/Homework3/Main.jsp" ).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
