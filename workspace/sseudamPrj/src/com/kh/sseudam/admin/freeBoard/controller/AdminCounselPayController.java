package com.kh.sseudam.admin.freeBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String rangeArr[] = range.split(" ~ ");
		String startDate = rangeArr[0];
		String endDate = rangeArr[1];
		
		if(search == null) {
			search = "";
		}
		
		req.getRequestDispatcher("/views/admin/counselPay/list.jsp").forward(req, resp);
		
	}
	


}
