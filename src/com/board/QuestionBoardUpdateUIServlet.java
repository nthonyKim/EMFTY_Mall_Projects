package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionBoardUpdateUIServlet
 */
@WebServlet("/QuestionBoardUpdateUIServlet")
public class QuestionBoardUpdateUIServlet extends HttpServlet {

    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 
		 String userid = request.getParameter("userid");
		 String title = request.getParameter("title"); 
		 String content = request.getParameter("content");  
		 
		 
		 response.sendRedirect("QuestionBoardUpdate.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
