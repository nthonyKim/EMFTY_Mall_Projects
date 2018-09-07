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
import com.dto.QuestionBoard_CommentsDTO;
import com.service.QuestionBoardService;
import com.service.QuestionBoard_CommentsService;

/**
 * Servlet implementation class MyBoardListServlet
 */
@WebServlet("/QuestionBoardDetailServlet")
public class QuestionBoardDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("questionDetailServletCheck");
		request.setCharacterEncoding("UTF-8");
	
		
		String searchName= request.getParameter("searchName");
		String searchValue= request.getParameter("searchValue");
		String num = request.getParameter("Question_num"); 
		HashMap<String, String> map = new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		QuestionBoardService service = new  QuestionBoardService();
		QuestionBoardDTO dto = service.retrieve(num); 
		///////
		HashMap<String, String> map2 = new HashMap<>();
		QuestionBoard_CommentsService service2 = new QuestionBoard_CommentsService(); 
		List<QuestionBoard_CommentsDTO> list2 = (List<QuestionBoard_CommentsDTO>) service2.selectOne(num); 
		for (QuestionBoard_CommentsDTO questionBoard_CommentsDTO : list2) {
			System.out.println(questionBoard_CommentsDTO);
		}
		//커멘트
		request.setAttribute("list2", list2);
		
		
		//게시글
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
