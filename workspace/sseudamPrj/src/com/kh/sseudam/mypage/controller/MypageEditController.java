package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.mypage.service.MypageEditService;

@WebServlet(urlPatterns = "/mypage/mypage")
public class MypageEditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		if(loginMember != null) {
			req.getRequestDispatcher("/views/mypage/editmypage.jsp").forward(req, resp);
		}else {
			//에러 페이지 어떻게 보여줄지?
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session= req.getSession();
		
		//데이터꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd1 = req.getParameter("memberPwd1");
		String memberNick = req.getParameter("memberNick");
		String addr = req.getParameter("addr");
		String[] hobby = req.getParameterValues("hobby");
		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		//데뭉
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd1);
		vo.setNick(memberNick);
		vo.setAddr(addr);
		vo.setHobby(String.join(",", hobby));
		vo.setNo(no);
		
		MemberVo updatedMember = new MypageEditService().edit(vo);
		
		if(updatedMember != null) {
			 req.getSession().setAttribute("alerMsg", "회원정보 수정 성공!");
			 req.getSession().setAttribute("loginMember", updatedMember);
			 resp.sendRedirect("/semi");
		 }else {
			 req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		 }
	}
	
}
