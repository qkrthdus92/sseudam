package com.kh.sseudam.admin.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.admin.common.AdminVo;
import com.kh.sseudam.admin.faq.service.AdminFAQService;
import com.kh.sseudam.faq.vo.FAQVo;

@WebServlet(urlPatterns = "/admin/faq/add")
public class AdminFAQAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        
        req.getRequestDispatcher("/views/admin/faq/add.jsp").forward(req, resp);
    }
    
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
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writeNo = loginAdmin.getNo();
        
        FAQVo vo = new FAQVo();
        vo.setTitle(title);
        vo.setContent(content);
        vo.setWriterNo(writeNo);
        
        int result = new AdminFAQService().addFAQOne(vo);
        
        //화면 보여주기
        if(result == 1) {
            s.setAttribute("alertMsg", "컨텐츠 업로드 성공");
            s.setAttribute("loginAdmin", loginAdmin);
            resp.sendRedirect(root + "/admin/faq?pno=1");
        }else {
            s.setAttribute("msg", "컨텐츠 업로드 실패");
            req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}
