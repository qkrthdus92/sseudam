package com.kh.sseudam.admin.pro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.admin.pro.service.AdminProService;

@WebServlet(urlPatterns = "/admin/checkProIdDup")
public class CheckProIdDup extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("전문가 아이디 중복체크 들어옴");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("id");
		String no = req.getParameter("mno");
		boolean isNotChange = new AdminProService().checkNotChange(no, id);
		boolean isIdDup = new AdminProService().checkDup(id);
		
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
