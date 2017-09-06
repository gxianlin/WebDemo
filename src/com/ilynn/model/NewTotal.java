package com.ilynn.model;

import java.util.List;

public class NewTotal {
	private int total; //��������
	private List<News> rows; //�����б�
	
	
	public NewTotal() {
	}
	public NewTotal(int total, List<News> rows) {
		this.total = total;
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<News> getRows() {
		return rows;
	}
	public void setRows(List<News> rows) {
		this.rows = rows;
	}
	
	
}
