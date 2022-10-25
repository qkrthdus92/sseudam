package com.kh.sseudam.pro.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.pro.service.ProMemberService;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.vo.ProJoinPage3Vo;

@WebServlet(urlPatterns = "/join/proJoinPage=1")
public class ProMemberJoinPageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/common/proJoin-1.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd1");
		String memberName = req.getParameter("memberName");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		String education = req.getParameter("education");
		String certificateName = req.getParameter("certificateName");
		String certificateNum = req.getParameter("certificateNum");
		String imgPath = req.getParameter("imgPath");

		String img = req.getParameter("img");
		String counselType = req.getParameter("counselType");
		String introduce = req.getParameter("introduce");
		
		//int result = new ProMemberService().projoin1(vo);
		
		boolean isPage1 = memberId != null && memberPwd != null && memberName != null && gender != null && phone != null &&  email != null;
		boolean isPage2 = education != null && certificateName != null && certificateNum != null;
		boolean isPage3 = counselType != null && introduce != null;
		
		ProJoinPage1Vo page1vo = null;
		ProJoinPage2Vo page2vo = null;
		ProJoinPage3Vo page3vo = null;
		
		if(isPage1 && !isPage2 && !isPage3) {
			page1vo = new ProJoinPage1Vo();
			
			page1vo.setId(memberId);
			page1vo.setPwd(memberPwd);
			page1vo.setName(memberName);
			page1vo.setGender(gender);
			page1vo.setPhone(phone);
			page1vo.setEmail(email);
			req.getSession().setAttribute("page1vo", page1vo);
			req.getRequestDispatcher("/views/common/proJoin-2.jsp").forward(req, resp);
		}
		
		
		if(isPage2 && !isPage1 && !isPage3){
			page2vo = new ProJoinPage2Vo();
			
			page2vo.setCertificateName(certificateName);
			page2vo.setCertificateNum(certificateNum);
			page2vo.setImgPath(imgPath);
			page2vo.setEducation(education);
			
			req.getSession().setAttribute("page2vo", page2vo);
			req.getRequestDispatcher("/views/common/proJoin-3.jsp").forward(req, resp);
		}


		if(isPage3 && !isPage1 && !isPage2) {
			page3vo = new ProJoinPage3Vo();
			
			page3vo.setImg(img);
			page3vo.setCounselType(counselType);
			page3vo.setIntroduce(introduce);
			
			page1vo = (ProJoinPage1Vo)req.getSession().getAttribute("page1vo");
			page2vo = (ProJoinPage2Vo)req.getSession().getAttribute("page2vo");
			
			isPage1 = true;
			isPage2 = true;
		}

		
		int result2 = 0;
		
		if(isPage1 && isPage2 && isPage3) {
			int result1 = new ProMemberService().projoin(page1vo, page2vo, page3vo);	//전문가 테이블
			
			if(result1 == 1) {
				result2 = new ProMemberService().projoinlicense(page2vo); //자격증 테이블
			}
			
			if(result2 == 1) {
				req.getSession().setAttribute("alertMsg", "회원가입 완료");
				resp.sendRedirect("/sseudam/main");
			}else{
				System.out.println("실패");
			}
			
		}


		
		
	}
	
}
