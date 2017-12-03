package Mid;


import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Midterm/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create a local list of Todo Items
		ArrayList<Todo> listOfTodos = new ArrayList<Todo>();
		
		// Pre-populate my list with a few todos
		listOfTodos.add( new Todo("Make a todo list"));
		listOfTodos.add( new Todo("Add an item to my list"));
		listOfTodos.add( new Todo("Check an item off of my list"));
		
		Todo todo = new Todo("This item is done");
		todo.setDone(true);
		
		listOfTodos.add( todo );	
		
		// Add my list of todos to the application scope
		//getServletContext().setAttribute("listOfTodos", listOfTodos);
	}

	protected int numberOfTodosNotDone(ArrayList<Todo> listOfTodos){
		int count = 0;
		for(Todo todo : listOfTodos){
			if (!todo.isDone())
				count++;
		}
		return count;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		if (name == null){
			request.getRequestDispatcher("/WEB-INF/Midterm/Login.jsp").forward(request, response);
		}
		else{
			ArrayList<Todo> listOfTodos = (ArrayList<Todo>) session.getAttribute("listOfTodos");
			ArrayList<Todo> filteredListOfTodos = (ArrayList<Todo>) request.getAttribute("listOfTodos");
			
			if (filteredListOfTodos != null)
				request.setAttribute("numberOfTodosNotDone", numberOfTodosNotDone(filteredListOfTodos));
			else
				request.setAttribute("numberOfTodosNotDone", numberOfTodosNotDone(listOfTodos));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Midterm/Main.jsp");
			dispatcher.forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the list of ALL todos
		ArrayList<Todo> listOfTodos = (ArrayList<Todo>) getServletContext().getAttribute("listOfTodos");
		
		// This list contains all Todos that match the search query
		ArrayList<Todo> filteredListOfTodos = new ArrayList<Todo>();
		
		// Get the search query that the user submitted
		String searchQuery = request.getParameter("searchQuery");
		
		// Search all todos to see if their descriptions match the search query
		for (Todo todo : listOfTodos){
			// If the description contains the search query, add it to the filtered list
			if (todo.getDescription().toLowerCase().contains( searchQuery.toLowerCase() ))
				filteredListOfTodos.add( todo );
		}
		
		
		request.setAttribute("listOfTodos", filteredListOfTodos);

		doGet(request, response);
	}

}














