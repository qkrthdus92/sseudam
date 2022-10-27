package com.kh.sseudam.admin.pro.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.FileUploader;
import com.kh.sseudam.counsel.pro.vo.ProVo;


@WebServlet(urlPatterns = "/admin/pro/add")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 , 
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
		
		)


public class ProAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		System.out.println("add get들어옴!");
		System.out.println(pno);
		System.out.println(status);
		System.out.println(search);
		
		req.setAttribute("pno", pno);
		req.setAttribute("status", status);
		req.setAttribute("search", search);
		
		req.getRequestDispatcher("/views/admin/pro/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		System.out.println("add post들어옴!");
		//수정 후 리다이렉트할 페이지 정보
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		
		System.out.println("t"+pno);
		System.out.println("t"+status);
		System.out.println("t"+search);
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String counselType = req.getParameter("counselType");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String education = req.getParameter("education");
		String phone = req.getParameter("phone");
		String introduce = req.getParameter("introduce");
		Part f = req.getPart("f");
		
		AttachmentVo aVo = null;
		
		String rootPath = req.getServletContext().getRealPath("/");
		if(f.getSubmittedFileName().length() > 0) {
			aVo = FileUploader.uploadFile(f, rootPath, "resources/upload/pro");
		}
		
		
		ProVo vo = new ProVo();
		vo.setName(name);
		vo.setId(id);
		vo.setCounselType(counselType);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setGender(gender);
		vo.setEducation(education);
		vo.setIntroduce(introduce);
		vo.setPhone(phone);
		
		int result = new AdminProService().insertOne(vo, aVo);
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "전문가 추가 완료!");
			resp.sendRedirect("/sseudam/admin/pro/list?&pno="+pno+"&status="+status+"&search="+search);
			//resp.sendRedirect("/sseudam/admin/pro/list?pno=1&status=all");
		}else {
			if(aVo != null) {
				String savePath = rootPath + aVo.getFilePath() + "/" + aVo.getChangeName();
				new File(savePath).delete();
			}
			req.setAttribute("msg", "관리자페이지 : 회원 추가 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
