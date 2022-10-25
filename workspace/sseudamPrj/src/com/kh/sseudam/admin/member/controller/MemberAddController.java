package com.kh.sseudam.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/member/add")
public class MemberAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/member/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String nick = req.getParameter("nick");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setId(id);
		vo.setNick(nick);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setPhone(phone);
		
		int result = new AdminMemberService().insertOne(vo);
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "회원 추가 완료!");
			resp.sendRedirect("/sseudam/admin/member/list?pno=1&quitYn=both");
		}else {
			req.setAttribute("msg", "관리자페이지 : 회원 추가 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
