package com.prowings.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.model.Student;
import com.prowings.service.StudentService;
import com.prowings.service.StudentServiceImpl;

public class GetStudentController extends HttpServlet{
    StudentService service = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Student std = service.getStudentByRollNo(Integer.parseInt(req.getParameter("roll")));
	PrintWriter out = resp.getWriter();
	if( std!= null)
	{
		out.println("Student details are: " +"Id-"+ std.getId() +" Roll-"+ std.getRoll() +" Name-"+ std.getName()+" Address-"+ std.getAddress());
	}else {
		out.println("Unable to fetch Student record");
	}
	}

}
