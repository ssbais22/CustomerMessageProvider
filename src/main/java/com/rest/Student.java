package com.rest;

public class Student {
	private String name;
	private int studentId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String toString() {
		return "Studnet id: "+studentId+"|| Student name: "+studentId;
	}

}
