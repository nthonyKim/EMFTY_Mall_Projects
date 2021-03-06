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
import com.dto.MemberDTO;
import com.dto.PageDTO;
import com.service.GoodsService;

@WebServlet("/NoticeAddServlet")
public class NoticeAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = null;
		String nextPage = null;
		
		if(dto.getUserid().equals("admin")) {
			String currentPage = request.getParameter("currentPage");
			if(currentPage == "" || currentPage == null ){
			currentPage = "1";
			}	

			PageDTO pageDto = service.selectPage(Integer.parseInt(currentPage));
			
			nextPage = "noticeAdd.jsp";
			request.setAttribute("pageDto", pageDto);		
			
		}else {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "관리자가 아닙니다.");
		}

		RequestDispatcher dis =	request.getRequestDispatcher(nextPage);
		dis.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
