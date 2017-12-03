package Homework3;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.CustomerEntry;

@WebServlet("/Homework3/EditCustomer")
public class EditCustomer extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditCustomer()
    {
        super();
    }

    /**
     * Given an id, retrieve the GuestBookEntry.
     */
    @SuppressWarnings("unchecked")
    private CustomerEntry getEntry( Integer id )
    {
        List<CustomerEntry> entries = (List<CustomerEntry>) getServletContext().getAttribute(
            "entries" );

        for( CustomerEntry entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        CustomerEntry entry = getEntry( id );

        // pass the entry to jsp using request scope
        request.setAttribute( "entry", entry );
        request.getRequestDispatcher( "../WEB-INF/Homework3/EditCustomer.jsp" ).forward(
            request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        CustomerEntry entry = getEntry( id );

        // change the entry based on user input
        entry.setFname( request.getParameter( "fname" ) );
        entry.setLname( request.getParameter( "lname" ) );
        entry.setEmailAddress( request.getParameter("emailAddress"));

        // send the user back to the guest book page
        response.sendRedirect( "../Homework3/Main" );
    }

}

