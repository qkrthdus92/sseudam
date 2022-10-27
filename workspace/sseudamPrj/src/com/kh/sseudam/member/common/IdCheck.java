package com.kh.sseudam.member.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.member.service.MemberService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/IdCheck")
public class IdCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//데이터 꺼내기
		String idCheck = req.getParameter("checkID");
		
		//디비 다녀오기
		boolean isIdDup = new MemberService().checkDup(idCheck);
		
		//응답
		if(isIdDup) {
			resp.getWriter().write("현재 사용 중인 아이디입니다.");
		}else {
			resp.getWriter().write("사용 가능한 아이디입니다.");
		}
	}
	
}
