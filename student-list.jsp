<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>

<div>
    <div style="align-content: center;">
        <h3 style="text-align: center;">List Of Students</h3>
        <hr>
        <div style="align-content:center;">
             <a href="<%=request.getContextPath()%>/new">ADD NEW STUDENT</a>
        </div>
        <br>
        <table border="1" style="align-content: center;";>
             <thead>
                 <tr>
                     <th>ID</th>
                     <th>Name</th>
                     <th>DOB</th> 
                     <th>DOJ</th>
                 </tr>
             </thead>
             <tbody>
                 <c:forEach var="student" items="${students}">
                 <tr>
                      <td><c:out value="${student.getStudentNo()}"/></td>
                      <td><c:out value="${student.getName()}"/></td>
                      <td><c:out value="${student.getDob()}"/></td>
                      <td><c:out value="${student.getDoj()}"/></td>
                      <td><a href="delete?id=<c:out value='${student.getStudentNo()}' />">Delete</a></td>   
                 </tr>
                 </c:forEach>
             </tbody>
        </table>
        
    </div>
</div>

</body>
</html>
