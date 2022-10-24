package com.kh.sseudam.counsel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.counsel.service.CounselService;

@WebServlet(urlPatterns = "/counsel/detail")
public class CounselDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bno = req.getParameter("bno");
		
		ProVo vo = new CounselService().selectListByNo(bno);
		List<CertificateVo> cerList = new CounselService().selectCerByNo(bno);
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.setAttribute("cerList", cerList);
			req.getRequestDispatcher("/views/counsel/detail.jsp").forward(req, resp);
		}
	}

}
