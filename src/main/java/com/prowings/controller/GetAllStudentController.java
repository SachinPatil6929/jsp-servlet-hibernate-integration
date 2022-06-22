package com.prowings.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.model.Student;
import com.prowings.service.StudentService;
import com.prowings.service.StudentServiceImpl;

public class GetAllStudentController extends HttpServlet {
StudentService service = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	List<Student> list = service.getAllStudent();
	PrintWriter out = resp.getWriter();
	if(list!=null)
	{
		ListIterator itr = list.listIterator();
		while(itr.hasNext())
		{
			out.println(itr.next());
		}
	}else {
		out.println("No Student record found");
	}
	}

}
