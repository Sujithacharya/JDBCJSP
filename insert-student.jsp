<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="insert" method="post">
       
       
        <table border="1">
            <caption>
            	<h2>Add New User</h2>
            </caption>
        		
        			 
            <tr>
                <th>Student Name: </th>
                <td>
                	<input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student DOB: </th>
                <td>
                	<input type="text" name="dob" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student DOJ: </th>
                <td>
                	<input type="text" name="doj" size="45"/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
    </form>
</body>
</html>