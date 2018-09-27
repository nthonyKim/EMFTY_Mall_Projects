package com.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.service.GoodsService;


@WebServlet("/GoodsAllServlet")
public class GoodsAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("category");
		session.removeAttribute("colorChartAll");
		session.removeAttribute("brandChartAll");
		
		GoodsService service = new GoodsService();
		String search = request.getParameter("search");
		List<GoodsDTO> list = null;
		List<String> color = null;
		List<String> brand = null;
		
		if(search != null || search == "") {
			list = service.goodsSearch(search);
		}else {
			list = service.goodsAll();			
		}		
		color = service.colorChartAll();
		brand = service.brandChartAll();
		
		request.setAttribute("goodsList", list);
		session.setAttribute("colorChartAll", color);
		session.setAttribute("brandChartAll", brand);
		
		RequestDispatcher dis =	request.getRequestDispatcher("goodsAll.jsp");
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
