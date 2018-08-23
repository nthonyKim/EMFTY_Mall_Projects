package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;

@WebServlet("/GoodsCartUpdateServlet")
public class GoodsCartUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String nextPage = null;
		if(dto == null) {
			out.print("fail");
		}else {
			String num = request.getParameter("num");
			String gAmount = request.getParameter("gAmount");
			HashMap<String, Integer> map = new HashMap<>();
			map.put("num", Integer.parseInt(num));
			map.put("gAmount", Integer.parseInt(gAmount));
			CartService service = new CartService();
			int n = service.cartUpdate(map);
			
			out.print("success");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
