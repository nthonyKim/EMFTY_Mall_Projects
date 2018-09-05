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
@WebServlet("/QuestionBoardDetailServlet")
public class QuestionBoardDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("questionDetailCheck");
		request.setCharacterEncoding("UTF-8");
	
		String searchName= request.getParameter("searchName");
		String searchValue= request.getParameter("searchValue");
		String num = request.getParameter("Question_num"); 
		HashMap<String, String> map = new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		QuestionBoardService service = new  QuestionBoardService();
		QuestionBoardDTO dto = service.retrieve(num); 
		
		request.setAttribute("list", dto);
		System.out.println(dto);
		RequestDispatcher dis = 
				request.getRequestDispatcher("QuestionBoardDetail.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
