package Midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Midterm/Main")
public class Name extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<Model> students = new ArrayList<Model>();
		getServletContext().setAttribute("students", students);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/Midterm1/Name.jsp" ).forward(request, response );
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String StudentName = request.getParameter("StudentName");
		HttpSession session = request.getSession();
	    session.setAttribute("StudentName", StudentName);
//		
		if (StudentName == null || StudentName.trim().length() == 0) {
			
			doGet(request, response);
		} 
		else {
			 Model currentStudent = null;
			ArrayList<Model> students = (ArrayList<Model>)getServletContext().getAttribute("students");
			for(Model student : students){
				if(student.getName().matches(StudentName)){
					currentStudent = student;
					break;
				}
			}
			if(currentStudent == null){
				currentStudent = new Model(StudentName);
				students.add(currentStudent);
			}
			
			request.getSession().setAttribute("currentStudent", currentStudent);
			request.getRequestDispatcher("../Midterm/Quiz").forward(request, response );
		}

		
		

}
}
