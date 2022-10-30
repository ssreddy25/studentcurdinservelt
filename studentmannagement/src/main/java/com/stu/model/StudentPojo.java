package com.stu.model;

import java.io.Serializable;

public class StudentPojo implements Serializable {

	public int studentId;
	public String studentName;
	public int studentRollNo;
	public String studentGrade;

	public StudentPojo() {
	}

	public StudentPojo(int studentId, String studentName, int studentRollNo, String studentGrade) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.studentGrade = studentGrade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentGrade == null) ? 0 : studentGrade.hashCode());
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + studentRollNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPojo other = (StudentPojo) obj;
		if (studentGrade == null) {
			if (other.studentGrade != null)
				return false;
		} else if (!studentGrade.equals(other.studentGrade))
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentRollNo != other.studentRollNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentPojo [studentId=" + studentId + ", studentName=" + studentName + ", studentRollNo="
				+ studentRollNo + ", studentGrade=" + studentGrade + "]";
	}

}
