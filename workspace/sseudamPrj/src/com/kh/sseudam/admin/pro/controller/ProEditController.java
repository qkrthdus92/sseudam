package com.kh.sseudam.admin.pro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/pro/edit")
public class ProEditController extends HttpServlet{
	
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
		
		//디비 다녀오기
		ProVo vo = new AdminProService().selectOneByNo(mno);
		List<CertificateVo>  voList = new AdminProService().selectCerByBo(mno);
		
		req.setAttribute("proVo", vo);
		req.setAttribute("voList", voList);
		
		req.setAttribute("pno", pno);
		req.setAttribute("status", status);
		req.setAttribute("search", search);
		
		req.getRequestDispatcher("/views/admin/pro/edit.jsp").forward(req, resp);
	}

}
