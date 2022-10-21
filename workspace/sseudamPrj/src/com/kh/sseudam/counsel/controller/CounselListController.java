package com.kh.sseudam.counsel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.counsel.service.CounselService;

@WebServlet(urlPatterns = "/counsel/list")
public class CounselListController extends HttpServlet{
	
	//상담하기 : 전문가 목록 조회 + 이름으로 조회 + 정렬
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String proName = req.getParameter("proName");
		String order = req.getParameter("order");
		
		if(proName == null && ( order == null || order.equals("normal"))) {

			
			//디비 다녀오기(전문가 select)
			List<ProVo> proList = new CounselService().selectList();

			req.setAttribute("proList", proList);
	
			
			//화면 선택
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
		}
		
		if(proName != null ) {
			//앞뒤 공백 제거
			proName = proName.trim();

			
			//디비 다녀오기 (이름으로 전문가 select)
			List<ProVo> proList = new CounselService().selectListByName(proName);
		
			
			req.setAttribute("proList", proList);

			
			//화면 선택
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
		}
		
		//최근등록순
		if(order != null && order.equals("latest")) {
			
			List<ProVo> proList = new CounselService().selectListByLatest();
			
			req.setAttribute("proList", proList);
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		if(order != null && order.equals("star")) {
			List<ProVo> proList = new CounselService().selectListByStar();
			
			req.setAttribute("proList", proList);
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		if(order != null && order.equals("review")) {
			List<ProVo> proList = new CounselService().selectListByReview();
			
			req.setAttribute("proList", proList);
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		if(order != null && order.equals("maxPrice")) {
			List<ProVo> proList = new CounselService().selectListByMaxPrice();
			
			req.setAttribute("proList", proList);
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		if(order != null && order.equals("minPrice")) {
			List<ProVo> proList = new CounselService().selectListByMinPrice();
			
			req.setAttribute("proList", proList);
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
	}
	
	//상담하기 : 전문가 상담분야, 상세조건으로 조회
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기 
		String counselTypeArr[] = req.getParameterValues("counselType");
		String proLevel[] = req.getParameterValues("proLevel");
		String gender = req.getParameter("gender");
		String certificate = req.getParameter("certificate");
		
		//디비 다녀오기 
		List<ProVo> proList = new CounselService().selectListByVal(counselTypeArr, proLevel, gender, certificate);
		
		req.setAttribute("proList", proList);
		
		
		//화면 선택
		req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
	}

}
