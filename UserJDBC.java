package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import model.Student;

public class UserJDBC 
{
public String jdbcURL="jdbc:mysql://localhost:3306/Student?useSSl=false";
public  String jdbcUserName="root";
public String passWord="root123";

private static  String SELECT_ALL_STUDENTS="select * from Student";
private static  String INSERT_STUDENT="insert into Student(STUDENT_NAME,STUDENT_DOB,STUDENT_DOJ) values"+"(?,?,?)";
private static  String DELETE_STUDENT = "delete from Student where STUDENT_NO = ?";

protected Connection getConnection()
{
	Connection connection=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(jdbcURL,jdbcUserName,passWord);
	} catch (ClassNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
}

//insert into student table

public void insertUser(Student student) throws SQLException
{
	try(Connection connection=getConnection();
			PreparedStatement preparestatement=connection.prepareStatement(INSERT_STUDENT);)
	{
		preparestatement.setString(1, student.getName());
		preparestatement.setString(2, student.getDob());
		preparestatement.setString(3, student.getDoj());
		preparestatement.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

// SELECT ALL STUDENT
public List<Student> selectAllUser()
{
	List<Student> students = new ArrayList<>();
	//1.establish connection
	try(Connection connection=getConnection();
			//2.create statement
			PreparedStatement preparestatement=connection.prepareStatement(SELECT_ALL_STUDENTS);)
	{
	//3. execute or update query
		ResultSet rs=preparestatement.executeQuery();
		
		// 4. process the result object
		while(rs.next())
		{
			int id=rs.getInt("STUDENT_NO");
			String name=rs.getString("STUDENT_NAME");
			String DOB=rs.getString("STUDENT_DOB");
			String DOJ=rs.getString("STUDENT_DOJ");
			students.add(new Student(id,name, DOB, DOJ));
			
//			System.out.print(id+""+name+""+DOB+""+DOJ);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return students;
}
//delete the Student
public boolean deleteUser(int studentNo) throws SQLException 
{
	boolean rowDeleted;
	try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);) {
		statement.setInt(1,studentNo);
		rowDeleted = statement.executeUpdate() > 0;
	}
	return rowDeleted;
}
	
}

