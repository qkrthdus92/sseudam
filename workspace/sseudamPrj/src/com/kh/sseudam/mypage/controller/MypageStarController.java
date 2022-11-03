package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.service.MypageFinreserService;

@WebServlet(urlPatterns = "/mypage/star")
public class MypageStarController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession s = req.getSession();
		
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//별점이랑 회원번호 받아오기
		String num = loginMember.getNo();
		String star =req.getParameter("value");
		String a_no =req.getParameter("no");
		
		MypageFinreserVo vo = new MypageFinreserVo();
		vo.setStar(star);
		vo.setA_no(a_no);
		vo.setMember_no(num);

		int StarUpdate = new MypageFinreserService().updateStar(vo);
		
		if(StarUpdate != 1) {
			//실패
			System.out.println("실패");
		}
		
		
	}
	
}
