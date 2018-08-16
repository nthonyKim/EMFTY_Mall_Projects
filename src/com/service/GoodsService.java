package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

public class GoodsService {
  
	private GoodsDAO dao;
	public GoodsService() {
		dao = new GoodsDAO();
	}
	
	public List<GoodsDTO> goodsList(String goods_Category){
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsList(session, goods_Category);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}//end goodsList

	public List<GoodsDTO> goodsAll() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsAll(session);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}
	
	
	//상품정보 상세페이지
	public GoodsDTO goodsRetrieve(String goods_Code) {
		SqlSession session = MySqlSessionFactory.getSession();
		GoodsDTO dto = null;
		try {
			dto = dao.goodsRetrieve(session, goods_Code);
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}//end goodsRetrieve 
	
	//test, test, test 
	
	
	
}
