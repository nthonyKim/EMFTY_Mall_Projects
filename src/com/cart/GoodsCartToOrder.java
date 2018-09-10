package com.cart;

import java.io.IOException;

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
import com.service.MemberService;

@WebServlet("/GoodsCartToOrder")
public class GoodsCartToOrder extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "";
		if(dto == null) {
			session.setAttribute("mesg", "로그인이 필요합니다.");
			nextPage="LoginUIServlet";
		}else {
			int num = Integer.parseInt(request.getParameter("num"));
			System.out.println("num "+num);
			CartService cservice = new CartService();
			CartDTO cartDTO = cservice.cartToOrder(num);
			System.out.println(cartDTO);
			request.setAttribute("cartDTO", cartDTO);
			
			String userid = dto.getUserid();
			MemberService mservice = new MemberService();
			MemberDTO memberDTO = mservice.myPage(userid);
			request.setAttribute("memberDTO", memberDTO);		
			nextPage = "cartToOrder.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
