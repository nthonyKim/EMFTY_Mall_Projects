package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {
	public List<GoodsDTO> goodsList(SqlSession session, 
			String goods_Category){
		List<GoodsDTO> list = 
				session.selectList("com.goods.goodsList", goods_Category);
		return list;
		
	}
	public List<GoodsDTO> goodsAll(SqlSession session
			){
		List<GoodsDTO> list = 
				session.selectList("com.goods.goodsAll");
		return list;
	}
	
	
}
