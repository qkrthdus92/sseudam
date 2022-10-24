package com.kh.sseudam.pro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.pro.service.ProMemberService;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;

@WebServlet(urlPatterns = "/proLogin")
public class ProMemberLoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proMemberId = req.getParameter("memberId");
		String proMemberPwd = req.getParameter("memberPwd");
	
		ProJoinPage1Vo page1vo = new ProJoinPage1Vo();
		page1vo.setId(proMemberId);
		page1vo.setPwd(proMemberPwd);
		
		ProJoinPage1Vo proLoginMember = new ProMemberService().prologin(page1vo);
		
		System.out.println("proLoginMember : " + proLoginMember);
		
		if(proLoginMember != null) {
			HttpSession s = req.getSession();
			s.setAttribute("alertMsg", "로그인 성공");
			s.setAttribute("proLoginMember", proLoginMember);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 실패");//임의로 넣음
		}
		
	}
	
}
