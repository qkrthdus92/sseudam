package com.kh.sseudam.admin.freeBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;
import com.kh.sseudam.counsel.pro.vo.ProVo;

@WebServlet(urlPatterns = "/admin/freeBoard/list")
public class AdminFreeBoardListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search1 = req.getParameter("search");		
		String searchType = req.getParameter("searchType");
		
		
		List<ProVo> proList = null;
		int currentPage = Integer.parseInt(req.getParameter("pno"));
		int pageLimit = 5;
		int boardLimit = 10;
		int listCount = 0;
		
		List<FreeBoardVo> freeBoardList = null;
		
		//자유게시판 디비다녀오기
		
		//1.모든게시글조회
		if(status.equals("all") && search1==null) {
	
			listCount = new AdminFreeBoardService().getCntFreeAll();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeAll(pv); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", null);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//2.게시완료조회
		if(status.equals("F") && search1==null) {
			
			listCount = new AdminFreeBoardService().getCntFreeF();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeF(pv); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", null);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//3.게시취소조회
		if(status.equals("C") && search1==null) {
			
			listCount = new AdminFreeBoardService().getCntFreeC();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeC(pv); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", null);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//4.제목+모든 조회
		if(status.equals("all") && search1!=null && searchType.equals("title")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeTitleAll(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeTitleAll(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//5.제목+완료 조회
		if(status.equals("F") && search1!=null && searchType.equals("title")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeTitleF(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeTitleF(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//6.제목+취소 조회
		if(status.equals("C") && search1!=null && searchType.equals("title")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeTitleC(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeTitleC(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//7.내용+모든 조회
		if(status.equals("all") && search1!=null && searchType.equals("content")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeContentAll(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeContentAll(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//8.내용+완료 조회
		if(status.equals("F") && search1!=null && searchType.equals("content")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeContentF(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeContentF(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//9.내용+취소 조회
		if(status.equals("C") && search1!=null && searchType.equals("content")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeContentC(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeContentC(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//10.작성자+모든 조회
		if(status.equals("all") && search1!=null && searchType.equals("writer")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeWriterAll(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeWriterAll(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//11.작성자+완료 조회
		if(status.equals("F") && search1!=null && searchType.equals("writer")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeWriterF(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeWriterF(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
		//12.작성자+취소 조회
		if(status.equals("C") && search1!=null && searchType.equals("writer")) {
			
			String search = search1.trim();
			listCount = new AdminFreeBoardService().getCntFreeWriterC(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminFreeBoardService().getFreeWriterC(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/freeBoard/list.jsp").forward(req, resp);
			
		}
		
	
		
	}

}
