package com.kh.sseudam.admin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/member/list")
public class MemberListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String quitYn = req.getParameter("quitYn");
		String search1 = req.getParameter("search");
		String pno = req.getParameter("pno");
		
		
		List<MemberVo> memberList = null;
		int currentPage = Integer.parseInt(req.getParameter("pno"));
		int pageLimit = 5;
		int boardLimit = 10;
		
		//디비다녀오기(listCount)
		int listCount = 0;
		//이름아이디로 조회
		if(search1 != null && quitYn == null) {
			String search = search1.trim();
			listCount = new AdminMemberService().selectCntSearch(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			memberList = new AdminMemberService().selectListSearch(pv, search); 
			req.setAttribute("pno", pno);
			req.setAttribute("search", search);
			req.setAttribute("quitYn", "both");
			req.setAttribute("memberList", memberList);
			req.setAttribute("pv", pv);
			
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/member/list.jsp").forward(req, resp);
			return;
			
		}
		//모든회원조회
		if(quitYn != null && quitYn.equals("both")) {
			listCount = new AdminMemberService().selectCntAll();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			memberList = new AdminMemberService().selectListAll(pv);
			req.setAttribute("pno", pno);
			req.setAttribute("quitYn", "both");
			req.setAttribute("memberList", memberList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/member/list.jsp").forward(req, resp);
			return;
		}
		//일반회원조회
		if( quitYn != null && quitYn.equals("N")) {
			listCount = new AdminMemberService().selectCntN();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			memberList = new AdminMemberService().selectListN(pv);
			req.setAttribute("pno", pno);
			req.setAttribute("quitYn", "N");
			req.setAttribute("memberList", memberList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/member/list.jsp").forward(req, resp);
			return;
		}
		//탈퇴회원조회
		if( quitYn != null && quitYn.equals("Y")) {
			listCount = new AdminMemberService().selectCntY();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			memberList = new AdminMemberService().selectListY(pv);
			req.setAttribute("pno", pno);
			req.setAttribute("quitYn", "Y");
			req.setAttribute("memberList", memberList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/member/list.jsp").forward(req, resp);
			return;
		}
		
		
		
		

		
	}

}
