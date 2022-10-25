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
		
		//데이터 꺼냄
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//데이터 뭉침
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		
		//디비
		MemberVo loginMember = new MemberService().login(vo);
		ProMemberJoinVo proLoginMember = null;
		ProMemberJoinVo proVo = new ProMemberJoinVo();
		
		if(loginMember == null) {
			proLoginMember = new ProMemberService().prologin(vo);
		}
		
		if(loginMember == null && proLoginMember == null) {
			req.getSession().setAttribute("alertMsg", "로그인 실패");
			req.getRequestDispatcher("/sseudam").forward(req, resp);	//임의로 넣음
		}
		
		//화면선택
		if(loginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("loginMember", loginMember);
			resp.sendRedirect("/sseudam/main");
		}
		
		if(proLoginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("proLoginMember", proLoginMember);
			resp.sendRedirect("/sseudam/main");
		}
		
	}
	
}