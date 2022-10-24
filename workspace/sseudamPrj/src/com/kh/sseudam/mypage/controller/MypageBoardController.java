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
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.service.MypageBoardService;

@WebServlet(urlPatterns = "/mypage/boardcheck")
public class MypageBoardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		HttpSession s = req.getSession();
//		
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
	
		
		List<MypageBoardVo> MypageBoardList = new MypageBoardService().selectList("1");
		
		req.setAttribute("MypageBoardList", MypageBoardList);
		req.getRequestDispatcher("/views/mypage/boardcheck.jsp").forward(req, resp);
	}
}
