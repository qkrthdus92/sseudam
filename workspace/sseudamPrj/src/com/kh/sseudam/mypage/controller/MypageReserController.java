package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;
import com.kh.sseudam.mypage.service.MypageLikeoutService;
import com.kh.sseudam.mypage.service.MypageReserService;

@WebServlet(urlPatterns = "/mypage/resercheck")
public class MypageReserController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession s = req.getSession();
//		
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		List<MypageReserVo> MypageReserList = new MypageReserService().selectList("1");

		
		req.setAttribute("MypageReserList", MypageReserList);
		req.getRequestDispatcher("/views/mypage/resercheck.jsp").forward(req, resp);
	}
}
