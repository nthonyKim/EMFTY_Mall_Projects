package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	public List<GoodsDTO> goodsAll(SqlSession session){
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
	public List<GoodsDTO> goodsSortHigh(SqlSession session, String category) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortHigh",category);
		return list;
	}
	public List<GoodsDTO> goodsSortLow(SqlSession session, String category) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortLow",category);
		return list;
	}
	public List<GoodsDTO> goodsSortBrand(SqlSession session, HashMap<String, Object> map) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortBrand",map);
		return list;
	}
	public List<GoodsDTO> goodsSortColor(SqlSession session, HashMap<String, Object> map) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortColor",map);
		return list;
	}
	public List<GoodsDTO> goodsSortBrandColor(SqlSession session, HashMap<String, Object> map) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortBrandColor",map);
		return list;
	}
	public List<String> colorChart(SqlSession session, String goods_Category) {
		List<String> list = session.selectList("com.goods.goodsColorChart",goods_Category);
		return list;
	}
	public List<String> brandChart(SqlSession session, String goods_Category) {
		List<String> list = session.selectList("com.goods.goodsBrandChart",goods_Category);
		return list;
	}
	public List<String> colorChartAll(SqlSession session) {
		List<String> list = session.selectList("com.goods.goodsColorChartAll");
		return list;
	}
	public List<String> brandChartAll(SqlSession session) {
		List<String> list = session.selectList("com.goods.goodsBrandChartAll");
		return list;
	}
	public List<GoodsDTO> goodsSortLowAll(SqlSession session) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortLowAll");
		return list;
	}
	public List<GoodsDTO> goodsSortHighAll(SqlSession session) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortHighAll");
		return list;
	}
	public List<GoodsDTO> goodsSortBrandColorAll(SqlSession session, HashMap<String, Object> map) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortBrandColorAll", map);
		return list;
	}
	public List<GoodsDTO> goodsSortBrandAll(SqlSession session, HashMap<String, Object> map) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortBrandAll", map);
		return list;
	}
	public List<GoodsDTO> goodsSortColorAll(SqlSession session, HashMap<String, Object> map) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSortColorAll", map);
		return list;
	}
	public List<GoodsDTO> goodsSearch(SqlSession session, String search) {
		List<GoodsDTO> list = session.selectList("com.goods.goodsSearch", search);
		return list;
	}
	public int adminGoodsDel(SqlSession session, String num) {
		int n = session.delete("com.goods.adminGoodsDel", num);
		return n;
	}
	public int adminGoodsDelAll(SqlSession session, List<String> list) {
		int n = session.delete("com.goods.adminGoodsDelAll", list);
		return n;
	}
	public int adminGoodsUpdate(SqlSession session, GoodsDTO dto) {
		int n = session.update("com.goods.adminGoodsUpdate", dto);
		return n;
	}
	public int adminGoodsInsert(SqlSession session, GoodsDTO dto) {
		int n = session.insert("com.goods.adminGoodsInsert", dto);
		return n;
	}
	public GoodsDTO adminGoodsSel(SqlSession session, String goods_Code) {
		GoodsDTO dto = session.selectOne("com.goods.adminGoodsSel", goods_Code);
		return dto;
	}
	
	public int totalCount(SqlSession session) {
		int n = session.selectOne("com.goods.totalCount");
		return n;
	}
	
	
	
}
