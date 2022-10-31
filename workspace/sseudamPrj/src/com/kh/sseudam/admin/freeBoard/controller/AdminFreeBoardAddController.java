package com.kh.sseudam.admin.freeBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;

@WebServlet(urlPatterns = "/admin/freeBoard/write")
public class AdminFreeBoardAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		//취소버튼 누를시에 바로 이전페이지로 이동하기위해서 이전페이지 정보 받아옴
		String pno = req.getParameter("pno");
		String search = req.getParameter("search");
		String searchType = req.getParameter("searchType");
		String status = req.getParameter("status");
		
		req.setAttribute("pno", pno);
		req.setAttribute("search", search);
		req.setAttribute("searchType", searchType);
		req.setAttribute("status", status);
		req.getRequestDispatcher("/views/admin/freeBoard/add.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		AdminFreeBoardVo vo = new AdminFreeBoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = new AdminFreeBoardService().insertFreeBoard(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "자유게시판 게시글 작성 완료");
			resp.sendRedirect("/sseudam/admin/freeBoard/list?pno=1&status=all&searchType=title&search=");
		}else {
			req.setAttribute("msg", "관리자페이지 자유게시판 게시글 작성 실패!");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
