package com.kh.sseudam.stress.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.stress.service.StressService;
import com.kh.sseudam.stress.vo.StressVo;

@WebServlet(urlPatterns = "/stress/stressResult")
public class StressResultController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/stress/stressResult.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8");

		// 로그인멤버 가져오기
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");
		System.out.println(loginMember);

		// 각 문항별 스트레스 테스트 점수 가져오기
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

		// 점수 합계 계산
		int testScore = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8 + score9 + score10
				+ score11 + score12 + score13;

		// 점수에 맞는 추천컨텐츠 리스트 가져오기
		List<StressVo> suggestList = new StressService().suggestContent(testScore);
		req.setAttribute("suggestList", suggestList);

		// 점수 결과를 회원 정보에 저장
		loginMember.setTestScore(testScore);
		int result = new StressService().myScore(loginMember);
		
		if (result == 1) {
			req.getRequestDispatcher("/views/stress/stressResult.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
