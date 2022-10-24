package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;
import com.kh.sseudam.mypage.service.MypageLikeoutService;

@WebServlet(urlPatterns = "/mypage/likecheckout")
public class MypageLikeoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession s = req.getSession();
//		
//		MypageLikeVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		List<MypageLikeoutVo> MypageLikeoutList = new MypageLikeoutService().selectList("1");
		System.out.println(MypageLikeoutList);
		
		req.setAttribute("MypageLikeoutList", MypageLikeoutList);
		req.getRequestDispatcher("/views/mypage/likecheckout.jsp").forward(req, resp);
		
		
	}
}
