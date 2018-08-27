package com.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

@WebServlet("/GoodsCartAllDelServlet")
public class GoodsCartAllDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] check = request.getParameterValues("check");
		List<String> list = Arrays.asList(check);
		System.out.println(list);
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = null;
		if(dto == null){	
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요합니다.");
		}else {
			nextPage = "GoodsCartListServlet";
			CartService service = new CartService();
			int n = service.cartDelAll(list);
		}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
