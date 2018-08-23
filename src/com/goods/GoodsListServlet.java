package com.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.service.GoodsService;


@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String goods_Category = request.getParameter("goods_Category");
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = null;
		List<String> color = new ArrayList<String>();
		List<String> brand = new ArrayList<String>();
		
		list = service.goodsList(goods_Category);
		color = service.colorChart(goods_Category);
		brand = service.brandChart(goods_Category);	
		
		
		session.setAttribute("category", goods_Category);
		session.setAttribute("colorChart", color);
		session.setAttribute("brandChart", brand);
		request.setAttribute("goodsList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("goodsList.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
