package com.kh.sseudam.pro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.common.ProCertificateUploader;
import com.kh.sseudam.member.common.ProfIleUploader;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.pro.service.ProMemberService;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.vo.ProJoinPage3Vo;

import oracle.net.aso.f;

@WebServlet(urlPatterns = "/join/proJoinPage")
@MultipartConfig(
		//location = "/khtmp" ,
		fileSizeThreshold = 1024 * 1024 ,	//컴터에선 1024 단위로, 걍 크기 지정한 것
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
	)
public class ProMemberJoinPageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/common/proJoin-1.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String pageNo = req.getParameter("page");
		ProJoinPage1Vo proVo1 = new ProJoinPage1Vo();
		ProJoinPage2Vo proVo2 = new ProJoinPage2Vo();
		ProJoinPage3Vo proVo3 = new ProJoinPage3Vo();
		
		if(pageNo.equals("1")) {
			
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd1");
			String memberName = req.getParameter("memberName");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			proVo1.setId(memberId);
			proVo1.setPwd(memberPwd);
			proVo1.setName(memberName);
			proVo1.setGender(gender);
			proVo1.setPhone(phone);
			proVo1.setEmail(email);
			
			System.out.println(proVo1); //확인용
			
			req.setAttribute("proVo1", proVo1);
			req.getRequestDispatcher("/views/common/proJoin-2.jsp").forward(req, resp);
			
		} else if(pageNo.equals("2")) {
			
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd1");
			String memberName = req.getParameter("memberName");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			String education = req.getParameter("education");
			
			//전문가 자격 정보 및 파일
			String[] cerNameArr = req.getParameterValues("certificateName");
			String[] cerNumArr = req.getParameterValues("certificateNum");
			List<Part> parts = (List<Part>) req.getParts();
			
//			List<Part> filePart = new ArrayList<>();
			
//			for(int i = 0; i < partArr.size(); ++i) {
//				String temp = partArr.get(i).getContentType();	//타입을 꺼냄
//				if(temp.startsWith("image")) {		//타입이 image라면
//					filePart.add(partArr.get(i));	//꺼내온 걸 filePart에 추가함
//				}
//			}
			
			List<ProJoinPage2Vo> list = new ArrayList<ProJoinPage2Vo>();
			int cerResult = 0;
			for(int i=0; i<parts.size(); i++) {
				System.out.println("자격파일1");
				Part part = parts.get(i);
				if(!part.getName().equals("f")) continue; //f로 들어온 Part가 아니면 스킵
				if(part.getSubmittedFileName().equals("")) continue; //업로드 된 파일 이름이 없으면 스킵
				
				String rootPath = req.getServletContext().getRealPath("/");
				
				ProJoinPage2Vo aVo = null;
				if(part.getSubmittedFileName().length() > 0) {
					aVo = ProCertificateUploader.uploadFile(part, rootPath, "resources/upload/certificate");
				}
				
				System.out.println("자격파일2");
				list.add(aVo);

				
			}
			
			for(int i=0; i<list.size(); i++) {
				//데이터뭉치기
				CertificateVo cv = new CertificateVo();		
				cv.setName(cerNameArr[i]);
				cv.setNum(cerNumArr[i]);
				
				//디비다녀오기
				cerResult = new ProMemberService().projoinlicense(cv, list.get(i));
			}
			
//			//자격증 파일 업로드
//			String rootPath = req.getServletContext().getRealPath("/");
//			
//			String x = "";
//			
//			if(imgPath.getSubmittedFileName().length() > 0) {
//				x = ProCertificateUploader.uploadFile(imgPath, rootPath);	
//			}
			
			proVo1.setId(memberId);
			proVo1.setPwd(memberPwd);
			proVo1.setName(memberName);
			proVo1.setGender(gender);
			proVo1.setPhone(phone);
			proVo1.setEmail(email);
			
			proVo2.setEducation(education);
			//proVo2.setImgPath(x);
			proVo2.setCertificateName(cerNameArr);
			proVo2.setCertificateNum(cerNumArr);
			
			//System.out.println("자격증 첨부파일 x 값 :" + x);	//확인용
			System.out.println(proVo1); //확인용
			System.out.println(proVo2); //확인용
			
			req.setAttribute("proVo1", proVo1);
			req.setAttribute("proVo2", proVo2);
			req.getRequestDispatcher("/views/common/proJoin-3.jsp").forward(req, resp);
			
		} else if(pageNo.equals("3")) {
			
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd1");
			String memberName = req.getParameter("memberName");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			String education = req.getParameter("education");
			String[] cerNameArr = req.getParameterValues("certificateName");
			String[] cerNumArr = req.getParameterValues("certificateNum");
			String cerImg = req.getParameter("cerImg");
			Part img = req.getPart("img");
			String counselType = req.getParameter("counselType");
			String introduce = req.getParameter("introduce");
			
			//프로필 사진 파일 업로드
			String rootPath = req.getServletContext().getRealPath("/");
			
			String x = "";
			
			if(img.getSubmittedFileName().length() > 0) {
				x = ProfIleUploader.profileUploadFile(img, rootPath);	
			}
			
			System.out.println("프로필 x값 :" + x);
			
			proVo1.setId(memberId);
			proVo1.setPwd(memberPwd);
			proVo1.setName(memberName);
			proVo1.setGender(gender);
			proVo1.setPhone(phone);
			proVo1.setEmail(email);
			
			proVo2.setEducation(education);
			proVo2.setCertificateName(cerNameArr);
			proVo2.setCertificateNum(cerNumArr);
			proVo2.setImgPath(cerImg);
			
			proVo3.setImg(x);
			proVo3.setCounselType(counselType);
			proVo3.setIntroduce(introduce);
			
			
			System.out.println(proVo1); //확인용
			System.out.println(proVo2); //확인용
			System.out.println(proVo3); //확인용

			System.out.println();
			
			int result = new ProMemberService().projoin(proVo1, proVo2, proVo3);
			int result2 = 0;
			
			if(result == 1) {
				result2 = new ProMemberService().projoinlicense(null, proVo2);
				req.getSession().setAttribute("alertMsg", "회원가입 완료");
				req.getSession().setAttribute("proVo1", proVo1);
				req.getSession().setAttribute("proVo2", proVo2);
				req.getSession().setAttribute("proVo3", proVo3);
				req.getRequestDispatcher("/views/common/proJoin-4.jsp").forward(req, resp);
			}else{
				req.getSession().setAttribute("alertMsg", "회원가입 실패");
			}
			
		}	
		


		
		//int result = new ProMemberService().projoin1(vo);
		
//		boolean isPage1 = memberId != null && memberPwd != null && memberName != null && gender != null && phone != null &&  email != null;
//		boolean isPage2 = education != null && certificateName != null && certificateNum != null;
//		boolean isPage3 = counselType != null && introduce != null;
//		
//		ProJoinPage1Vo page1vo = null;
//		ProJoinPage2Vo page2vo = null;
//		ProJoinPage3Vo page3vo = null;
//		
//		if(isPage1 && !isPage2 && !isPage3) {
//			page1vo = new ProJoinPage1Vo();
//			
//			page1vo.setId(memberId);
//			page1vo.setPwd(memberPwd);
//			page1vo.setName(memberName);
//			page1vo.setGender(gender);
//			page1vo.setPhone(phone);
//			page1vo.setEmail(email);
//			req.getSession().setAttribute("page1vo", page1vo);
//			req.getRequestDispatcher("/views/common/proJoin-2.jsp").forward(req, resp);
//		}
//		
//		
//		if(isPage2 && !isPage1 && !isPage3){
//			page2vo = new ProJoinPage2Vo();
//			
//			page2vo.setCertificateName(certificateName);
//			page2vo.setCertificateNum(certificateNum);
//			page2vo.setEducation(education);
//			
//			req.getSession().setAttribute("page2vo", page2vo);
//			req.getRequestDispatcher("/views/common/proJoin-3.jsp").forward(req, resp);
//		}
//
//
//		if(isPage3 && !isPage1 && !isPage2) {
//			page3vo = new ProJoinPage3Vo();
//			
//			page3vo.setImg(img);
//			page3vo.setCounselType(counselType);
//			page3vo.setIntroduce(introduce);
//			
//			page1vo = (ProJoinPage1Vo)req.getSession().getAttribute("page1vo");
//			page2vo = (ProJoinPage2Vo)req.getSession().getAttribute("page2vo");
//			
//			isPage1 = true;
//			isPage2 = true;
//		}
//
//		
//		int result2 = 0;
//		
//		if(isPage1 && isPage2 && isPage3) {
//			int result1 = new ProMemberService().projoin(page1vo, page2vo, page3vo);	//전문가 테이블
//			
//			if(result1 == 1) {
//				result2 = new ProMemberService().projoinlicense(page2vo); //자격증 테이블
//			}
//			
//			if(result2 == 1) {
//				req.getSession().setAttribute("alertMsg", "회원가입 완료");
//				resp.sendRedirect("/sseudam/proJoin");
//			}else{
//				req.getSession().setAttribute("msg", "회원가입 실패");
//				resp.sendRedirect("/views/common/errorPage.jsp");
//				
//			}
//			
//		}
		

		
	}
	
}
