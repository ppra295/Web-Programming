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
 * Servlet implementation class AddCustomer
 */
@WebServlet("/Homework3/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

   private static int idSeed = 3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
        super();
    }
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            request.getRequestDispatcher( "../WEB-INF/Homework3/AddCustomer.jsp" ).forward(
    request, response );
        }

        @SuppressWarnings("unchecked")
        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {

        	
        	 String fname = request.getParameter( "fname" );
             String lname = request.getParameter( "lname" );
             String emailAddress = request.getParameter( "emailAddress" );
             
             boolean validFName = fname != null && fname.trim().length() > 0;
             boolean validLName = lname != null && lname.trim().length() > 0;
            
             boolean validEmailAddress = emailAddress != null && emailAddress.trim().length() > 0;
             
             if (validFName && validLName && validEmailAddress ){

            
             CustomerEntry entry = new CustomerEntry( idSeed++, fname, lname, emailAddress );
             
            List<CustomerEntry> entries = (List<CustomerEntry>) getServletContext().getAttribute("entries");
            entries.add( entry );

            
            request.getRequestDispatcher( "../WEB-INF/Homework3/Main.jsp" ).forward(request, response);
            
        }
             else{
                 
                 if (!validFName){
                     request.setAttribute("fnameError", "Please enter your First Name");
                 }else
                 if (!validLName){
                     request.setAttribute("lnameError", "Please enter your Last Name");
                 }else
                 if(!validEmailAddress){
                     request.setAttribute("emailAddressError", "Please enter your Email Address");
                 }
                 
                 doGet(request, response);
            }
        }

}
