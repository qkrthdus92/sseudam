package com.kh.sseudam.admin.counselPay.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.counselPay.service.AdminCounselPayService;
import com.kh.sseudam.admin.counselPay.vo.CounselPayVo;
import com.kh.sseudam.admin.counselPay.vo.SearchVo;
import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;

@WebServlet(urlPatterns = "/admin/counselPay/list")
public class AdminCounselPayController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");		
		String searchType = req.getParameter("searchType");
		String range = req.getParameter("range");
		
		
		if(range.equals("")) {
			System.out.println("랜지 널임!");
			LocalDate now = LocalDate.now();
			range = "2022-01-01 ~ " + now;
		}
		
		String rangeArr[] = range.split(" ~ ");
		String startDate = rangeArr[0];
		String endDate = rangeArr[1];
		
		List<CounselPayVo> list = null;
		int currentPage = Integer.parseInt(req.getParameter("pno"));
		int pageLimit = 5;
		int boardLimit = 10;
		int listCount = 0;
		
		boolean isSearchTypeAll = searchType.equals("memberInfo") || searchType.equals("proInfo") ;
		
		SearchVo vo = new SearchVo();
		vo.setSearch(search);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);
		
		//1. 검색어="" 검색타입=상관x status=all (기본페이지)
		if(status.equals("all") && search.equals("") && isSearchTypeAll ) {
			
			listCount = new AdminCounselPayService().getCntCounselAll(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselAll(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "memberInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//2. 검색어="" 검색타입=상관x status=F
		if(status.equals("F") && search.equals("") && isSearchTypeAll ) {
			
			listCount = new AdminCounselPayService().getCntCounselF(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselF(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "memberInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		
		//3. 검색어="" 검색타입=상관x status=C
		if(status.equals("C") && search.equals("") && isSearchTypeAll ) {
			
			listCount = new AdminCounselPayService().getCntCounselC(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselC(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "memberInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//4. 검색어=O 검색타입=사용자 status=all
		if(status.equals("all") && !search.equals("") && searchType.equals("memberInfo")) {
			
			listCount = new AdminCounselPayService().getCntCounselMemAll(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselMemAll(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "memberInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//5. 검색어=O 검색타입=사용자 status=F
		if(status.equals("F") && !search.equals("") && searchType.equals("memberInfo")) {
			
			listCount = new AdminCounselPayService().getCntCounselMemF(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselMemF(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "memberInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//6. 검색어=O 검색타입=사용자 status=C
		if(status.equals("C") && !search.equals("") && searchType.equals("memberInfo")) {
			
			listCount = new AdminCounselPayService().getCntCounselMemC(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselMemC(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "memberInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//7. 검색어=O 검색타입=전문가 status=all
		if(status.equals("all") && !search.equals("") && searchType.equals("proInfo")) {
			
			listCount = new AdminCounselPayService().getCntCounselProAll(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselProAll(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "all");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "proInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//8. 검색어=O 검색타입=전문가 status=F
		if(status.equals("F") && !search.equals("") && searchType.equals("proInfo")) {
			
			listCount = new AdminCounselPayService().getCntCounselProF(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselProF(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "F");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "proInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
		//9. 검색어=O 검색타입=전문가 status=C
		if(status.equals("C") && !search.equals("") && searchType.equals("proInfo")) {
			
			listCount = new AdminCounselPayService().getCntCounselProC(vo);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			list = new AdminCounselPayService().getCounselProC(pv, vo); 
			
			req.setAttribute("pno", pno);
			req.setAttribute("status", "C");
			req.setAttribute("search", search);
			req.setAttribute("searchType", "proInfo");
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("range", range);
			
			req.setAttribute("list", list);
			req.setAttribute("pv", pv);
			req.setAttribute("listCount", Integer.toString(listCount));
			
			req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
			
		}
		
	}

}
