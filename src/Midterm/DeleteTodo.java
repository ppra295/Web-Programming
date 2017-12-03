package Midterm;

import java.io.IOException;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class DeleteTodo
 */
@WebServlet("/midterm/DeleteTodo")
public class DeleteTodo extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTodo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    int id=0;
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  Integer id = Integer.valueOf( request.getParameter( "id" ) );
        String description = request.getParameter("description");
        List<Todo> todoList = (List<Todo>) getServletContext().getAttribute("todoList");
   
         for( Todo list : todoList )
            
          if(list.getId()==( id )){
           todoList.remove( list );
                 break;
             }
         response.sendRedirect( "ToDoServlet" );
     }
 
 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(request, response);
 }
}