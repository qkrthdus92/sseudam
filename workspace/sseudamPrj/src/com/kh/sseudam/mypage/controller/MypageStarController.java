package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.service.MypageFinreserService;

@WebServlet(urlPatterns = "/mypage/star")
public class MypageStarController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession s = req.getSession();
//		
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		String star =req.getParameter("value");
		String a_no =req.getParameter("no");
		
		MypageFinreserVo StarUpdate = new MypageFinreserService().updateStar(star,a_no,"2");
		
		req.setAttribute("StarUpdate", StarUpdate);
		req.getRequestDispatcher("/views/mypage/fin_resercheck.jsp").forward(req, resp);
	}
	
}
