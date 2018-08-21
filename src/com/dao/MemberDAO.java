package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	public int idCheck(SqlSession session, String userid) {
		int n = session.selectOne("com.member.idCheck", userid);
		return n;
	}
	
	public int memberAdd(SqlSession session, MemberDTO dto) {
		int count = session.insert("com.member.memberAdd", dto);
		return count;
	}

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto = session.selectOne("com.member.login",map);
		return dto;
	}

	public String idFind(SqlSession session, MemberDTO dto) {
		String userid = session.selectOne("com.member.idFind", dto);
		return userid;
	}

	public MemberDTO myPage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.member.myPage", userid);
		return dto;
	}
	
	public int memberUpdate(SqlSession session, MemberDTO dto ) {
		int n = session.update("com.member.memberUpdate", dto);
		return n;
	};
}
