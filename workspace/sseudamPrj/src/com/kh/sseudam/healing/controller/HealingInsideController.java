package com.kh.sseudam.healing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.healing.service.HealingService;
import com.kh.sseudam.healing.vo.HealingVo;

@WebServlet(urlPatterns = "/healing/inside")
public class HealingInsideController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        //디비 다녀오기
        List<HealingVo> insideList = new HealingService().InsidePage();
        
        //페이징 처리
        int listCount;
        int currentPage;
        int pageLimit;
        int boardLimit;

        int maxPage;
        int startPage;
        int endPage;

        listCount = insideList.size();
        currentPage = Integer.parseInt(req.getParameter("pno"));
        pageLimit = 5;
        boardLimit = 10;

        maxPage = (int) Math.ceil((double) listCount / boardLimit);
        //화면 보여주기
        req.setAttribute("insideList", insideList);
        req.getRequestDispatcher("/views/healing/inside.jsp").forward(req, resp);
        
    }
}
