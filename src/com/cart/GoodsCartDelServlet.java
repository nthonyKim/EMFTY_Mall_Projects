package com.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

@WebServlet("/GoodsCartDelServlet")
public class GoodsCartDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "null";
		if(dto == null) {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요합니다.");
		}else {
			nextPage = "GoodsCartListServlet";
			String num = request.getParameter("num");
			CartService service = new CartService();
			int n = service.cartDel(Integer.parseInt(num));
		}
		
		response.sendRedirect(nextPage);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
