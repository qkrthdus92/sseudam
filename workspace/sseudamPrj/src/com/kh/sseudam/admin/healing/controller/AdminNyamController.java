package com.kh.sseudam.admin.healing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.admin.common.AdminVo;
import com.kh.sseudam.admin.healing.service.AdminHealingService;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.vo.HealingVo;

@WebServlet(urlPatterns = "/admin/nyam")
public class AdminNyamController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //분류값 받기
        String sort = req.getParameter("sort");
        int sNo = 1;
        
        if(sort == null) {
            sort = "&sort=" + sNo; 
        }else {
            sNo = Integer.parseInt(sort);
            sort = "&sort=" + sNo;
        }
        
        //type 값
        String type = req.getParameter("type");
        int tNum = 1;
              
        if(type == null) {
            type = "&type=" + tNum; 
        }else {
            tNum = Integer.parseInt(type);
            type = "&type=" + tNum;
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
        listCount = new AdminHealingService().NyamCount(sNo, tNum);
        
        String pno = req.getParameter("pno");
        if(pno == null) {
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(pno);
        }
        
        pageLimit = 10;
        boardLimit = 5;

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
        
        List<HealingVo> list = new AdminHealingService().NyamList(pv,sNo, tNum);    
        
        //강제 로그인 -> 추후 삭제
        AdminVo vo = new AdminVo();
        vo.setId("1");
        vo.setPwd("1");
        req.getSession().setAttribute("loginAdmin", vo);
        
               
        req.setAttribute("type", type);
        req.setAttribute("sort", sort);
        req.setAttribute("pv", pv);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/views/admin/yamyam/list.jsp").forward(req, resp);
 
    }
}
