package com.ofss.student.controller;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import com.ofss.student.dao.*;
import com.ofss.student.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofss.student.dao.StudentDAO;
import com.ofss.student.exceptions.CustomException;
import com.ofss.student.exceptions.ServerValidation;
import com.ofss.student.model.Student;
import com.ofss.student.util.ActionMessage;
import com.ofss.student.util.JSONConverter;

/**
 * Servlet implementation class PostStudentController
 */
public class PostStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.setHeader("Access-Control-Allow-Max-Age", "1728000");
		
		
		StudentDAO studentDAO = new StudentDAO();

		
		
		ServerValidation obj = new ServerValidation();
		
		try {
			obj.checkStudentId(request.getParameter("studentId"));
			obj.checkStudentName(request.getParameter("studentName"));
			Student student = new Student();
			student.setStudentId(request.getParameter("studentId"));
			student.setStudentName(request.getParameter("studentName"));
			
			studentDAO.addUpdateStudent(student);
			
			ActionMessage success = new ActionMessage();
			success.setMessage("Recorded added");
			
			out.println(JSONConverter.convert(success));
			out.close();
			
		}catch(CustomException e) {
			String res = "Exception :" + e.getMessage();
			System.out.println("[" + e + "] Exception Occured");
			ActionMessage serveroutput = new ActionMessage();
			serveroutput.setMessage(res);
			
			out.println(JSONConverter.convert(serveroutput));
			out.close();
			
			
		}catch(Exception e) {
			String res = "Something went wrong! Try Again with correct input";
			ActionMessage serveroutput = new ActionMessage();
			serveroutput.setMessage(res);
			
			out.println(JSONConverter.convert(serveroutput));
			out.close();
		}
		
		
	}
	
}
