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

@WebServlet(urlPatterns = "/admin/reviewBoard/deleteCmt")
public class AdminReviewBoardDeleteCmtController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("댓글 삭제 컨트롤러 입장!");
		
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String pno = req.getParameter("pno");
		String dno = req.getParameter("dno");
		String status = req.getParameter("status");
		//리다이렉트로 넘겨야하기때문에 인코딩해야함!
		String search = URLEncoder.encode(req.getParameter("search"), "UTF-8");
		String searchType = req.getParameter("searchType");
		String cno = req.getParameter("cno");
		
	
		
		//댓글번호,글번호에 해당하는 댓글 deleteYn = 'Y'로 업데이트하기
		int result = new AdminReviewBoardService().deleteFreeBoardCmt(bno, cno);
		
		if(result == 1) {
			resp.setContentType("text/html; charset=utf-8");
			req.getSession().setAttribute("alertMsg", "후기게시판 댓글 삭제 완료");
			resp.sendRedirect("/sseudam/admin/reviewBoard/detail?pno="+pno+"&bno="+bno+"&dno="+dno+"&status="+status+"&search="+search+"&searchType="+searchType);
		}else {
			req.setAttribute("msg", "관리자페이지 후기게시판 댓글 삭제중 에러발생");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
