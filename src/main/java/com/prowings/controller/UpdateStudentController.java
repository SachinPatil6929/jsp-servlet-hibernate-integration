package com.prowings.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.model.Student;
import com.prowings.service.StudentService;
import com.prowings.service.StudentServiceImpl;

public class UpdateStudentController extends HttpServlet {
StudentService service = new StudentServiceImpl();
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		Student model = new Student();
		model.setRoll(Integer.parseInt(rq.getParameter("rollnum")));
		model.setName(rq.getParameter("name"));
		model.setAddress(rq.getParameter("address"));
		
		PrintWriter out = rp.getWriter();
		
		if(service.updateStudent(model, model.getRoll())) {
			System.out.println("Student record update succesfully.");
		}
		else {
			System.out.println("Student record not updated.");
		}
	}

}
