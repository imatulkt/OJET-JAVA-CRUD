package com.ofss.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofss.student.dao.StudentDAO;
import com.ofss.student.model.Student;
import com.ofss.student.util.ActionMessage;
import com.ofss.student.util.JSONConverter;

/**
 * Servlet implementation class GetStudentController
 */
public class GetStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.setHeader("Access-Control-Allow-Max-Age", "1728000");
		
		
		System.out.println(new String(request.getParameter("sstudentId")));
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.findStudentByStudentId(request.getParameter("sstudentId"));
		System.out.println(student.getStudentName());
		ActionMessage success = new ActionMessage();
		success.setMessage("Recorded added");
		
		out.println(JSONConverter.convert(student));
		out.close();
	}

}
