package jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import model.Student;

public class UserJDBC 
{
public String jdbcURL="jdbc:mysql://localhost:3306/Student";
public  String jdbcUserName="root";
public String passWord="root123";

private static  String SELECT_ALL_USER="select * from Student";
private static  String INSERT_STUDENT="insert into Student"+"(STUDENT_NAME,STUDENT_DOB,STUDENT_DOJ) values"+"(?,?,?);";

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
	} catch (SQLException e) {
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

public ArrayList<Student> selectAllUser()
{
 ArrayList<Student> students=new ArrayList<Student>();
	//1.establish connection
	try(Connection connection=getConnection();
			//2.create statement
			PreparedStatement preparestatement=connection.prepareStatement(SELECT_ALL_USER);)
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
			
			System.out.print(id+""+name+""+DOB+""+DOJ);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return students;
}

	
}

