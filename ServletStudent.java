package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.UserJDBC;
import model.Student;

/**
 * Servlet implementation class ServletStudent
 */
@WebServlet("/")
public class ServletStudent extends HttpServlet 
{
//	private static final long serialVersionUID = 1L;
	private UserJDBC userjdbc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStudent() {
      this.userjdbc=new UserJDBC();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getServletPath();
		switch(action)
		{
		case "/insert" :
			try 
			{
				insertUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/new" :
			showNewForm(request, response);
			break;
			default:
			try {
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
		ArrayList<Student> students=userjdbc.selectAllUser();
		request.setAttribute("students",students);
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("student-list.jsp");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
			RequestDispatcher requestDispater=request.getRequestDispatcher("student-form.jsp");
			requestDispater.forward(request, response);
		
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
    {
	String name=request.getParameter("name");
	String dob=request.getParameter("dob");
	String doj=request.getParameter("doj");
	Student newSt=new Student(name,dob,doj);
	userjdbc.insertUser(newSt);
	response.sendRedirect("ArrayList");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		this.doGet(request, response);
	}

}
