package com.ofss.student.controller;


import java.util.List;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofss.student.dao.StudentDAO;
import com.ofss.student.model.Student;
import com.ofss.student.util.ActionMessage;
import com.ofss.student.util.JSONConverter;


public class GetAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetAllStudents() {
        super();
        
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.setHeader("Access-Control-Allow-Max-Age", "1728000");
		
		
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> students = studentDAO.findAllStudents();
		out.println(JSONConverter.convert(students));
		out.close();
	}
    
    
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> students = studentDAO.findAllStudents();
		
		
		out.println(JSONConverter.convert(students));
		out.close();
		
		//request.setAttribute("students", students);
		//RequestDispatcher rd = request.getRequestDispatcher("view_all_student.jsp");
		//rd.forward(request, response);
	}

	
	

}
