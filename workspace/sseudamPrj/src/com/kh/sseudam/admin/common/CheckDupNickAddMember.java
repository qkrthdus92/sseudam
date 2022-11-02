package com.kh.sseudam.admin.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;

@WebServlet(urlPatterns = "/admin/addMember/checkDupNick")
public class CheckDupNickAddMember extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String nick = req.getParameter("nick");
	
		boolean isNickDup = new AdminMemberService().checkDupNick(nick);
		
		if(isNickDup) {
			resp.getWriter().write("이미 사용중인 닉네임입니다");
		}else if(nick.trim().equals("")) {
			resp.getWriter().write("닉네임을 입력해주세요");
		}else {
			resp.getWriter().write("사용가능한 닉네임입니다");
		}
	}
}
