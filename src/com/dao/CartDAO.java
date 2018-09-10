package com.dao;

import java.util.HashMap;
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
	
	public int cartDel(SqlSession session, int num) {
		int n = session.delete("com.cart.cartDel", num);
		return n;
	}
	
	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n = session.update("com.cart.cartUpdate", map);
		return n;
	}
	
	public int cartDelAll(SqlSession session, List<String> list){
		int n = session.delete("com.cart.cartDelAll", list);
		return n;
	}

	public CartDTO cartToOrder(SqlSession session, int num) {
		CartDTO dto = session.selectOne("com.cart.cartToOrder", num);
		return dto;
	}

	public List<CartDTO> cartToOrderAll(SqlSession session, List<String> list) {
		List<CartDTO> cartList = session.selectList("com.cart.cartToOrderAll", list);
		return cartList;
	}
}

