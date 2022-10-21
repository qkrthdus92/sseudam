package com.kh.sseudam.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.member.service.MemberService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/views/common/join.jsp")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/vi").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd1");
		String memberName = req.getParameter("memberName");
		String memberNick = req.getParameter("memberNick");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setName(memberName);
		vo.setNick(memberNick);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		//디비 다녀오기
		int result = new MemberService().join(vo);

		//화면 선택
		if(result == 1) {
			System.out.println("회원가입 성공!");
			resp.sendRedirect("");
		}else {
			
		}
		
	}
	
}
