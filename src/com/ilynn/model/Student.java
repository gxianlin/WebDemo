package com.ilynn.model;

public class Student {
	private int sId; //ѧ��
	private String name;
	private String birthday;
	private String sex;
	
	public Student() {
	}
	
	public Student(int sId, String name, String birthday, String sex) {
		this.sId = sId;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	

	
	
}
