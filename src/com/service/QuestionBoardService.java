package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.QuestionBoardDAO;

import com.dto.QuestionBoardDTO;

public class QuestionBoardService {

/*	public int update(QuestionBoardDTO dto) {
		MyBoardDAO dao = new MyBoardDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.update(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}
	*/
	
	
	
	
	public int QuestionBoardDelete(int num) {
		QuestionBoardDAO dao = new QuestionBoardDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.delete(session, num);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}
	
	// 질문 수정하기 
	
	public int update(QuestionBoardDTO dto) {
		QuestionBoardDAO dao = new QuestionBoardDAO(); 
			SqlSession session = MySqlSessionFactory.getSession();
			int n = 0;
			try {
				n = dao.update(session, dto);
				session.commit();
			} finally {
				session.close();
			}
			return n;
	
	}

	
	
	public int write(QuestionBoardDTO dto) {
	QuestionBoardDAO dao = new QuestionBoardDAO();
	SqlSession session = MySqlSessionFactory.getSession();
	int n = 0; 
	try {
		n = dao.write(session, dto);
		session.commit(); 
	}finally {
		session.close(); 
	}
	System.out.println("QuestionBoard 서비스  wirte 메서드");
	return n; 
	}
	
	
	
	
	
	
//상세보기 
	public QuestionBoardDTO retrieve(String num) {
		QuestionBoardDAO dao = new QuestionBoardDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		QuestionBoardDTO dto = null;
		try {
			dto = dao.selectDetail(session,num);

			// }catch(Exception e) {
			// e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}// end select

	
	//보기 
	public List<QuestionBoardDTO> select(HashMap<String, String> map) {
		QuestionBoardDAO dao = new QuestionBoardDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		List<QuestionBoardDTO> list = null;
		System.out.println("questionCheckService");
		try {
			list = dao.select(session,map);

			// }catch(Exception e) {
			// e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
		
	}// end select



}
