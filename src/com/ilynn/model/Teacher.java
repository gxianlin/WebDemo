package com.ilynn.model;

public class Teacher {
	
	private int tId;//��ʦ���
	
	private String name;
	
	private String title; //ְ��
	
	public Teacher() {
	}

	public Teacher(int tId, String name, String title) {
		this.tId = tId;
		this.name = name;
		this.title = title;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
