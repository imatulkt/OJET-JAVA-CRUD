
<%@page import="com.ofss.student.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Viewing students
	
	
	<%
	Student s1 = (Student)request.getAttribute("student");
	out.println(s1.getStudentName());
	%>

</body>
</html>