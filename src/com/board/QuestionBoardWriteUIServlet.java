package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.QuestionBoardDTO;
import com.service.QuestionBoardService;


@WebServlet("/QuestionBoardWriteUIServlet")
public class QuestionBoardWriteUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("QuestionBoardWrite.jsp");
		
		 request.setCharacterEncoding("UTF-8");
		 
		 String userid = request.getParameter("userid");
		 String title = request.getParameter("title"); 
		 String content = request.getParameter("content"); 
		 
		 QuestionBoardService service = new QuestionBoardService(); 
	/*	 String p = service.write(dto); //service wirte에 int로 넘길까 string으로 넘길까...
*/		
			 
		 
		
		
		//목록보기 
		response.sendRedirect("QuestionBoardListServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
