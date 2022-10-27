package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.mypage.service.MypageLikehomeService;


@WebServlet(urlPatterns = "/mypage/likehomedelete")
public class MypageLikehomeDeleteController extends HttpServlet{

	//삭제하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	String no = req.getParameter("no");
		
		int result = new MypageLikehomeService().delete(no);
		if(result == 1) {
			//성공 => 알람 , 리스트조회
			req.getSession().setAttribute("alerMsg", "삭제 성공!");
			resp.sendRedirect("/sseudam/mypage/likecheckhome?pno=1");
		}else {
			//실패 => 메세지 , 에러페이지
			req.setAttribute("msg", "삭제 실패...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	
}
