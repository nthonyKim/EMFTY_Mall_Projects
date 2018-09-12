package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.GoodsService;
import com.service.QuestionBoardService;


@WebServlet("/QuestionBoardDeleteServlet")
public class QuestionBoardDeleteServlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		String question_num = request.getParameter("Question_num"); 
		QuestionBoardService service = new QuestionBoardService();
		int n = service.QuestionBoardDelete(Integer.parseInt(question_num)); 
		
	/*	
		
		String num = request.getParameter("goods_Code");
		GoodsService service = new GoodsService();
		
		int n = service.adminGoodsDel(num);		
		response.sendRedirect("AdminPageServlet");*/
		
		
		response.sendRedirect("QuestionBoardServlet");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
