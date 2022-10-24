package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.service.MypageEditService;

@WebServlet(urlPatterns = "/mypage/proeditmypage")
public class ProMypageEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		ProVo ProloginMember = (ProVo)s.getAttribute("ProloginMember");
		if(ProloginMember != null) {
			req.getRequestDispatcher("/views/mypage/proeditmypage.jsp").forward(req, resp);
		}else {
			//에러페이지
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session= req.getSession();
		
		//프로멤버 데이터 꺼내기
		String memberPwd1 = req.getParameter("memberPwd1");
		String Name = req.getParameter("Name");
		String memberPhone = req.getParameter("memberPhone");
		String memberEmail = req.getParameter("memberEmail");
		String introduce = req.getParameter("introduce");
		
		ProVo ProloginMember = (ProVo)session.getAttribute("ProloginMember");
		String no = ProloginMember.getNo();
		
		ProVo vo = new ProVo();
		vo.setPwd(memberPwd1);
		vo.setName(Name);
		vo.setPhone(memberPhone);
		vo.setEmail(memberEmail);
		vo.setIntroduce(introduce);

		
		ProVo updatedMember = new MypageEditService().proedit(vo);
		
		
	}
	
	
}//class
