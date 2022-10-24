package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageReserDetailVo;
import com.kh.sseudam.mypage.service.MypageReserDetailService;
import com.kh.sseudam.mypage.service.MypageReserService;

@WebServlet(urlPatterns = "/mypage/reserdetail")
public class MypageReserDetailController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//	HttpSession s = req.getSession();
	//	
	//	MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
	//	
	//	String num = loginMember.getNo();
		
		String no = req.getParameter("no");
		
		MypageReserDetailVo vo = new MypageReserService().selectReserOne("1",no);

		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/mypage/reserdetail.jsp").forward(req, resp);
		
	}
	
	
	
	
}
