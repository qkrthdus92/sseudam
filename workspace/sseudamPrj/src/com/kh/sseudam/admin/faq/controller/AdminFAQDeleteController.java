package com.kh.sseudam.admin.faq.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.admin.common.AdminVo;
import com.kh.sseudam.admin.faq.service.AdminFAQService;


@WebServlet(urlPatterns = "/admin/faq/delete")
public class AdminFAQDeleteController extends HttpServlet{

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

        //디비 다녀오기
        int result = new AdminFAQService().DeleteFAQOne(no);
        
        if(result == 1) {
            //성공 -> 공지사항 상세조회 //알람          
            s.setAttribute("alertMsg", "컨텐츠 삭제 성공");
            s.setAttribute("loginAdmin", loginAdmin);
            resp.sendRedirect(root + "/admin/faq?pno=1");
        }else {
            //실패
            req.setAttribute("msg", "컨텐츠 삭제 실패");
            req.getRequestDispatcher("/views/common/errorPage.jsp");
        }
    }
}
