package com.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dto.QuestionBoardDTO;

import com.service.QuestionBoardService;

/**
 * Servlet implementation class MyBoardListServlet
 */
@WebServlet("/QuestionBoardServlet")
public class QuestionBoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("questionCheck");
		request.setCharacterEncoding("UTF-8");
	
		String searchName= request.getParameter("searchName");
		String searchValue= request.getParameter("searchValue");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		QuestionBoardService service = new  QuestionBoardService();
		List<QuestionBoardDTO> list = service.select(map);
		
		request.setAttribute("list", list);
		System.out.println(list);
		RequestDispatcher dis = 
				request.getRequestDispatcher("QuestionBoard.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
