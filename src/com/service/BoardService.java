package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardService {

	
	private BoardDAO dao;
	public BoardService() {
		dao = new BoardDAO();
	}
	
	public BoardDTO selectNotice(BoardDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		BoardDTO retDto = null;
		try {
			retDto = dao.selectNotice(session, dto);
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return retDto;
	}
	
}
