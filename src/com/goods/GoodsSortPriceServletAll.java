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

/**
 * Servlet implementation class GoodsSortPrice
 */
@WebServlet("/GoodsSortPriceServletAll")
public class GoodsSortPriceServletAll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<String> colorChart = (List<String>) session.getAttribute("colorChartAll");
		List<String> brandChart = (List<String>) session.getAttribute("brandChartAll");
		
		String select = request.getParameter("sortSelect");
		System.out.println("select: "+select);
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = null;			
		String nextPage = "goodsList.jsp";
				
		if(select.equals("가격역순")) {
			list = service.goodsSortLowAll();
			System.out.println(list);
		}else if(select.equals("가격순")) {			
			list = service.goodsSortHighAll();	
		}
		request.setAttribute("goodsList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
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
