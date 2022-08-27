package com.ofss.student.exceptions;

public class ServerValidation {
	
	public void checkStudentId(String studentId) throws CustomException{
		int id = Integer.parseInt(studentId);
		if (id==0) {
			throw new CustomException("Student ID cannot be 0");
		}else if(!studentId.matches("[0-9]+")) {
			throw new CustomException("Student ID should only contain numbers");
			
			
		}
	}
	
	public void checkStudentName(String studentName) throws CustomException{
		if(!studentName.matches("[a-zA-Z]+") ) {
			throw new CustomException("Student Name cannot be empty and should only contain alphabets");
			
		}
	}

}
