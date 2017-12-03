package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Lab4User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Homework2/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Lab4User> registeredUsers = new ArrayList<Lab4User>();
		registeredUsers.add(new Lab4User("John Doe", "john", "abcd"));
		registeredUsers.add(new Lab4User("Mary Jane", "mary", "abcd"));
		registeredUsers.add(new Lab4User("Joe Boxer", "joe", "abcd"));

		getServletContext().setAttribute("registeredUsers", registeredUsers);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		response.sendRedirect("../Homework2/Register.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean hasError = false;
		PrintWriter out = response.getWriter();

		System.out.println("welcome");
		
		 String name = request.getParameter("fname"); 
		 String user = request.getParameter("username");
		 String pwd = request.getParameter("password");
		 String pwd1 = request.getParameter("password1");
		 String remember = request.getParameter("remember");
		 
		
		 
		 //full name validation
		    String firstName = null;
			String lastName = null;
			
			if (name!= null)
			{
				String[] tokens = name.trim().split(" ");
			
				if (tokens.length < 2){
					hasError = true;
					request.setAttribute("nameError", true);				
				}		
				else{
					
					firstName = tokens[0];
					lastName = tokens[1];
				}
			} 
			else
			{
				hasError = true;
				request.setAttribute("nameError", true);
			}
		 // userName validation
			
			if (user == null || user.trim().length() == 0){
				hasError = true;
				request.setAttribute("userError", true);			
			}
			
			// Password validation
			if (pwd == null || pwd1 == null || pwd.trim().length() == 0){
				hasError = true;
				request.setAttribute("passwordError", true);
			}
			
			if ( !pwd.equals(pwd1)){
				hasError = true;
				request.setAttribute("password1Error", true);
			}
		 
			
			if (hasError)
			{
				 request.setAttribute("name",name);
				 request.setAttribute("user",user);
				 request.setAttribute("pwd",pwd);
				 request.setAttribute("pwd1",pwd1);
				
				 request.getRequestDispatcher("../Homework2/minvalid.jsp?name="+name+"&user="+user+"&pwd="+pwd+"&pwd1="+pwd1).forward(request, response);
				
			}
			else
			{
		 
			 List<Lab4User> registeredUsersNew = (List<Lab4User>)getServletContext().getAttribute("registeredUsers");
			 registeredUsersNew.add(new Lab4User(name,user,pwd));
		 
			response.sendRedirect("../Lab4/login.html");
			}
		}

		
	}


