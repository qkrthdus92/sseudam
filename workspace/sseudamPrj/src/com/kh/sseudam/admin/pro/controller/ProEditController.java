package com.kh.sseudam.admin.pro.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.sseudam.admin.member.service.AdminMemberService;
import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.FileUploader;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/admin/pro/edit")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 , 
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//수정 후 리다이렉트할 페이지 정보
		String pno = req.getParameter("pno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		
		//전문가 개인정보
		String mno = req.getParameter("mno");
		String name = req.getParameter("name").trim();
		String gender = req.getParameter("gender");
		String id = req.getParameter("id").trim();
		String pwd = req.getParameter("pwd").trim();
		String counselType = req.getParameter("counselType");
		String email = req.getParameter("email").trim();
		String phone = req.getParameter("phone").trim();
		String education = req.getParameter("education").trim();
		String price = req.getParameter("price").trim();
		String image = req.getParameter("img");
		Part img = req.getPart("img");
		String introduce = req.getParameter("introduce").trim();
		
		String originNameImg = img.getSubmittedFileName();
		
		//전문가 자격정보
		String[] cerNameArr = req.getParameterValues("cerName");
		String[] cerNumArr = req.getParameterValues("cerNum");
		List<Part> parts = (List<Part>)req.getParts();
		
//		for(Part part : parts) {
//			
//			if(!part.getName().equals("f")) continue; //f로 들어온 Part가 아니면 스킵
//			if(part.getSubmittedFileName().equals("")) continue; //업로드 된 파일 이름이 없으면 스킵
//			
//			String fileName = part.getSubmittedFileName();
//			String rootPath = req.getServletContext().getRealPath("/");
//			
//			AttachmentVo aVo = null;
//			if(part.getSubmittedFileName().length() > 0) {
//				aVo = FileUploader.uploadFile(img, rootPath, "resources/upload/certificate");
//			}
//			
//		}
		
		List<AttachmentVo> list = new ArrayList<AttachmentVo>();
		int cerResult = 0;
		for(int i=0; i<parts.size(); i++) {
			System.out.println("자격파일1");
			Part part = parts.get(i);
			if(!part.getName().equals("f")) continue; //f로 들어온 Part가 아니면 스킵
			if(part.getSubmittedFileName().equals("")) continue; //업로드 된 파일 이름이 없으면 스킵
			
			String rootPath = req.getServletContext().getRealPath("/");
			
			AttachmentVo aVo = null;
			if(part.getSubmittedFileName().length() > 0) {
				aVo = FileUploader.uploadFile(part, rootPath, "resources/upload/certificate");
			}
			
			System.out.println("자격파일2");
			list.add(aVo);

			
		}
		
		for(int i=0; i<list.size(); i++) {
			//데이터뭉치기
			CertificateVo cv = new CertificateVo();		
			cv.setNo(mno);
			cv.setName(cerNameArr[i]);
			cv.setNum(cerNumArr[i]);
			
			//디비다녀오기
			cerResult = new AdminProService().insertCerOne(cv, list.get(i));
		}
		
	
		System.out.println("자격파일 완");
		
		ProVo vo = new ProVo();
		vo.setNo(mno);
		vo.setName(name);
		vo.setGender(gender);
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setCounselType(counselType);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setEducation(education);
		vo.setPrice(price);
		vo.setIntroduce(introduce);
		
		int result = 0;
		
		
		
		//파일첨부를 한 경우 (같이 업데이트)
		if(!originNameImg.equals("")) {
			System.out.println("파일첨부했음!");
			AttachmentVo aVo = null;
			
			String rootPath = req.getServletContext().getRealPath("/");
			if(img.getSubmittedFileName().length() > 0) {
				aVo = FileUploader.uploadFile(img, rootPath, "resources/upload/pro");
			}
			
			//디비다녀오기
			result = new AdminProService().updateOneWithImg(vo, aVo);
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "전문가 수정 완료!");
				resp.sendRedirect("/sseudam/admin/pro/edit?mno="+mno+"&pno="+pno+"&status="+status+"&search="+search);
			}else {
				if(aVo != null) {
					String savePath = rootPath + aVo.getFilePath() + "/" + aVo.getChangeName();
					new File(savePath).delete();
				}
				req.setAttribute("msg", "관리자페이지 : 회원 수정 실패");
				req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			}
			
		}
		
		//파일첨부를 안한 경우 (빼고 업데이트)
		if(originNameImg.equals("")) {
			System.out.println("파일첨부안함!");
			
			//디비다녀오기
			result = new AdminProService().updateOneWithoutImg(vo);
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "전문가 수정 완료!");
				resp.sendRedirect("/sseudam/admin/pro/edit?mno="+mno+"&pno="+pno+"&status="+status+"&search="+search);
			}else {
				req.setAttribute("msg", "관리자페이지 : 회원 수정 실패");
				req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			}
		}
		
	

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
