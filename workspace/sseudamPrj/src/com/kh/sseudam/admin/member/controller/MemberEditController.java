package com.kh.sseudam.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/member/edit")
public class MemberEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mno = req.getParameter("mno");
		String pno = req.getParameter("pno");
		String quitYn = req.getParameter("quitYn");
		System.out.println("겟에딧컨트pno" + pno);
		System.out.println("겟에딧컨트quitYn" + quitYn);
		
		//디비 다녀오기
		MemberVo vo = new AdminMemberService().selectOneByNo(mno);
		
		req.setAttribute("vo", vo);
		
		req.setAttribute("pno", pno);
		req.setAttribute("quitYn", quitYn);
		
		req.getRequestDispatcher("/views/admin/member/edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//데이터 꺼내기
		String no = req.getParameter("mno");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		int test = Integer.parseInt(req.getParameter("test"));
		String pno = req.getParameter("pno");
		String quitYn = req.getParameter("quitYn");
		System.out.println("포에딧컨트pno" + pno);
		System.out.println("포에딧컨트quitYn" + quitYn);
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setNo(no);
		vo.setName(name);
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setTestScore(test);
		
		//디비 업데이트 
		int result = new AdminMemberService().updateMember(vo);
		
		if(result == 1) {
		
			req.getSession().setAttribute("alertMsg", "회원 수정 완료!");
			resp.sendRedirect("/sseudam/admin/member/edit?mno="+no+"&pno="+pno+"&quitYn="+quitYn);
			
		}else {
			req.setAttribute("msg", "관리자페이지 : 회원정보 수정 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
	}

}
