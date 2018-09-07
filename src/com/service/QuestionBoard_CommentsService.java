package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.QuestionBoard_CommentsDAO;

import com.dto.QuestionBoard_CommentsDTO;

public class QuestionBoard_CommentsService {

	//질문 코멘트 불러오기(클릭한 글 넘버에 따라) 
	public List<QuestionBoard_CommentsDTO> selectOne(String num) {
		QuestionBoard_CommentsDAO dao = new QuestionBoard_CommentsDAO(); 
		SqlSession session = MySqlSessionFactory.getSession();
		List<QuestionBoard_CommentsDTO> dto = null ; 
		try {
			dto =  dao.selectComment(session, num); 

			// }catch(Exception e) {
			// e.printStackTrace();
		} finally {
			session.close();
		}
		return dto; 
	}// end select
		
	}
	

