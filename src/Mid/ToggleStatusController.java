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
@WebServlet("/Midterm/ToggleStatusController")
public class ToggleStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Todo getTodo(HttpServletRequest request, Integer id){
		
		ArrayList<Todo> listOfTodos = (ArrayList<Todo>) request.getSession().getAttribute("listOfTodos");
		
		for (Todo todo : listOfTodos){
			if ( id.equals( todo.getId() ))
				return todo;
		}
		
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Find the Todo with the id that matches the id that was passed in
		Todo todo = getTodo(request, Integer.valueOf( request.getParameter("id")));
		
		if (todo != null)
			todo.setDone( !todo.isDone() );
		
		response.sendRedirect("MainController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
















