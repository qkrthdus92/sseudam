package com.kh.sseudam.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.member.service.MemberService;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.pro.service.ProMemberService;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

@WebServlet(urlPatterns = "/login")
public class MemberLoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//데이터 꺼냄
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String nextUrl = req.getParameter("abc");
		
		int startIdx = nextUrl.indexOf("/sseudam");	// 기준
		nextUrl = nextUrl.substring(startIdx);		// 기준 앞은 cut
		
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		
		MemberVo loginMember = new MemberService().login(vo);
		ProMemberJoinVo proLoginMember = new ProMemberService().prologin(vo);
		ProMemberJoinVo proVo = new ProMemberJoinVo();
		
		if(loginMember == null && proLoginMember == null) {
			req.getSession().setAttribute("alertMsg", "일치하는 회원정보가 없습니다.");
			resp.sendRedirect(nextUrl);
		}
		
		//화면선택
		if(loginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("loginMember", loginMember);
			resp.sendRedirect(nextUrl);
			
		}else if(proLoginMember == null){
			req.getSession().setAttribute("alertMsg", "일치하는 회원정보가 없습니다.");
		}
		
		//화면선택
		if(proLoginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("proLoginMember", proLoginMember);
			resp.sendRedirect(nextUrl);
			
		}else if(loginMember == null){
			req.getSession().setAttribute("alertMsg", "일치하는 회원정보가 없습니다.");
		}
		
	}
	
}
