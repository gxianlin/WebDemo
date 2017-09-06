package com.ilynn.model;

public class Box<T> {
	private T data;
	
	public Box() {
		// TODO Auto-generated constructor stub
	}
	
	public Box(T data){
		setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
