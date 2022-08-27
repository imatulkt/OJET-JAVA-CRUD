package com.ofss.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofss.student.dao.StudentDAO;
import com.ofss.student.exceptions.ServerValidation;
import com.ofss.student.model.Student;
import com.ofss.student.util.JSONConverter;
import com.ofss.student.util.Response;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Response responseObj = new Response();
	StudentDAO studentDAO = new StudentDAO();
       
    
    public StudentController() {
        super();
        
    }
    
    // Request Param : {route:<Some String>,studentId:<Some Number>, studentName:<Some String>
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
	
		String route = request.getParameter("route");
		System.out.println(route);
	
		
		
		if(route.equals("AddUpdate")) {
			System.out.println("HERE INSIDE");
			String studentId = request.getParameter("studentId");
			String studentName = request.getParameter("studentName");
			addUpdateStudent(studentId,studentName);
			out.println(JSONConverter.convert(responseObj));
			out.close();
			
			
		}else if(route.equals("Delete")) {
			System.out.println("DELETING!");
			String studentId = request.getParameter("studentId");
			deleteStudent(studentId);
			out.println(JSONConverter.convert(responseObj));
			out.close();
			
			
			
			
		}else if(route.equals("GetById")) {
			System.out.println("Fetching By ID");
			String studentId = request.getParameter("studentId");
			System.out.println(studentId);
			Student student = studentDAO.findStudentByStudentId(studentId);
			System.out.println(student.getStudentName());
			out.println(JSONConverter.convert(student));
			out.close();
			
			
		}else if(route.equals("ViewAll")) {
			List<Student> students = studentDAO.findAllStudents();
			out.println(JSONConverter.convert(students));
			out.close();
			
			
		}
		
	}

	
	

	private void addUpdateStudent(String studentId, String studentName) {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentName(studentName);	
		studentDAO.addUpdateStudent(student);
		String successMessage = "Record with Id equal to " + studentId +" added.";
		responseObj.setSuccessMessage(successMessage);
		
	}

	private void deleteStudent(String studentId) {
		studentDAO.deleteStudentById(studentId);
		String successMessage = "Record with Id equal to " + studentId +" deleted.";
		responseObj.setSuccessMessage(successMessage);
		
		
	}
	
}
