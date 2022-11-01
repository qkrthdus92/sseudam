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
		
		System.out.println("로그인시 받은 아이디 :" + memberId);
		System.out.println("로그인시 받은 비번 :" + memberPwd);
		
		//데이터 뭉침
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		
		System.out.println("뭉친 값 :" + vo);
		
		//디비
		MemberVo loginMember = new MemberService().login(vo);
		ProMemberJoinVo proLoginMember = null;
		ProMemberJoinVo proVo = new ProMemberJoinVo();
		
		System.out.println("디비 다녀온 후 loginMember :" + loginMember);
		System.out.println("디비 다녀온 후 proVO :" + proVo);
		
		if(loginMember == null) {
			proLoginMember = new ProMemberService().prologin(vo);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 성공");
		}
		
		if(loginMember == null && proLoginMember == null) {
			req.getSession().setAttribute("alertMsg", "2. 일치하는 회원정보가 없습니다.");
			resp.sendRedirect("/sseudam/main");
		}
		
		//화면선택
		if(loginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("loginMember", loginMember);
			resp.sendRedirect("/sseudam");
			
		}else {
			req.getSession().setAttribute("alertMsg", "3. 일치하는 회원정보가 없습니다.");
		}
		
		if(proLoginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("proLoginMember", proLoginMember);
			resp.sendRedirect("/sseudam/main");
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 성공");
		}
		
	}
	
}
