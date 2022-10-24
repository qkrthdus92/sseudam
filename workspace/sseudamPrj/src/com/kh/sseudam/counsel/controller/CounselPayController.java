package com.kh.sseudam.counsel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.counsel.pro.vo.CounselCnt;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.counsel.pro.vo.ReserveVo;
import com.kh.sseudam.counsel.service.CounselService;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/counsel/pay")
public class CounselPayController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bno = req.getParameter("bno");
		
		ProVo vo = new CounselService().selectListByNo(bno);
		
		//상담횟수가 3회 이상인 날짜 리스트 가져오기
		List<CounselCnt> dateList = new CounselService().selectDateListByNo(bno);
		System.out.println(dateList);
		String counselDateAll = "";
		for(int i=1; i <= dateList.size(); i++) {
			counselDateAll += ("'"+dateList.get(i-1).getCounselDate()+"'");
			if(i != dateList.size()) {
				counselDateAll += ",";
			}
		}
		System.out.println(counselDateAll);
		
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.setAttribute("dateList", counselDateAll);
			req.getRequestDispatcher("/views/counsel/pay.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		HttpSession s = req.getSession();
//		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
//		String memberNo = loginMember.getNo();
		String memberNo = "1";
		String proNo = req.getParameter("bno");
		System.out.println("전문가번호 : " + proNo);
		ProVo proVo = new CounselService().selectListByNo(proNo);
		String counselDate = req.getParameter("counselDate");
		String payway = req.getParameter("payway");
		

		System.out.println(counselDate);
		ReserveVo vo = new ReserveVo();
		vo.setMemberNo(memberNo);
		vo.setProNo(proNo);
		vo.setCounselDate(counselDate);
		vo.setPayway(payway);
		vo.setPrice(proVo.getPrice());
		
		int result = new CounselService().insertReserve(vo);
		
		if(result == 1) {
			resp.sendRedirect("sseudam/mypage/resercheck");
		}else {
			
		}
	}

}
