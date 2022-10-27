package com.kh.sseudam.admin.pro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.admin.pro.vo.ProCounselListVo;
import com.kh.sseudam.admin.pro.vo.ProCounselVo;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;


@WebServlet(urlPatterns = "/admin/pro/counsel")
public class ProCounselController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mno = req.getParameter("mno");
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		
		System.out.println(mno);
		System.out.println(pno);
		System.out.println(status);
		System.out.println(search);
		
		//디비 다녀오기 (누적수익, 평균별점, 상담완료, 상담대기/상담내역 전체)

		String profit = new AdminProService().getProfit(mno); //누적수익
		String avgStar = new AdminProService().getAvgStar(mno); //평균별점
		String finishCnt = new AdminProService().getFinishCnt(mno); //상담완료카운트
		String waitCnt = new AdminProService().getWaitCnt(mno); //상담대기카운트

		ProCounselVo pcv = new ProCounselVo();
		pcv.setNo(mno);
		pcv.setProfit(profit);
		pcv.setAvgStar(avgStar);
		pcv.setFinishCnt(finishCnt);
		pcv.setWaitCnt(waitCnt);
		

		//상담내역전체
		List<ProCounselListVo> counselList = new AdminProService().getCounselList(mno);

		req.setAttribute("pcv", pcv);
		req.setAttribute("counselList", counselList);
		
		req.setAttribute("pno", pno);
		req.setAttribute("status", status);
		req.setAttribute("search", search);
		
		req.getRequestDispatcher("/views/admin/pro/counsel.jsp").forward(req, resp);
	}

}
