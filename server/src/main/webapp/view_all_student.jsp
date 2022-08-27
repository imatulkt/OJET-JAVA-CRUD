<%@page import="com.ofss.student.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="1" width="500" align="center">
		<tr bgcolor="00FF7F">
			<th><b>Student ID</b></th>
			<th><b>Student Name</b></th>
			<th><b> Delete Action </b>
			
		</tr>

		<% ArrayList<Student> std = (ArrayList<Student>)request.getAttribute("students");
        for(Student s:std)
        {%>

		<tr>
		
			<td><%=s.getStudentId() %></td>
			<td><%=s.getStudentName() %></td>
			<td>
			<a href="deleteStudent?id=<%=s.getStudentId()%>">DELETE</a>
			

		</tr>

		<%}
            
        %>
	</table>
</body>
</html>