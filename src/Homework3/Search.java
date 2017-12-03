package Homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerEntry;


@WebServlet("/Homework3/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher( "../WEB-INF/Homework3/Search.jsp" ).forward(request, response );
	}

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  
        List<CustomerEntry> entries = (List<CustomerEntry>) getServletContext().getAttribute("entries");
        
        List<CustomerEntry> filteredListOfTodos = new ArrayList<CustomerEntry>();
        
        String searchQuery = request.getParameter("searchQuery");
        request.setAttribute("searchQuery", searchQuery);
            for (CustomerEntry entry : entries){
			
			// If the description contains the search query, add it to the filtered list
			if (entry.getFname().toLowerCase().contains( searchQuery.toLowerCase() ))
				filteredListOfTodos .add( entry ); 
			if (entry.getLname().toLowerCase().contains( searchQuery.toLowerCase() ))
				filteredListOfTodos .add( entry );
			if (entry.getEmailAddress().toLowerCase().contains( searchQuery.toLowerCase() ))
				filteredListOfTodos .add( entry );
		}

		doGet(request, response);
	}

}
