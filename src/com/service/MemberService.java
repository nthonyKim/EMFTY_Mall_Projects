package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dao.MemberDAO;
import com.dto.MemberDTO;


public class MemberService {
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}
	
	public int idCheck(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.idCheck(session, userid);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int memberAdd(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			count = dao.memberAdd(session, dto);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	public MemberDTO login(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.login(session, map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}

	public String idFind(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		String userid = null;
		try {
			userid = dao.idFind(session,dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return userid;
	}

	public MemberDTO myPage(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.myPage(session, userid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	public int memberUpdate(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.memberUpdate(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
}
