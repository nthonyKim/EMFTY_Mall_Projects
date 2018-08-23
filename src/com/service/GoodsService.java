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

	public List<GoodsDTO> goodsSortBrand(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortBrand(session,map);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortColor(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortColor(session,map);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortBrandColor(HashMap<String, Object> map) {
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

	public List<String> colorChart(String goods_Category) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<String> list = null;
		try {
			list = dao.colorChart(session,goods_Category);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<String> brandChart(String goods_Category) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<String> list = null;
		try {
			list = dao.brandChart(session,goods_Category);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<String> colorChartAll() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<String> list = null;
		try {
			list = dao.colorChartAll(session);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<String> brandChartAll() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<String> list = null;
		try {
			list = dao.brandChartAll(session);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<GoodsDTO> goodsSortLowAll() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortLowAll(session);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortHighAll() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortHighAll(session);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortBrandColorAll(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortBrandColorAll(session, map);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortBrandAll(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortBrandAll(session, map);
			
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return list; 
	}

	public List<GoodsDTO> goodsSortColorAll(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.goodsSortColorAll(session, map);
			
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
