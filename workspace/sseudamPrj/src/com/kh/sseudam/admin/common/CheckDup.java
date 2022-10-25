package com.kh.sseudam.admin.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;

@WebServlet(urlPatterns = "/admin/checkDup")
public class CheckDup extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("id");
		String no = req.getParameter("mno");
		boolean isNotChange = new AdminMemberService().checkNotChange(no, id);
		boolean isIdDup = new AdminMemberService().checkDup(id);
		
		if(isNotChange) {
			resp.getWriter().write("현재 아이디입니다");
		}else {
			if(isIdDup) {
				resp.getWriter().write("이미 사용중인 아이디입니다");
			}else {
				resp.getWriter().write("사용가능한 아이디입니다");
			}
			
		}
		
	}

}
