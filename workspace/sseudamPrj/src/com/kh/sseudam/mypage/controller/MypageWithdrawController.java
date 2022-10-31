package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.mypage.board.vo.MypageProMoneyListVo;
import com.kh.sseudam.mypage.service.MypageProMoneyListService;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

@WebServlet(urlPatterns = "/mypage/withdraw")
public class MypageWithdrawController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession s = req.getSession();
//		
//		ProMemberJoinVo ProloginMember = (ProMemberJoinVo)s.getAttribute("ProloginMember");
//		
//		String num = ProloginMember.getNo();
		
		String withdrawbal = req.getParameter("withdraw");
		System.out.println(withdrawbal);
		
		int withdraw2 = new  MypageProMoneyListService().withdraw("2",withdrawbal);
		System.out.println(withdraw2);
		
		resp.getWriter().write(withdraw2);
	
	}
	
}
