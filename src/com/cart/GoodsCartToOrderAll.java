package com.cart;

import java.io.IOException;
import java.util.Arrays;
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
import com.service.MemberService;

@WebServlet("/GoodsCartToOrderAll")
public class GoodsCartToOrderAll extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "";		
		
		if(dto == null) {
			session.setAttribute("mesg", "로그인이 필요합니다.");
			nextPage="LoginUIServlet";
		}else {
			String[] check = request.getParameterValues("check");
			List<String> list = Arrays.asList(check);
			System.out.println(list);
			
			CartService cservice = new CartService();
			List<CartDTO> cartList = cservice.cartToOrderAll(list);
			request.setAttribute("list", cartList);
			System.out.println("cartList "+cartList);
			
			String userid = dto.getUserid();
			MemberService mservice = new MemberService();
			MemberDTO memberDTO = mservice.myPage(userid);
			request.setAttribute("memberDTO", memberDTO);		
			nextPage = "cartToOrderAll.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
