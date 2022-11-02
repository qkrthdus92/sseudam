package com.kh.sseudam.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.sseudam.mypage.service.MypageEditService;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

@WebServlet(urlPatterns = "/mypage/proeditmypage")
@MultipartConfig(
		//location = "/khtmp" ,
		fileSizeThreshold = 1024 * 1024 ,	//컴터에선 1024 단위로, 걍 크기 지정한 것
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
	)
public class ProMypageEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		ProMemberJoinVo proLoginMember = (ProMemberJoinVo)s.getAttribute("proLoginMember");
		
		/*
		 * String num = proLoginMember.getNo(); System.out.println(num); //확인용
		 * 
		 * String updatestar =new MypageEditService().updatestar(num);
		 * 
		 * System.out.println(updatestar); //확인용
		 * 
		 * req.setAttribute("updatestar", updatestar);
		 * req.getRequestDispatcher("/views/mypage/promain.jsp").forward(req, resp);
		 */
		
		if(proLoginMember != null) {
			req.getRequestDispatcher("/views/mypage/proeditmypage.jsp").forward(req, resp);
		}else {
			//에러페이지
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session= req.getSession();
		
		//프로멤버 데이터 꺼내기
		String memberPwd1 = req.getParameter("memberPwd1");
		String memberPhone = req.getParameter("memberPhone");
		String memberEmail = req.getParameter("memberEmail");
		String introduce = req.getParameter("introduce");
		Part img = req.getPart("img");
		
		System.out.println(img);//확인용//넘어옴
		
		ProMemberJoinVo proLoginMember = (ProMemberJoinVo)session.getAttribute("proLoginMember");
		String no = proLoginMember.getNo();
		String pwd = proLoginMember.getPwd();
		String id = proLoginMember.getId();
		
		
		//-----------파일업로드 시작--------------------------
		String rootPath = req.getServletContext().getRealPath("/");
		System.out.println(rootPath);
		String x = "";
		
		if(img.getSubmittedFileName().length() > 0) {
			x = ReProfileUploader.uploadFile(img, rootPath);	
		}
		//-----------파일업로드 끝--------------------------
		
		ProMemberJoinVo vo = new ProMemberJoinVo();
		vo.setPwd(memberPwd1);
		vo.setPhone(memberPhone);
		vo.setEmail(memberEmail);
		vo.setIntroduce(introduce);
		vo.setImg(x);
		vo.setNo(no);
		vo.setPwd(pwd);
		vo.setId(id);

		System.out.println(vo);
		
		ProMemberJoinVo proupdatedMember = new MypageEditService().proedit(vo);
		
		
		if(proupdatedMember != null) {
			 req.getSession().setAttribute("proLoginMember", proupdatedMember);
			 resp.sendRedirect("/sseudam/views/mypage/promain.jsp");
		}else {
			
		}
		
		
	}
	
	
}//class
