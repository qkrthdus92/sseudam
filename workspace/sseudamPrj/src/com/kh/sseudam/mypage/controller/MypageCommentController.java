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
import com.kh.sseudam.mypage.board.vo.MypageCommentVo;
import com.kh.sseudam.mypage.board.vo.MypageCommentVo2;
import com.kh.sseudam.mypage.service.MypageBoardService;
import com.kh.sseudam.mypage.service.MypageCommentService;

@WebServlet(urlPatterns = "/mypage/commentcheck")
public class MypageCommentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession s = req.getSession();
//		
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		List<MypageCommentVo> MypageCommentList = new MypageCommentService().selectList("1");
		List<MypageCommentVo2> MypageCommentList2 = new MypageCommentService().selectList2("1");
		
		req.setAttribute("MypageCommentList", MypageCommentList);
		req.setAttribute("MypageCommentList2", MypageCommentList2);
		req.getRequestDispatcher("/views/mypage/commentcheck.jsp").forward(req, resp);
	}
	
}
