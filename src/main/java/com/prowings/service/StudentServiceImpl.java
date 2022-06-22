package com.prowings.service;

import java.util.List;

import com.prowings.dao.StudentDao;
import com.prowings.dao.StudentDaoImpl;
import com.prowings.model.Student;
import com.prowings.util.ModelToEntity;

public class StudentServiceImpl implements StudentService {
	StudentDao stdDao = new StudentDaoImpl();
	
	@Override
	public boolean createStudent(Student std) {		
		return stdDao.createStudent(ModelToEntity.convertToStudentEntity(std));
	}

	@Override
	public Student getStudentByRollNo(int roll) {
		return ModelToEntity.convertToStudentPOJO(stdDao.getStudentByRoll(roll));
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list =ModelToEntity.convertToStudentList(stdDao.getAllStudents());
		return list;
	}

	

	@Override
	public boolean deleteStudent(int roll) {
		return stdDao.deleteStudent(roll);
	}

	@Override
	public boolean updateStudent(Student std, int roll) {
		return stdDao.updateStudent(ModelToEntity.convertToStudentEntity(std), std.getRoll());
	}
	

}
