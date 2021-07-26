package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.UserJDBC;
import model.Student;

@WebServlet("/ServletStudent")
public class ServletStudent extends HttpServlet 
{
	private UserJDBC userjdbc;
    public ServletStudent()
    {
      this.userjdbc=new UserJDBC();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String action=request.getServletPath();
		switch(action)
		{
		case "/insert" :
			try 
			{
				insertStudent(request, response);
			} catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/new" :
			showNewForm(request, response);
			break;
		case "/delete" :
			try {
				deleteUser(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		default:
			try 
			{
				listUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		}
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws IOException,SQLException,ServletException 
	{
		// TODO Auto-generated method stub
	    List<Student> students=userjdbc.selectAllUser();
		request.setAttribute("students",students);
		request.getRequestDispatcher( "student-list.jsp").include( request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
			RequestDispatcher requestDispater=request.getRequestDispatcher("insert-student.jsp");
			requestDispater.forward(request, response);
	}
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
    {
	String name=request.getParameter("name");
	String dob=request.getParameter("dob");
	String doj=request.getParameter("doj");
	Student newSt=new Student(name,dob,doj);
	userjdbc.insertUser(newSt);
	response.sendRedirect("list");
    }
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int studentNo = Integer.parseInt(request.getParameter("id"));
		userjdbc.deleteUser(studentNo);
		response.sendRedirect("list");
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		this.doGet(request, response);
	}

}
