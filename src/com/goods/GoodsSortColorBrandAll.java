package com.goods;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
 * Servlet implementation class GoodsSortColorBrand
 */
@WebServlet("/GoodsSortColorBrandAll")
public class GoodsSortColorBrandAll extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<String> colorChart = (List<String>) session.getAttribute("colorChartAll");
		List<String> brandChart = (List<String>) session.getAttribute("brandChartAll");
		
		GoodsService service = new GoodsService();
		String [] color = request.getParameterValues("color");
		String [] brand = request.getParameterValues("brand");
		HashMap<String, Object> map = new HashMap<>();
		List<GoodsDTO> list = null;
		List<String> clist = null;
		List<String> blist = null;
							
		if(color != null && brand ==null) {
			clist = Arrays.asList(color);
			map.put("color", clist);
			list = service.goodsSortColorAll(map);
		}else if(color == null && brand !=null) {
				blist = Arrays.asList(brand);
				map.put("brand", blist);
				list = service.goodsSortBrandAll(map);
				
		}else if(color != null && brand !=null) {
				clist = Arrays.asList(color);
				blist = Arrays.asList(brand);
				
				map.put("color", clist);
				map.put("brand", blist);
				list = service.goodsSortBrandColorAll(map);
		}
				
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
