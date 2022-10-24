package com.kh.sseudam.healing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.service.HealingService;
import com.kh.sseudam.healing.vo.HealingVo;

@WebServlet(urlPatterns = "/healing/outside")
public class HealingOutsideController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        //페이징 처리
        int listCount;
        int currentPage;
        int pageLimit;
        int boardLimit;

        int maxPage;
        int startPage;
        int endPage;

        listCount = new HealingService().selectOutsideCount();
        
        String pno = req.getParameter("pno");
        if(pno == null) {
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(pno);
        }

        pageLimit = 5;
        boardLimit = 9;

        maxPage = (int) Math.ceil((double) listCount / boardLimit);
        startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
        
        endPage = startPage + pageLimit - 1;

        if (endPage > maxPage) {
            endPage = maxPage;
        }

        PageVo pv = new PageVo();
        pv.setListCount(listCount);
        pv.setCurrentPage(currentPage);
        pv.setPageLimit(pageLimit);
        pv.setBoardLimit(boardLimit);
        pv.setMaxPage(maxPage);
        pv.setStartPage(startPage);
        pv.setEndPage(endPage);
        
        //정렬값 받기
        String sort = req.getParameter("sort");
        
        
        //회원 넘버 가져오기
        int mNo = 7;
        
        //디비 다녀오기
        List<HealingVo> outsideList = new HealingService().OutsidePage(pv, sort, mNo);                    
 
        //sort null처리
        if(sort == null){
            sort= "";        
        }else {
            sort = "&sort="+sort;
        }
        //화면 보여주기

        req.setAttribute("sort", sort);
        req.setAttribute("pv", pv);
        req.setAttribute("outsideList", outsideList);
        req.getRequestDispatcher("/views/healing/outside.jsp").forward(req, resp);
        
    }

}