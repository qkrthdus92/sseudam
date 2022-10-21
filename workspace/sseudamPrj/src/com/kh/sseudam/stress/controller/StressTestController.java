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
import temp.MemberVo;

@WebServlet(urlPatterns = "/stress/stressTest")
public class StressTestController extends HttpServlet{

	//테스트점수 회원정보 저장
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/stress/stressTest.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int score1 = Integer.parseInt(req.getParameter("test1"));
		int score2 = Integer.parseInt(req.getParameter("test2"));
		int score3 = Integer.parseInt(req.getParameter("test3"));
		int score4 = Integer.parseInt(req.getParameter("test4"));
		int score5 = Integer.parseInt(req.getParameter("test5"));
		int score6 = Integer.parseInt(req.getParameter("test6"));
		int score7 = Integer.parseInt(req.getParameter("test7"));
		int score8 = Integer.parseInt(req.getParameter("test8"));
		int score9 = Integer.parseInt(req.getParameter("test9"));
		int score10 = Integer.parseInt(req.getParameter("test10"));
		int score11 = Integer.parseInt(req.getParameter("test11"));
		int score12 = Integer.parseInt(req.getParameter("test12"));
		int score13 = Integer.parseInt(req.getParameter("test13"));
		
		int testScore = score1 + score2 + score3 + score4 + score5 + score6 + score7
				+ score8 + score9 + score10 + score11 + score12 + score13;
		
		
		MemberVo vo = new MemberVo();
		vo.setTestScore(testScore);
		
		int result = new StressService().myScore(vo);
		
		if(result == 1) {
			resp.sendRedirect("/views/stress/stressResult.jsp");
		} else {
			System.out.println("테스트실패");
		}
		
	}
	
}
