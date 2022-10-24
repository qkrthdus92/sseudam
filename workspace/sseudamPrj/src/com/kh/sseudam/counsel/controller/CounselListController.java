package com.kh.sseudam.counsel.controller;

import java.io.IOException;
import java.util.Arrays;
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
		
		//데이터 꺼내기 
		String counselTypeArr[] = req.getParameterValues("counselType");
		String proLevel[] = req.getParameterValues("proLevel");
		String gender = req.getParameter("gender");
		String certificate = req.getParameter("certificate");
		
		boolean isChoose = (counselTypeArr != null) || (proLevel != null) || (gender != null) || (certificate != null);
		
		//기본정렬 = 최근등록순 (pv완료)
		if(!isChoose && proName == null && ( order == null || order.equals("latest"))) {

			//디비 다녀오기 (카운트)
			
			int listCount = new CounselService().cntProAll();
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			
			//디비 다녀오기(전문가 select)
			List<ProVo> proList = new CounselService().selectListByLatest(pv);

			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("order", "latest");
	
			
			//화면 선택
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
		}
		
		//이름으로 검색
		if(proName != null ) {
			//앞뒤 공백 제거
			proName = proName.trim();
			
			//디비 다녀오기 (카운트)
			
			int listCount = new CounselService().cntProByName(proName);
			
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			System.out.println(listCount);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);

			
			//디비 다녀오기 (이름으로 전문가 select)
			List<ProVo> proList = new CounselService().selectListByName(proName, pv);
		
			
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("proName", proName);

			
			//화면 선택
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			return;
		}
		
		//최근등록순
//		if(order != null && order.equals("latest")) {
//			
//			List<ProVo> proList = new CounselService().selectListByLatest();
//			
//			req.setAttribute("proList", proList);
//			
//			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
//			
//		}
		
		//평점순(pv완료)
		if(order != null && order.equals("star")) {
			
			//디비 다녀오기 (카운트)
			
			int listCount = new CounselService().cntProAll();
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			
			List<ProVo> proList = new CounselService().selectListByStar(pv);
			
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("order", "star");
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		
		//후기많은순(pv완료)
		if(order != null && order.equals("review")) {
			
			//디비 다녀오기 (카운트)
			
			int listCount = new CounselService().cntProAll();
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			
			List<ProVo> proList = new CounselService().selectListByReview(pv);
			
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("order", "review");
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		
		//높은가격순(pv완료)
		if(order != null && order.equals("maxPrice")) {
			//디비 다녀오기 (카운트)
			
			int listCount = new CounselService().cntProAll();
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			List<ProVo> proList = new CounselService().selectListByMaxPrice(pv);
			
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("order", "maxPrice");
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		
		//낮은가격순(pv완료)
		if(order != null && order.equals("minPrice")) {
			//디비 다녀오기 (카운트)
			
			int listCount = new CounselService().cntProAll();
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			List<ProVo> proList = new CounselService().selectListByMinPrice(pv);
			
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			req.setAttribute("order", "minPrice");
			
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
		
		
		
		
		
		String reqCounselType = "";
		if(counselTypeArr != null) {
			for(int i=0; i<counselTypeArr.length; i++) {
				reqCounselType += "counselType=" + counselTypeArr[i];
				if(i!=(counselTypeArr.length-1)) {
					reqCounselType += "&";
				}
			}
			
		}
		
		String reqProLevel = "";
		if(proLevel != null) {
			for(int i=0; i<proLevel.length; i++) {
				reqProLevel += "proLevel=" + proLevel[i];
				if(i!=(proLevel.length-1)) {
					reqProLevel += "&";
				}
			}
			
		}
		
		if(counselTypeArr != null || proLevel != null || gender != null || certificate != null) {
			req.setAttribute("choose", "ok");
			//디비 다녀오기 (카운트)
			int listCount = 0;
			//int listCount = new CounselService().cntProAll();
			listCount = new CounselService().cntProByVal(counselTypeArr, proLevel, gender, certificate);
			
			if(proLevel != null && (proLevel.length == 1 || proLevel.length == 2)) {
				listCount = new CounselService().cntLevel3(counselTypeArr, proLevel, gender, certificate);
				System.out.println(listCount + "전문가수!!!!");
			}
			
		
			
			int currentPage = Integer.parseInt(req.getParameter("pno"));
			int pageLimit = 5;
			int boardLimit = 6;
			
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			System.out.println(pv);
			//디비 다녀오기 
			List<ProVo> proList = new CounselService().selectListByVal(counselTypeArr, proLevel, gender, certificate, pv);
			System.out.println("전문가수"+proList.size());
			req.setAttribute("proList", proList);
			req.setAttribute("pv", pv);
			
			req.setAttribute("counselType", reqCounselType);
			req.setAttribute("proLevel", reqProLevel);
			req.setAttribute("gender", gender);
			req.setAttribute("certificate", certificate);
			
			
			//화면 선택
			req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
			
		}
	}
	
	//상담하기 : 전문가 상담분야, 상세조건으로 조회
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
//		req.setCharacterEncoding("UTF-8");
//		
//		//데이터 꺼내기 
//		String counselTypeArr[] = req.getParameterValues("counselType");
//		String proLevel[] = req.getParameterValues("proLevel");
//		String gender = req.getParameter("gender");
//		String certificate = req.getParameter("certificate");
//		
//		String reqCounselType = "";
//		if(counselTypeArr != null) {
//			for(int i=0; i<counselTypeArr.length; i++) {
//				reqCounselType += "counselType=" + counselTypeArr[i];
//				if(i!=(counselTypeArr.length-1)) {
//					reqCounselType += "&";
//				}
//			}
//			
//		}
//		
//		String reqProLevel = "";
//		if(proLevel != null) {
//			for(int i=0; i<proLevel.length; i++) {
//				reqProLevel += "proLevel=" + proLevel[i];
//				if(i!=(proLevel.length-1)) {
//					reqProLevel += "&";
//				}
//			}
//			
//		}
//		
//		
//		
//		
//		//디비 다녀오기 (카운트)
//		
//		//int listCount = new CounselService().cntProAll();
//		int listCount = new CounselService().cntProByVal(counselTypeArr, proLevel, gender, certificate);
//		int currentPage = Integer.parseInt(req.getParameter("pno"));
//		int pageLimit = 5;
//		int boardLimit = 6;
//		
//		PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
//		System.out.println(pv);
//		//디비 다녀오기 
//		List<ProVo> proList = new CounselService().selectListByVal(counselTypeArr, proLevel, gender, certificate, pv);
//		System.out.println("전문가수"+proList.size());
//		req.setAttribute("proList", proList);
//		req.setAttribute("pv", pv);
//		
//		if(counselTypeArr != null || proLevel != null || gender != null || certificate != null) {
//			req.setAttribute("choose", "ok");
//			
//		}
//		
//		req.setAttribute("counselType", reqCounselType);
//		req.setAttribute("proLevel", reqProLevel);
//		req.setAttribute("gender", gender);
//		req.setAttribute("certificate", certificate);
//		
//		
//		//화면 선택
//		req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
	}

}
