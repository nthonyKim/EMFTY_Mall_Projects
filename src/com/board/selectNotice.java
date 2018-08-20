package com.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.dto.GoodsDTO;
/*import com.service.BoardService;*/

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/BoardListServlet")
public class selectNotice extends HttpServlet {

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strSeq = request.getParameter("seq")==null ? "1" : request.getParameter("seq");
		
		BoardService service = new BoardService();
		BoardDTO param = new BoardDTO();
		param.setSeq(Integer.parseInt(strSeq));
		List<BoardDTO> boardList = service.selectBoardList(param);
		
		request.setAttribute("boardList", boardList); //master 병합용
		
		RequestDispatcher dis = request.getRequestDispatcher("boardList.jsp");
		dis.forward(request, response);
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
