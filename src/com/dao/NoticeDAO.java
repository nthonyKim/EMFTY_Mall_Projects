package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.NoticeDTO;

public class NoticeDAO {
	
	public List<NoticeDTO> select(SqlSession session
			            ,HashMap<String, String> map) {
		List<NoticeDTO> list = 
				session.selectList("com.board.notice",map);
		return list;
	}
	

}
