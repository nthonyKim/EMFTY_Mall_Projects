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
	private String question_contents; 
	private String userid;
	private String wirteday; 
	private String image_name; 
	
	public QuestionBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuestionBoardDTO [question_num=" + question_num + ", title=" + title + ", question_contents="
				+ question_contents + ", userid=" + userid + ", writeday=" + wirteday + ", image_name=" + image_name
				+ "]";
	}

	public QuestionBoardDTO(String question_num, String title, String question_contents, String userid, String writeday,
			String image_name) {
		super();
		this.question_num = question_num;
		this.title = title;
		this.question_contents = question_contents;
		this.userid = userid;
		this.wirteday = wirteday;
		this.image_name = image_name;
	}

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

	public String getQuestion_contents() {
		return question_contents;
	}

	public void setQuestion_contents(String question_contents) {
		this.question_contents = question_contents;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getWirteday() {
		return wirteday;
	}

	public void setWriteday(String writeday) {
		this.wirteday = wirteday;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	} 
	
	
	
}
