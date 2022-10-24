package com.kh.sseudam.admin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.MemberService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/member/list")
public class MemberListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//디비다녀오기(listCount)
		int listCount = new MemberService().selectCntAll();
		int currentPage = Integer.parseInt(req.getParameter("pno"));
		int pageLimit = 5;
		int boardLimit = 10;
		
		PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
		
		//디비다녀오기 
		List<MemberVo> memberList = new MemberService().selectListAll(pv);
		
		
		//화면 선택
		req.setAttribute("memberList", memberList);
		req.setAttribute("pv", pv);
		req.getRequestDispatcher("/views/admin/member/list.jsp").forward(req, resp);
		
	}

}
