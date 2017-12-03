package Lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Lab4User;

@WebServlet("/Lab4/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Lab4User> registeredUsers = new ArrayList<Lab4User>();
		registeredUsers.add(new Lab4User("John Doe", "john", "abcd"));
		registeredUsers.add(new Lab4User("Mary Jane", "mary", "abcd"));
		registeredUsers.add(new Lab4User("Joe Boxer", "joe", "abcd"));

		getServletContext().setAttribute("registeredUsers", registeredUsers);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		String user = request.getParameter("username");
		String remember = request.getParameter("remember");
		String pwd = request.getParameter("password");

		List<Lab4User> registeredUsersNew = (List<Lab4User>) this.getServletContext().getAttribute("registeredUsers");
		HttpSession session = request.getSession();

		int counter = 0;
		for (int i = 0; i < registeredUsersNew.size(); i++) {

			if ((user.equals(registeredUsersNew.get(i).username)) && (pwd.equals(registeredUsersNew.get(i).password))) {

				session.setAttribute("username", user);
			
				counter++;
				
				if (remember != null) {
					Cookie loginCookie = new Cookie("username", user);
					loginCookie.setMaxAge(60 * 60 * 24);
					response.addCookie(loginCookie);

				}

				

			}
		}
		
		
		if(counter==0){
			request.getRequestDispatcher("Invalid.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("Members").forward(request, response);
		}
		
	}

	
}
