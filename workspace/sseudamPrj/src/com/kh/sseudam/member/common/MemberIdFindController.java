package com.kh.sseudam.member.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.member.service.MemberService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/findId")
public class MemberIdFindController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String memberName = req.getParameter("userName");
		String memberEmail = req.getParameter("userEmail");
		
		System.out.println("클라한테 받은 이름 :" + memberName);
		System.out.println("클라한테 받은 이메일 :" + memberEmail);
		
		MemberVo findvo = new MemberVo();
		findvo.setName(memberName);
		findvo.setEmail(memberEmail);
		
		System.out.println("findvo :" + findvo);
		
		String foundId = new MemberService().findMemberId(findvo);
		
		if(foundId != null) {
			resp.getWriter().write(memberName + " 님의 아이디는 " + foundId + " 입니다.");
		}else{
			resp.getWriter().write("입력하신 정보와 일치하는 아이디가 없습니다.");
		}
		
	}
	
}
