package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {
	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("com.cart.cartAdd", dto);
		return n;
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid){
		List<CartDTO> list = session.selectList("com.cart.cartList", userid);
		return list;
	}
}
