package com.kh.sseudam.admin.pro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.admin.pro.service.AdminProService;

@WebServlet(urlPatterns = "/admin/pro/quit")
public class ProQuitController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("탈퇴들어옴");
		
		String mno = req.getParameter("mno");
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		System.out.println(mno);
		System.out.println(pno);
		System.out.println(status);
		
		int result = new AdminProService().quitOne(mno);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "전문가 탈퇴 완료!");
			resp.sendRedirect("/sseudam/admin/pro/edit?mno="+mno+"&pno="+pno+"&status="+status);
		}else {
			req.setAttribute("msg", "회원탈퇴 실패!");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
