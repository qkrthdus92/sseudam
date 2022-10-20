package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/mypage/promypage")
public class ProMypageEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession s = req.getSession();
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		if(loginMember != null) {
//			req.getRequestDispatcher("/views/mypage/proeditmypage.jsp").forward(req, resp);
//		}else {
//			//에러페이지
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session= req.getSession();
		
		//프로멤버테이블 데이터 꺼내기
	}
	
	
}//class
