package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@WebServlet("/AdminGoodsUpdateUIServlet")
public class AdminGoodsUpdateUIServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String goods_Code = request.getParameter("goods_Code");
		
		GoodsService service = new GoodsService();
		System.out.println(goods_Code);
		GoodsDTO dto = service.adminGoodsSel(goods_Code);
		System.out.println(dto);
		request.setAttribute("goodDTO", dto);
		RequestDispatcher dis = request.getRequestDispatcher("adminUpdateGoodsPage.jsp");
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
