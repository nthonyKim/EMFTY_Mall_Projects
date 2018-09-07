package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.QuestionBoardDTO;

public class QuestionBoardDAO {
	
	
	//질문 수정 하기
	
	public int update(SqlSession session, QuestionBoardDTO dto) {
		int n = session.update("com.board.QuestionBoardInsert", dto);
		return n ; 
		
	}
	
	
	//질문하기 
	
	public int write(SqlSession session, QuestionBoardDTO dto) {
		
		int n = session.insert("com.board.QuestionBoardInsert", dto); 
		return n; 
	}
	
	
	
	
	//질문상세보기 
	public QuestionBoardDTO selectDetail(SqlSession session, String num){
	QuestionBoardDTO dto = 
				session.selectOne("com.board.selectDetail", num);
	return dto; 
	}
	
	//질문목록 
	public List<QuestionBoardDTO> select(SqlSession session
							,HashMap<String, String> map) {
		System.out.println("questionCheckDAO");
List<QuestionBoardDTO> list = 
session.selectList("com.board.selectAll",map); // 매퍼 복사 
	return list;
	
							}

}
