package Mid;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/Mid/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todoDescription = request.getParameter("todoDescription");
		
		if (todoDescription != null && todoDescription.trim().length() > 0){
			ArrayList<Todo> listOfTodos = (ArrayList<Todo>) request.getSession().getAttribute("listOfTodos");
			listOfTodos.add( new Todo(todoDescription) );
		}
		
		response.sendRedirect("MainController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
