package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.GoodsService;

/**
 * Servlet implementation class AdminGoodsUpdateServlet
 */
@WebServlet("/AdminGoodsUpdateServlet")
public class AdminGoodsUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("goods_Code");
		GoodsService service = new GoodsService();
		int n = 0;
		if(num != null) {
			n = service.adminGoodsUpdate(num);
		}
		response.sendRedirect("AdminPageServlet");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
