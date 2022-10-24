package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.service.MypageBoardService;
import com.kh.sseudam.mypage.service.MypageLikeService;

@WebServlet(urlPatterns = "/mypage/likeyum")
public class MypageLikeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession s = req.getSession();
//		
//		MypageLikeVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
	
		
		List<MypageLikeVo> MypageLikeList = new MypageLikeService().selectList("1");
		
		req.setAttribute("MypageLikeList", MypageLikeList);
		req.getRequestDispatcher("/views/mypage/likecheckyum.jsp").forward(req, resp);
	}
}
