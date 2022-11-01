package com.kh.sseudam.admin.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.admin.common.AdminVo;
import com.kh.sseudam.admin.faq.service.AdminFAQService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.faq.vo.FAQVo;

@WebServlet(urlPatterns = "/admin/faq")
public class AdminFAQListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 세션 가져오기
        HttpSession s = req.getSession();

        // 로그인 멤버 가져오기
        AdminVo loginAdmin = (AdminVo)s.getAttribute("loginAdmin");
        
        //search 값
        String search = req.getParameter("search");
        if(search == null) {
            search = "";
        }
        
        //페이징 처리
        int listCount;
        int currentPage;
        int pageLimit;
        int boardLimit;

        int maxPage;
        int startPage;
        int endPage;

        //페이지 번호 받기 + null 처리
        listCount = new AdminFAQService().FAQCount(search);

        String pno = req.getParameter("pno");
        if(pno == null) {
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(pno);
        }
        
        pageLimit = 10;
        boardLimit = 10;

        maxPage = (int) Math.ceil((double) listCount / boardLimit);
        startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
        
        endPage = startPage + pageLimit - 1;

        if (endPage > maxPage) {
            endPage = maxPage;
        }

        //페이지 데이터 뭉치기
        PageVo pv = new PageVo();
        pv.setListCount(listCount);
        pv.setCurrentPage(currentPage);
        pv.setPageLimit(pageLimit);
        pv.setBoardLimit(boardLimit);
        pv.setMaxPage(maxPage);
        pv.setStartPage(startPage);
        pv.setEndPage(endPage);        
        
        List<FAQVo> list = new AdminFAQService().FAQList(pv, search);    

        
        s.setAttribute("loginAdmin", loginAdmin);               
        req.setAttribute("pv", pv);
        req.setAttribute("faqList", list);
        req.getRequestDispatcher("/views/admin/faq/list.jsp").forward(req, resp);
    
    }
}
