package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.QuestionBoardDTO;

public class QuestionBoardDAO {
	
	public List<QuestionBoardDTO> select(SqlSession session
							,HashMap<String, String> map) {
		System.out.println("questionCheckDAO");
List<QuestionBoardDTO> list = 
session.selectList("com.board.selectAll",map); // 매퍼 복사 
	return list;
	
							}

}
