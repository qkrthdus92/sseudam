package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageProreserVo;
import com.kh.sseudam.mypage.service.MypageProreserService;

@WebServlet(urlPatterns = "/mypage/proresercheck")
public class MypageProreserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		HttpSession s = req.getSession();
//		
//		ProVo loginMember = (ProVo)s.getAttribute("loginMember");
//		
//		String num = loginMember.getNo();
		
		List<MypageProreserVo> MypageProreserList = new MypageProreserService().selectList("1");

		
		req.setAttribute("MypageProreserList", MypageProreserList);
		req.getRequestDispatcher("/views/mypage/proresercheck.jsp").forward(req, resp);
	}
}
