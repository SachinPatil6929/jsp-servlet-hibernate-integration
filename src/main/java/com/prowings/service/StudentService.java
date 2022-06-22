package com.prowings.service;

import java.util.List;

import com.prowings.model.Student;

public interface StudentService {
	public boolean createStudent(Student std);
	
	public Student getStudentByRollNo(int roll);
	
	public List<Student> getAllStudent();
	
	public boolean updateStudent(Student std,int roll);
	
	public boolean deleteStudent(int roll);

}
