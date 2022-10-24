package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.service.MypageLikehomeService;

@WebServlet(urlPatterns="/mypage/likecheckhome")
public class MypageLikehomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession s = req.getSession();
//		
//		MypageLikeVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		List<MypageLikehomeVo> MypageLikehomeList = new MypageLikehomeService().selectList("1");
		
		req.setAttribute("MypageLikehomeList", MypageLikehomeList);
		req.getRequestDispatcher("/views/mypage/likecheckhome.jsp").forward(req, resp);
	}
}
