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
		//dao test
	}
	public List<GoodsDTO> goodsAll(SqlSession session
			){
		List<GoodsDTO> list = 
				session.selectList("com.goods.goodsAll");
		return list;
	}
	
	//상품정보 상세페이지
	public GoodsDTO goodsRetrieve(SqlSession session, 
			String goods_Code) {
		GoodsDTO dao 
		= session.selectOne("com.goods.goodsRetrieve", goods_Code);
	return dao; 
	}
	
	
}
