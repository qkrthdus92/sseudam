package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.board.vo.MypageTestscoreVo;
import com.kh.sseudam.mypage.service.MypageLikehomeService;
import com.kh.sseudam.mypage.service.MypageTestscoreService;

@WebServlet(urlPatterns ="/mypage/testscore")
public class MypageTestscoreController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		String num = loginMember.getNo();
		
		List<MypageTestscoreVo> MypageTestscoreList = new MypageTestscoreService().selectList(num);
		
		req.setAttribute("MypageTestscoreList", MypageTestscoreList);
		req.getRequestDispatcher("/views/mypage/testresultcheck.jsp").forward(req, resp);
	}
}
