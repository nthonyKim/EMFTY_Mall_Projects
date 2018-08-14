package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {
	public List<GoodsDTO> goodsList(SqlSession session, String goods_Category){
		List<GoodsDTO> list = session.selectList("com.goods.goodsList", goods_Category);
		return list;
		//price 오류 해결중 
	}
	
	
}
