package com.kh.sseudam.admin.reviewBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;
import com.kh.sseudam.admin.reviewBoard.service.AdminReviewBoardService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;
import com.kh.sseudam.counsel.pro.vo.ProVo;

@WebServlet(urlPatterns = "/admin/reviewBoard/list")
public class AdminReviewBoardListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search1 = req.getParameter("search");		
		String searchType = req.getParameter("searchType");

		
		if(search1 == null) {
			search1 = "";
		}
		
		int currentPage = Integer.parseInt(req.getParameter("pno"));
		int pageLimit = 5;
		int boardLimit = 10;
		int listCount = 0;
		
		List<AdminFreeBoardVo> freeBoardList = null;
		
		//자유게시판 디비다녀오기
		
		boolean isSearchTypeAll = searchType.equals("title") || searchType.equals("content") || searchType.equals("writer");
		
		//1.모든게시글조회 (+메뉴바에서 처음 접속했을때 페이지)
		if(status.equals("all") && search1.equals("") && isSearchTypeAll) {
	
			listCount = new AdminReviewBoardService().getCntFreeAll();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeAll(pv); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search1);
			req.setAttribute("searchType", "title");
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//2.게시완료조회
		if(status.equals("F") && search1.equals("") && isSearchTypeAll) {
			
			listCount = new AdminReviewBoardService().getCntFreeF();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeF(pv); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search1);
			req.setAttribute("searchType", "title");
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//3.게시취소조회
		if(status.equals("C") && search1.equals("") && isSearchTypeAll) {
			
			listCount = new AdminReviewBoardService().getCntFreeC();
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeC(pv); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search1);
			req.setAttribute("searchType", "title");
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//4.제목+모든 조회
		if(status.equals("all") && !search1.equals("") && searchType.equals("title")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeTitleAll(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeTitleAll(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//5.제목+완료 조회
		if(status.equals("F") && !search1.equals("") && searchType.equals("title")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeTitleF(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeTitleF(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//6.제목+취소 조회
		if(status.equals("C") && !search1.equals("") && searchType.equals("title")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeTitleC(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeTitleC(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//7.내용+모든 조회
		if(status.equals("all") && !search1.equals("") && searchType.equals("content")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeContentAll(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeContentAll(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//8.내용+완료 조회
		if(status.equals("F") && !search1.equals("") && searchType.equals("content")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeContentF(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeContentF(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//9.내용+취소 조회
		if(status.equals("C") && !search1.equals("") && searchType.equals("content")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeContentC(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeContentC(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//10.작성자+모든 조회
		if(status.equals("all") && !search1.equals("") && searchType.equals("writer")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeWriterAll(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeWriterAll(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//11.작성자+완료 조회
		if(status.equals("F") && !search1.equals("") && searchType.equals("writer")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeWriterF(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeWriterF(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
		//12.작성자+취소 조회
		if(status.equals("C") && !search1.equals("") && searchType.equals("writer")) {
			
			String search = search1.trim();
			listCount = new AdminReviewBoardService().getCntFreeWriterC(search);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			freeBoardList = new AdminReviewBoardService().getFreeWriterC(pv, search); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("freeBoardList", freeBoardList);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/reviewBoard/list.jsp").forward(req, resp);
			
		}
		
	}

}
