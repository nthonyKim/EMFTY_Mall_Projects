package com.dto;

public class BoardDTO {
	private String title;
	private int seq; 
	private String content; 
	private String date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", seq=" + seq + ", content=" + content + ", date=" + date + "]";
	}
	public BoardDTO(String title, int seq, String content, String date) {
		super();
		this.title = title;
		this.seq = seq;
		this.content = content;
		this.date = date;
	}
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
