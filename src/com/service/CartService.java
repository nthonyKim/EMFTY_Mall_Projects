package com.service;

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
}
