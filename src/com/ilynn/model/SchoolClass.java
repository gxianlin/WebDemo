package com.ilynn.model;

import java.util.List;

public class SchoolClass {

	private int cId;// �༶���

	private String name; // �༶����

	private Teacher teacher; // ������

	private List<Student> stus; // �༶ѧ��

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStus() {
		return stus;
	}

	public void setStus(List<Student> stus) {
		this.stus = stus;
	}

	public SchoolClass(int cId, String name, Teacher teacher, List<Student> stus) {
		this.cId = cId;
		this.name = name;
		this.teacher = teacher;
		this.stus = stus;
	}

	public SchoolClass() {
	}

	
}
