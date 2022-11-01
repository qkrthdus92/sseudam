package com.kh.sseudam.admin.reviewBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardCmtVo;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;
import com.kh.sseudam.admin.reviewBoard.service.AdminReviewBoardService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;

@WebServlet(urlPatterns = "/admin/reviewBoard/detail")
public class AdminReviewBoardDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//취소버튼 누를시에 바로 이전페이지로 이동하기위해서 이전페이지 정보 받아옴
		String pno = req.getParameter("pno");
		String search = req.getParameter("search");
		String searchType = req.getParameter("searchType");
		String status = req.getParameter("status");
		String dno = req.getParameter("dno");
		
		//글번호 받아오기
		String bno = req.getParameter("bno");
		
		req.setAttribute("pno", pno);
		req.setAttribute("search", search);
		req.setAttribute("searchType", searchType);
		req.setAttribute("status", status);
		req.setAttribute("bno", bno);
		req.setAttribute("dno", dno);
		
		//후기게시판 글번호에 해당하는 상세정보 받아오기
		AdminFreeBoardVo freeBoardVo = new AdminReviewBoardService().selectFreeBoardDetailByNo(bno);
		
		//후기게시판 글번호에 해당하는 이미지 받아오기
		List imgList = new AdminReviewBoardService().selectReviewBoardImgByNo(bno);

		List<AdminFreeBoardCmtVo> freeBoardCmtList = null;
		
		
		int currentPage = Integer.parseInt(req.getParameter("dno"));
		int pageLimit = 5;
		int boardLimit = 5;
		int listCount = 0;
		
		//자유게시판 글번호에 해당하는 댓글목록 받아오기
		if(freeBoardVo != null) {
			listCount = new AdminReviewBoardService().getCntFreeCmt(bno);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			req.setAttribute("pv", pv);
			freeBoardCmtList = new AdminReviewBoardService().selectFreeBoardCmtByNo(bno, pv);
		}
		
		
		if(freeBoardCmtList != null) {
			req.setAttribute("imgList", imgList);
			req.setAttribute("freeBoardVo", freeBoardVo);
			req.setAttribute("freeBoardCmtList", freeBoardCmtList);
			req.getRequestDispatcher("/views/admin/reviewBoard/detail.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "관리자페이지 후기게시판 상세조회 중 에러발생");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	

}
