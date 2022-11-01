package com.kh.sseudam.admin.reviewBoard.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.admin.reviewBoard.service.AdminReviewBoardService;

@WebServlet(urlPatterns = "/admin/reviewBoard/writeCmt")
public class AdminReviewBoardWriteCmtController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String pno = req.getParameter("pno");
		String dno = req.getParameter("dno");
		String status = req.getParameter("status");
		//리다이렉트로 넘겨야하기때문에 인코딩해야함!
		String search = URLEncoder.encode(req.getParameter("search"), "UTF-8");
		String searchType = req.getParameter("searchType");
		String cmt = req.getParameter("cmt");
		
		//디비에 관리자 댓글 인서트
		int result = new AdminReviewBoardService().insertFreeBoardCmt(bno, cmt);
		
		if(result == 1) {
			resp.setContentType("text/html; charset=utf-8");
			req.getSession().setAttribute("alertMsg", "후기게시판 댓글 등록 완료");
			resp.sendRedirect("/sseudam/admin/reviewBoard/detail?pno="+pno+"&bno="+bno+"&dno="+dno+"&status="+status+"&search="+search+"&searchType="+searchType);
		}else {
			req.setAttribute("msg", "관리자페이지 후기게시판 댓글 등록중 에러발생");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
