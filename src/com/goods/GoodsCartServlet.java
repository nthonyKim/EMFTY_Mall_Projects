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

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;


@WebServlet("/GoodsCartServlet")
public class GoodsCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 체크 여부
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto==null) {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업");
		}else {
			String gImage = request.getParameter("goods_Image1");
			String gCode = request.getParameter("goods_Code");
			String gName = request.getParameter("goods_Name");
			String gPrice = request.getParameter("goods_Price");
			String gBrand = request.getParameter("goods_Brand");
			String gAmount = request.getParameter("goods_Amount");
			String gColor = request.getParameter("goods_Color");
			
			CartDTO cDTO = new CartDTO();
			cDTO.setUserid(dto.getUserid());
			cDTO.setGoods_image(gImage);
			cDTO.setGoods_code(gCode);
			cDTO.setGoods_name(gName);
			cDTO.setGoods_price(Integer.parseInt(gPrice));
			cDTO.setGoods_brand(gBrand);
			cDTO.setGoods_color(gColor);
			cDTO.setGoods_amount(Integer.parseInt(gAmount));
			
			CartService service = new CartService();
			int n = service.cartAdd(cDTO);
			nextPage = "GoodsRetrieveServlet?goods_Code="+gCode;
			session.setAttribute("mesg", gCode+"카트저장 성공");
		}
		
		response.sendRedirect(nextPage);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
