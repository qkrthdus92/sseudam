package com.kh.sseudam.stress.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.stress.service.StressService;

import oracle.jdbc.driver.HAManager;

@WebServlet(urlPatterns = "/stress/stressTest")
public class StressTestController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인여부 확인
		if(req.getSession().getAttribute("loginMember") == null && req.getSession().getAttribute("proLoginMember") != null) {
			req.setAttribute("msg", "일반회원만 이용이 가능합니다.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}else if(req.getSession().getAttribute("loginMember") == null){
			req.setAttribute("msg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/views/stress/stressTest.jsp").forward(req, resp);				
		}
		
	}
	
}
