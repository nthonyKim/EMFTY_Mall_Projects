package com.service;

import java.util.HashMap;
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

	public List<GoodsDTO> goodsSortHigh(String category) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortHigh(session,category);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortLow(String category) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortLow(session,category);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortBrand(String brand) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortBrand(session,brand);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortColor(String color) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortColor(session,color);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortBrandColor(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortBrandColor(session,map);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	//test, test, test 
	
	
	
}
