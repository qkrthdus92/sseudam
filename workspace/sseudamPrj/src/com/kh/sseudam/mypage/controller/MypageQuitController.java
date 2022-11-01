package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.service.MypageEditService;

@WebServlet(urlPatterns = "/mypage/quit")
public class MypageQuitController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		
		//데이터꺼내기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		//데이터뭉치기
		
		//디비가녀오기
		int result = new MypageEditService().quit(no);
		
		if(result ==1) {
			s.invalidate();
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();

			out.println("<script language='javascript'>");
			out.println("alert('탈퇴완료')");
			out.println("</script>");

			out.flush();
			resp.sendRedirect("/sseudam/main");
		}
		
		
	
	}
}
