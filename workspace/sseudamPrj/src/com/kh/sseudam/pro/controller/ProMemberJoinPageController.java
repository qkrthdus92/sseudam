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
      fileSizeThreshold = 1024 * 1024 ,   //컴터에선 1024 단위로, 걍 크기 지정한 것
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
         
         proVo1.setId(memberId);
         proVo1.setPwd(memberPwd);
         proVo1.setName(memberName);
         proVo1.setGender(gender);
         proVo1.setPhone(phone);
         proVo1.setEmail(email);
         
         proVo2.setEducation(education);
         proVo2.setCertificateName(cerNameArr);
         proVo2.setCertificateNum(cerNumArr);
         
         req.setAttribute("proVo1", proVo1);
         req.setAttribute("proVo2", proVo2);
         
         req.getSession().setAttribute("cerNameArr", cerNameArr);
         req.getSession().setAttribute("cerNumArr", cerNumArr);
         req.getSession().setAttribute("parts", parts);
         
         req.getRequestDispatcher("/views/common/proJoin-3.jsp").forward(req, resp);
         
      } else if(pageNo.equals("3")) {
         String[] cerNameArr = (String[]) req.getSession().getAttribute("cerNameArr");
         String[] cerNumArr = (String[]) req.getSession().getAttribute("cerNumArr");
         List<Part> parts = (List<Part>) req.getSession().getAttribute("parts");
         
         String memberId = req.getParameter("memberId");
         String memberPwd = req.getParameter("memberPwd1");
         String memberName = req.getParameter("memberName");
         String gender = req.getParameter("gender");
         String phone = req.getParameter("phone");
         String email = req.getParameter("email");
         
         String education = req.getParameter("education");
         Part img = req.getPart("img");
         String counselType = req.getParameter("counselType");
         String introduce = req.getParameter("introduce");
         
         String rootPath = req.getServletContext().getRealPath("/");
         
         String x = "";
         
         if(img.getSubmittedFileName().length() > 0) {
            x = ProfIleUploader.profileUploadFile(img, rootPath);   
         }
         
         proVo1.setId(memberId);
         proVo1.setPwd(memberPwd);
         proVo1.setName(memberName);
         proVo1.setGender(gender);
         proVo1.setPhone(phone);
         proVo1.setEmail(email);
         
         proVo2.setEducation(education);
         proVo2.setCertificateName(cerNameArr);
         proVo2.setCertificateNum(cerNumArr);
         
         proVo3.setImg(x);
         proVo3.setCounselType(counselType);
         proVo3.setIntroduce(introduce);

         int result = new ProMemberService().projoin(proVo1, proVo2, proVo3);
         int result2 = 0;
         
         
         List<AttachmentVo> list = new ArrayList<AttachmentVo>();
         int cerResult = 0;
         for(int i=0; i<parts.size(); i++) {
            Part part = parts.get(i);
            if(!part.getName().equals("imgPath")) continue; //imgPath로 들어온 Part가 아니면 스킵
            if(part.getSubmittedFileName().equals("")) continue; //업로드 된 파일 이름이 없으면 스킵
            
            rootPath = req.getServletContext().getRealPath("/");
            
            AttachmentVo aVo = null;
            if(part.getSubmittedFileName().length() > 0) {
               aVo = FileUploader.uploadFile(part, rootPath, "resources/upload/certificate");
            }
            
            list.add(aVo);
         }
         
         
         for(int i=0; i<list.size(); i++) {

            CertificateVo cv = new CertificateVo();      
            cv.setName(cerNameArr[i]);
            cv.setNum(cerNumArr[i]);
            System.out.println(cerNameArr[i]);
            System.out.println(cerNumArr[i]);
            

            cerResult = new ProMemberService().projoinlicense(cv, list.get(i));
         }
         
         if(result == 1) {
            req.getSession().setAttribute("alertMsg", "회원가입 완료");
            req.getSession().setAttribute("proVo1", proVo1);
            req.getSession().setAttribute("proVo2", proVo2);
            req.getSession().setAttribute("proVo3", proVo3);
            req.getRequestDispatcher("/views/common/proJoin-4.jsp").forward(req, resp);
         }else{
            req.getSession().setAttribute("alertMsg", "회원가입 실패");
         }
         
      }   

      
   }
   
}