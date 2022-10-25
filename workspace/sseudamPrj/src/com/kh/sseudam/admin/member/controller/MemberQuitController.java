package com.kh.sseudam.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;

@WebServlet(urlPatterns = "/admin/member/quit")
public class MemberQuitController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("탈퇴들어옴");
		
		String mno = req.getParameter("mno");
		String pno = req.getParameter("pno");
		String quitYn = req.getParameter("quitYn");
		System.out.println(mno);
		System.out.println(pno);
		System.out.println(quitYn);
		
		int result = new AdminMemberService().quitOne(mno);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "회원 탈퇴 완료!");
			resp.sendRedirect("/sseudam/admin/member/edit?mno="+mno+"&pno="+pno+"&quitYn="+quitYn);
		}else {
			req.setAttribute("msg", "회원탈퇴 실패!");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
