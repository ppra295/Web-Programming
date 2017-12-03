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
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Midterm/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		if (name != null && name.trim().length() > 0){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("name", name);
			
			session.setAttribute("listOfTodos", new ArrayList<Todo>());
			
		}
		response.sendRedirect("MainController");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
