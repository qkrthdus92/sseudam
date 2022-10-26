package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.service.MypageLikeService;

@WebServlet(urlPatterns = "/mypage/yumdetail")
public class MypagelikeyumDetail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");

		MypageLikeVo  vo = new MypageLikeService().selectLikeOne(no);
		
		//화면선택 (데이터 담아서)
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/mypage/likeyumdetail.jsp").forward(req, resp);
	}
}
