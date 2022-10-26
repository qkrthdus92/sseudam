package com.kh.sseudam.admin.pro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;
import com.kh.sseudam.counsel.pro.vo.ProVo;

@WebServlet(urlPatterns = "/admin/pro/list")
public class ProListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		String pno = req.getParameter("pno");
		String search1 = req.getParameter("search");
		
		List<ProVo> proList = null;
		int currentPage = Integer.parseInt(req.getParameter("pno"));
		int pageLimit = 5;
		int boardLimit = 10;
		int listCount = 0;
		
		//디비다녀오기
		
		//이름아이디로 조회
		if(search1 != null && status == null) {
			String search = search1.trim();
			listCount = new AdminProService().selectCntSearch(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			proList = new AdminProService().selectListSearch(pv, search); 
			req.setAttribute("pno", pno);
			req.setAttribute("search", search);
			req.setAttribute("status", "all");
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/pro/list.jsp").forward(req, resp);
			
		}
		
		//모든전문가조회
		if(status != null && status.equals("all")) {
			listCount = new AdminProService().selectCntAll();
			System.out.println(listCount);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			proList = new AdminProService().selectListAll(pv);
			System.out.println(proList);
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/pro/list.jsp").forward(req, resp);
		}
		
		//승인대기조회
		if(status != null && status.equals("W")) {
			listCount = new AdminProService().selectCntW();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			proList = new AdminProService().selectListW(pv);
			req.setAttribute("pno", pno);
			req.setAttribute("status", "W");
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/pro/list.jsp").forward(req, resp);
		}
		
		//승인완료회원조회
		if(status != null && status.equals("J")) {
			listCount = new AdminProService().selectCntJ();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			proList = new AdminProService().selectListJ(pv);
			req.setAttribute("pno", pno);
			req.setAttribute("status", "J");
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/pro/list.jsp").forward(req, resp);
		}
		//탈퇴회원조회
		if(status != null && status.equals("Q")) {
			listCount = new AdminProService().selectCntQ();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			proList = new AdminProService().selectListQ(pv);
			req.setAttribute("pno", pno);
			req.setAttribute("status", "Q");
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			req.getRequestDispatcher("/views/admin/pro/list.jsp").forward(req, resp);
		}
		
		
	
	}
}
