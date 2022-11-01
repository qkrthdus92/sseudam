package com.kh.sseudam.admin.healing.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.admin.common.AdminVo;
import com.kh.sseudam.admin.healing.service.AdminHealingService;

@WebServlet(urlPatterns = "/admin/inside/delete")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024  *1024 * 50 * 5
    )
public class AdminInsideDeleteController extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     // 세션 가져오기
        HttpSession s = req.getSession();

        // 로그인 멤버 가져오기
        AdminVo loginAdmin = (AdminVo)s.getAttribute("loginAdmin");
        
        //인코딩
        req.setCharacterEncoding("UTF-8");
        
        String root = req.getContextPath();
        
        //데이터 꺼내기
        String no = req.getParameter("no");
        String cNum = req.getParameter("cNum");
        String imgPath = req.getParameter("currentFile"); 
        
        //파일정보 디비에 저장
        String rootPath = req.getServletContext().getRealPath("/");
        String path = rootPath +"resources/upload/inside/";
       
        //기존 파일 삭제
        new File(path+imgPath).delete();
        
        //디비 다녀오기
        int result = new AdminHealingService().DeleteInsideOne(no);
        
        if(result == 1) {
            //성공 -> 공지사항 상세조회 //알람   
            s.setAttribute("loginAdmin", loginAdmin);
            s.setAttribute("alertMsg", "컨텐츠 삭제 성공");
            resp.sendRedirect(root + "/admin/inside?pno=1&type="+cNum);
        }else {
            //실패
            req.setAttribute("msg", "컨텐츠 삭제 실패");
            req.getRequestDispatcher("/views/common/errorPage.jsp");
        }
    }
}
