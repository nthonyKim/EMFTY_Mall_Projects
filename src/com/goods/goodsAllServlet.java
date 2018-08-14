package com.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;


@WebServlet("/GoodsListServlet")
public class goodsAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		<%
	     EmpService service = new EmpService();
	     List<EmpDTO> list = service.select();

	%>    
	    
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<table border="1">
	  <tr>
	    <td>사원번호</td>
	    <td>사원이름</td>
	    <td>월급</td>
	    <td>입사일</td>
	    <td>부서번호</td>
	  </tr>
	  
	 <%
	   for(EmpDTO dto: list){
		  int empno = dto.getEmpno();
		  String ename = dto.getEname();
		  int sal = dto.getSal();
		  String hiredate = dto.getHiredate();
		  int deptno = dto.getDeptno();
	 %> */
		//String goods_Category = request.getParameter(goods_Category);
		
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = service.goodsAll();
		
		request.setAttribute("goodsAll", list);
		
		
		RequestDispatcher dis =
				request.getRequestDispatcher("goodsList.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
