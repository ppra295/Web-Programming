package Midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;

@WebServlet("/Midterm/Quiz")
public class Quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("currentStudent")== null){
			response.sendRedirect("Main");
			return;
		}
		
		if (session.getAttribute("currectQuestion")== null){
			session.setAttribute("currectQuestion",new Bean());
	        request.getRequestDispatcher( "/WEB-INF/Midterm1/Quiz.jsp" ).forward(request, response );
	        System.out.println("Helllo");
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int answer;
		try{
			answer = Integer.parseInt(request.getParameter("answer"));
		}catch(Exception e){
			doGet(request,response);
			return;
		}
		
		HttpSession session = request.getSession();
		
        Model currentStudent = (Model) session.getAttribute("currentStudent");
		

		Bean currectQuestion = (Bean)session.getAttribute("currectQuestion");
	    request.setAttribute("currectQuestion", currectQuestion);
	
	    session.removeAttribute("currectQuestion");	
		
		if(currectQuestion.getCurrectAnswer()== answer){
			currentStudent.incrementCorrect();
			request.setAttribute("result", "Correct");
		}
		else{
			currentStudent.incrementInCorrect();
			request.setAttribute("result", "Incorrect");
		}
		
		 request.getRequestDispatcher( "/WEB-INF/Midterm1/Result.jsp" ).forward(request, response );
		
	}	

}
