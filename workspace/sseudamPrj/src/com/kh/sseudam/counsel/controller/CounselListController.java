package com.kh.sseudam.counsel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.counsel.service.CounselService;

@WebServlet(urlPatterns = "/counsel/list")
public class CounselListController extends HttpServlet{
	
	//상담하기 : 전문가 목록 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//디비 다녀오기(전문가 select)
		List<ProVo> proList = new CounselService().selectList();
		
		req.setAttribute("proList", proList);
		
		//화면 선택
		req.getRequestDispatcher("/views/counsel/list.jsp").forward(req, resp);
	}

}
