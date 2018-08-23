package com.dto;

public class QuestionBoardDTO {
/*	 question_num number(5) primary key
	    ,title varchar2(20) not null
	    ,userid varchar2(20)
	    ,wirteday date default sysdate
	     );
*/
	private String question_num;
	private String title; 
	private String userid;
	private String writeday;
	public String getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(String question_num) {
		this.question_num = question_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	@Override
	public String toString() {
		return "QuestionBoardDTO [question_num=" + question_num + ", title=" + title + ", userid=" + userid
				+ ", writeday=" + writeday + "]";
	}
	public QuestionBoardDTO(String question_num, String title, String userid, String writeday) {
		super();
		this.question_num = question_num;
		this.title = title;
		this.userid = userid;
		this.writeday = writeday;
	}
	public QuestionBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
