package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.service.MypageLikehomeService;


@WebServlet(urlPatterns = "/mypage/insidedetail")
public class MypageLikehomeDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		MypageLikehomeVo  vo = new MypageLikehomeService().selectLikeOne(no);
		
		//화면선택 (데이터 담아서)
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/mypage/likehomedetail.jsp").forward(req, resp);

	}
}
