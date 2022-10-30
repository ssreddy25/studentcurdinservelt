package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.model.StudentPojo;
import com.student.db.DBUtility;

public class StudentImplement implements StudentDao {
	
 	public static Connection con=DBUtility.getConnection();
	List<StudentPojo> students = null;
	public StudentPojo student=null;
	public String msg=null;
	public int count=0;

	public String createStudent(StudentPojo student) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, student.getStudentId());
			ps.setString(2,student.getStudentName());
			ps.setInt(3, student.getStudentRollNo());
			ps.setString(4, student.getStudentGrade());
			
			 count=ps.executeUpdate();
			 if(count!=0){
				 msg="data inserted";
			 }else{
				 msg="data not inserted";
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(msg);
		return msg;
	
	}

	public StudentPojo viewStudent(int studentId) {
		System.out.println("view student id :"+studentId);
//		student=new StudentPojo();
		
		try {
     		PreparedStatement ps=con.prepareStatement(" select * from student where studentId=?");
			ps.setInt(1, studentId);
			ResultSet rs=ps.executeQuery();
//			rs.next();
//			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getString(4));
			
			if(rs.next()){
				student=new StudentPojo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(student);
		
		return student;
		
		
	}

	public List<StudentPojo> viewAllStudent() {
		   
		students = new ArrayList<StudentPojo>();
		 
		try {
			PreparedStatement ps=con.prepareStatement(" select * from student ");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				student=new StudentPojo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				students.add(student);	
			}
			for(StudentPojo stu:students){
				System.out.println(stu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(StudentPojo stu:students){
//			System.out.println(stu);
//		}
		
		return students;
	}

	public String updateStudent(int studentId, StudentPojo updateStudent) {
		
		System.out.println("updated student details :"+updateStudent);
		try {
			PreparedStatement ps=con.prepareStatement("update student set studentname=?, studentrollno=?, studentgrade=?  where studentId=? ");
			
			
			ps.setString(1,updateStudent.getStudentName());
			ps.setInt(2, updateStudent.getStudentRollNo());
			ps.setString(3, updateStudent.getStudentGrade());
			ps.setInt(4, studentId);
			
			
			
			 count=ps.executeUpdate();
			 
			 if(count!=0){
				 msg="data is updated";
			 }else{
				 msg="data not updated";
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		
		return msg;
	}

	public String deleteProduct(int studentId) {
		try {
			PreparedStatement ps=con.prepareStatement("delete from  student where studentId=?");
			
			ps.setInt(1, studentId);
			count=ps.executeUpdate();
			if(count!=0){
				
				msg="data is deleted";
			}else{
				msg="data is not  deleted";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

}
