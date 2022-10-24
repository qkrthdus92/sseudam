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
		
		//화면선택
		if(loginMember != null) {
			req.getSession().setAttribute("alertMsg", "로그인 성공");
			resp.sendRedirect("/sseudam/views/common/login.jsp");	//테스트경로 사용 중 끝나면 /main 연결
		}else {
			req.getSession().setAttribute("alertMsg", "로그인 실패");
			req.getRequestDispatcher("/sseudam").forward(req, resp);
		}
		
	}
	
}
