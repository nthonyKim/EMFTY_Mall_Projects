package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	public int memberAdd(SqlSession session, MemberDTO dto) {
		int count = session.insert("com.dto.memberAdd", dto);
		return count;
		
	}
	
}
