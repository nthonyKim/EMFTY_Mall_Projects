package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.QuestionBoardDTO;
import com.service.QuestionBoardService;


@WebServlet("/QuestionBoardWriteServlet")
public class QuestionBoardWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시간과 글번호는 자동부여로 매퍼에서 넣자 
		String userid = request.getParameter("userid");
		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		String image_name = request.getParameter("image_name"); 
		
		QuestionBoardDTO dto = new QuestionBoardDTO() ;
		dto.setImage_name(image_name);
		dto.setTitle(title);
		dto.setUserid(userid);
		dto.setQuestion_contents(content); 
		
		QuestionBoardService service = new QuestionBoardService();
		int n = service.write(dto); 
		
		
		response.sendRedirect("QuestionBoard.jsp");
		 
		
		
	}

	
/*	question_num
	title
	author 
	content 
	wirteday 
	regdcnt */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
