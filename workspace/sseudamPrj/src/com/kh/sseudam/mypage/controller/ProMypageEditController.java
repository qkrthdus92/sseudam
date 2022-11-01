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

import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.common.ProCertificateUploader;
import com.kh.sseudam.member.vo.MemberVo;
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
		String Name = req.getParameter("Name");
		String memberPhone = req.getParameter("memberPhone");
		String memberEmail = req.getParameter("memberEmail");
		String introduce = req.getParameter("introduce");
		String imgpath = req.getParameter("img");
		
		ProMemberJoinVo proLoginMember = (ProMemberJoinVo)session.getAttribute("proLoginMember");
		String no = proLoginMember.getNo();
		String id = proLoginMember.getId();
		String pwd = proLoginMember.getPwd();
		Part img = req.getPart("img");
		
		//자격증 파일 업로드
		String rootPath = req.getServletContext().getRealPath("/");
		
		String x = "";
		
		if(img.getSubmittedFileName().length() > 0) {
			x = ReProfileUploader.uploadFile(img, rootPath);	
		}
		
		ProMemberJoinVo vo = new ProMemberJoinVo();
		vo.setPwd(memberPwd1);
		vo.setName(Name);
		vo.setPhone(memberPhone);
		vo.setEmail(memberEmail);
		vo.setIntroduce(introduce);
		vo.setImg(x);
		vo.setNo(no);
		vo.setId(id);
		vo.setPwd(pwd);

		
		ProMemberJoinVo updatedMember = new MypageEditService().proedit(vo);
		
		if(updatedMember != null) {
			// updatedMember = new MypageEditService().proedit(vo);
			 req.getSession().setAttribute("loginMember", updatedMember);
			 resp.sendRedirect("/sseudam/views/mypage/promain.jsp");
		}else {
			
		}
		
		
	}
	
	
}//class
