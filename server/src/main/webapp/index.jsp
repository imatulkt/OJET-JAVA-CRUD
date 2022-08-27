<html>
<body>
<h2>Assignment!</h2>

	<form action="addStudent" method="post">
	
	Student ID : <input type="text" name="studentId"> 
	<br>
	Student Name: <input type="text" name="studentName">
	<br>
	<input type="submit">
	</form>
	
	<hr>

	<form action="getStudentById" method="get">
	Enter Student ID: <input type="text" name="studentIdForSearch">
	<input type="submit" value="Search">
	</form>

	<hr>
	
	<form action="getAllStudents" method="get">
	<input type="submit" value="View all Students">
	</form>

</body>
</html>
