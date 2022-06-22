package com.prowings.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.model.Student;
import com.prowings.service.StudentService;
import com.prowings.service.StudentServiceImpl;

public class CreateStudentController extends HttpServlet {
	StudentService service = new StudentServiceImpl();
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		Student model = new Student();
		model.setName(req.getParameter("name"));
		model.setRoll(Integer.parseInt(req.getParameter("roll")));
		model.setAddress(req.getParameter("address"));
		PrintWriter out = resp.getWriter();
		if(service.createStudent(model))
			out.println("Student record created successfully");
		else
			out.println("Unable to create Student record");
		
	}

}
