package com.kh.sseudam.member.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.member.service.MemberService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/findPwd")
public class MemberPwdFindController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String memberName = req.getParameter("userName");
		String memberId = req.getParameter("memberId");
		String memberEmail = req.getParameter("userEmail");
		
		System.out.println("클라한테 받은 이름 :" + memberName);
		System.out.println("클라한테 받은 아이디 :" + memberId);
		System.out.println("클라한테 받은 이메일 :" + memberEmail);
		
		MemberVo findpwdvo = new MemberVo();
		findpwdvo.setName(memberName);
		findpwdvo.setName(memberId);
		findpwdvo.setEmail(memberEmail);
		
		String foundPwd = new MemberService().findMemberPwd(findpwdvo);
		
		if(foundPwd != null) {
			resp.getWriter().write(memberName + " 님의 비밀번호는 " + foundPwd + " 입니다.");
		}else{
			resp.getWriter().write("입력하신 정보와 일치하는 아이디가 없습니다.");
		}
	
	}
	
}
