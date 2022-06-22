package com.prowings.dao;

import java.util.List;

import com.prowings.entities.StudentEntity;

public interface StudentDao {

	public boolean createStudent(StudentEntity std);
	
	public StudentEntity getStudentByRoll(int roll);
	
	public List<StudentEntity> getAllStudents();
	
	public boolean updateStudent( StudentEntity std,int roll);
	
	public boolean deleteStudent(int roll);

}
