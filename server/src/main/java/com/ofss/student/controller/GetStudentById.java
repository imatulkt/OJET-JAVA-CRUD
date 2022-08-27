package com.ofss.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * Servlet implementation class GetStudentById
 */

import com.ofss.student.dao.*;
public class GetStudentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetStudentById() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.setHeader("Access-Control-Allow-Max-Age", "1728000");
		
		
		System.out.println(new String(request.getParameter("sstudentId")));
		
		ServerValidation obj = new ServerValidation();
		try {
			obj.checkStudentId(request.getParameter("sstudentId"));
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.findStudentByStudentId(request.getParameter("sstudentId"));
			System.out.println(student.getStudentName());
			ActionMessage success = new ActionMessage();
			success.setMessage("Recorded added");
			
			out.println(JSONConverter.convert(student));
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
    
    
    // IGNORE GET METHOD AS IT IS UNSAFE SECURITY WISE
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.setHeader("Access-Control-Allow-Max-Age", "1728000");
		
		System.out.println(new String(request.getParameter("studentIdForSearch")));
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.findStudentByStudentId(request.getParameter("studentIdForSearch"));
		System.out.println(student.getStudentName());
		
		//request.setAttribute("student", student);
		//RequestDispatcher rd = request.getRequestDispatcher("view_student.jsp");
		//rd.forward(request, response);
		
		out.println(JSONConverter.convert(student));
		out.close();
	}

	

	

}
