package com.kh.sseudam.admin.reviewBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.admin.reviewBoard.service.AdminReviewBoardService;

@WebServlet(urlPatterns = "/admin/reviewBoard/deleteImg")
public class AdminReviewBoardDeleteImgController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String pno = req.getParameter("pno");
		String dno = req.getParameter("dno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		String searchType = req.getParameter("searchType");
		String img = req.getParameter("img");

		//이미지 테이블에 status x로 업데이트
		int result = new AdminReviewBoardService().deleteImg(img);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "이미지 삭제 완료!");
			resp.sendRedirect("/sseudam/admin/reviewBoard/edit?bno="+bno+"&pno="+pno+"&dno="+dno+"&status="+status+"&search="+search+"&searchType="+searchType);
		}else {
			req.setAttribute("msg", "이미지 삭제 실패!");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
