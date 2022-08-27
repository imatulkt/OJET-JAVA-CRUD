package com.ofss.student.controller;

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

/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.setHeader("Access-Control-Allow-Max-Age", "1728000");
		
		
		System.out.println(new String(request.getParameter("studentIdForDelete")));
		
		String studentId = request.getParameter("studentIdForDelete");
		if (studentId != "") {
			StudentDAO studentDAO = new StudentDAO();
			studentDAO.deleteStudentById(studentId);
		}
		
		
		ActionMessage success = new ActionMessage();
		success.setMessage("Recorded deleted successfully!");
		
		out.println(JSONConverter.convert(success));
		out.close();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		System.out.println(request.getParameter("id"));
		String studentId = request.getParameter("id");
		if (studentId != "") {
			StudentDAO studentDAO = new StudentDAO();
			studentDAO.deleteStudentById(studentId);
		}
		
		ActionMessage success = new ActionMessage();
		success.setMessage("Recorded delete");
		out.println(JSONConverter.convert(success));
		out.close();
		
		//RequestDispatcher rd = request.getRequestDispatcher("temp.jsp");
		//rd.forward(request, response);
		
	}

	

}
