package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageAllreserVo;
import com.kh.sseudam.mypage.service.MypageAllreserService;

@WebServlet(urlPatterns = "/mypage/reserpay")
public class MypageAllreserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession s = req.getSession();
//		
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		List<MypageAllreserVo> MypageAllreserList = new MypageAllreserService().selectList("1");
		
		req.setAttribute("MypageAllreserList", MypageAllreserList);
		req.getRequestDispatcher("/views/mypage/reserpay.jsp").forward(req, resp);
	}
	
}
