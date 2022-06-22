package com.prowings.util;

import java.util.ArrayList;
import java.util.List;

import com.prowings.entities.StudentEntity;
import com.prowings.model.Student;

public class ModelToEntity {
	public static StudentEntity convertToStudentEntity(Student model) {
		StudentEntity entity = new StudentEntity();
		entity.setRoll(model.getRoll());
		entity.setName(model.getName());
		entity.setAddress(model.getAddress());
		return entity;
		
	}
	public static Student convertToStudentPOJO(StudentEntity entity)
	{
		Student model = new Student();
		
		model.setId(entity.getId());
		model.setRoll(entity.getRoll());
		model.setName(entity.getName());
		model.setAddress(entity.getAddress());
		
		return model;
	}
	
	
	public static List<Student>
    convertToStudentList(List<StudentEntity> entity)
    {
		List<Student> stdList=new ArrayList<Student>();
		for(StudentEntity s1 : entity)
		{
			Student std = new Student();
			std.setId(s1.getId());
			std.setRoll(s1.getRoll());
			std.setName(s1.getName());
			std.setAddress(s1.getAddress());
			
			stdList.add(std);
		}
		return stdList;

}
}
