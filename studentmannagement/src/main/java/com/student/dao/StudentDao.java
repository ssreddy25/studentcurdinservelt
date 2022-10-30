package com.student.dao;

import java.util.List;

import com.stu.model.StudentPojo;

public interface StudentDao {
	
	public String createStudent(StudentPojo student);
	public StudentPojo viewStudent(int studentId);
	public List<StudentPojo> viewAllStudent();
	public String updateStudent(int studentId ,StudentPojo updateStudent);
	public String deleteProduct(int studentId);

}
