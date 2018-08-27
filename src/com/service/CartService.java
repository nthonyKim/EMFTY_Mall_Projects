package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;

public class CartService {
	private CartDAO dao;
	
	public CartService() {
		dao = new CartDAO();
	}
	public int cartAdd(CartDTO dto) {
		SqlSession session =  MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.cartAdd(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public List<CartDTO> cartList(String userid){
		SqlSession session = MySqlSessionFactory.getSession();
		List<CartDTO> list = null;
		try {
			list = dao.cartList(session, userid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public int cartDel(int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.cartDel(session, num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int cartUpdate(HashMap<String, Integer> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.cartUpdate(session, map);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int cartDelAll(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.cartDelAll(session, list);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
		
	}
}
