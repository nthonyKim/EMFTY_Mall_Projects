package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.QuestionBoard_CommentsDTO;

public class QuestionBoard_CommentsDAO {

	 //질문게시판 댓글 나열
	
	public List<QuestionBoard_CommentsDTO> selectComment(SqlSession session, String num ) {
		List<QuestionBoard_CommentsDTO> dto = 
				session.selectList("com.board.questionboard_comments", num); 
				
		
		
				System.out.println("QuestionBoard_CommentsDAO check");
				
		return dto; 
		
		
		
	}
	
	

	
}
