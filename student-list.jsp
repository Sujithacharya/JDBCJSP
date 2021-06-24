<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
    <div style="align-content: center;">
        <h3 style="text-align: center;">List Of Students</h3>
        <hr>
        <div style="align-content: center;background-color: blue;">
             <a href="<%=request.getContextPath()%>/new">ADD New STUDENT</a>
        </div>
        <br>
        <table style="align-content: center;">
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
                     <td><c:out value="${student.studentNo}"/></td>
                     <td><c:out value="${student.name}"/></td>
                      <td><c:out value="${student.dob}"/></td>
                       <td><c:out value="${student.doj}"/></td>
                     
                 </tr>
                 </c:forEach>
             </tbody>
        </table>
        
    </div>
</div>

</body>
</html>