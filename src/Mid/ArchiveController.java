package Mid;


import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ArchiveController
 */
@WebServlet("/Midterm/ArchiveController")
public class ArchiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Todo> oldListOfTodos = (ArrayList<Todo>) request.getSession().getAttribute("listOfTodos");
		ArrayList<Todo> newListOfTodos = new ArrayList<Todo>();
		
		for( Todo todo : oldListOfTodos){
			if (!todo.isDone())
				newListOfTodos.add(todo);
		}
		
		getServletContext().setAttribute("listOfTodos", newListOfTodos);
		
		response.sendRedirect("MainController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
