package com.ilynn.model;

import java.util.Date;

public class News {

	private int nId; // ����ID
	private String title; // ���ű���
	private String content; // ��������
	private String date; // ���ŷ�������
	private String url; //���ŵ�ַ
	private Date nDate; // �������ڣ�Date����

	public News(int nId, String title, String content, String date, String url) {
		this.nId = nId;
		this.title = title;
		this.content = content;
		this.date = date;
		this.url = url;
	}

	public News() {
	}

	public News(int nId, String title, String content, Date nDate, String url) {
		this.nId = nId;
		this.title = title;
		this.content = content;
		this.nDate = nDate;
		this.url = url;
	}

	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
