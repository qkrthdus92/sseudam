package com.kh.sseudam.admin.freeBoard.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;

@WebServlet(urlPatterns = "/admin/freeBoard/deleteCmt")
public class AdminFreeBoardDeleteCmtController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		//리다이렉트로 넘겨야하기때문에 인코딩해야함!
		String search = URLEncoder.encode(req.getParameter("search"), "UTF-8");
		String searchType = req.getParameter("searchType");
		String cno = req.getParameter("cno");
		
		//댓글번호,글번호에 해당하는 댓글 deleteYn = 'Y'로 업데이트하기
		int result = new AdminFreeBoardService().deleteFreeBoardCmt(bno, cno);
		
		if(result == 1) {
			resp.setContentType("text/html; charset=utf-8");
			req.getSession().setAttribute("alertMsg", "자유게시판 댓글 삭제 완료");
			resp.sendRedirect("/sseudam/admin/freeBoard/detail?pno="+pno+"&bno="+bno+"&status="+status+"&search="+search+"&searchType="+searchType);
		}else {
			req.setAttribute("msg", "관리자페이지 자유게시판 댓글 삭제중 에러발생");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}