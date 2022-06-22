package com.prowings.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.service.StudentService;
import com.prowings.service.StudentServiceImpl;

public class DeleteStudentController extends HttpServlet {

StudentService service = new StudentServiceImpl();

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


PrintWriter out = resp.getWriter();
if(service.deleteStudent(Integer.parseInt(req.getParameter("roll"))))
{
	out.println("Student details are deleted for roll no: "+Integer.parseInt(req.getParameter("roll")));
}else {
	out.println("Unable to delete Student record");
}
}
}
