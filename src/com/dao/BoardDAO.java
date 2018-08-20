package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {

	
			public BoardDTO selectNotice(SqlSession session, 
		BoardDTO dto) {
				return session.selectOne("com.board.selectNotice", dto); 
			
			
}
}//end dao
