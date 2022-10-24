package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.service.MypageFinreserService;
import com.kh.sseudam.mypage.service.MypageReserService;

@WebServlet(urlPatterns = "/mypage/fin_resercheck")
public class MypageFinreserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession s = req.getSession();
//		
//		MypageLikeVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		List<MypageFinreserVo> MypageFinreserList = new MypageFinreserService().selectList("1");
		
		req.setAttribute("MypageFinreserList", MypageFinreserList);
		req.getRequestDispatcher("/views/mypage/fin_resercheck.jsp").forward(req, resp);
	}
}
