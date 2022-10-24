package com.kh.sseudam.healing.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.sseudam.healing.service.HealingService;
import com.kh.sseudam.healing.vo.HealingLikeVo;

@WebServlet(urlPatterns = "/healing/outsideLike")
public class HealingOutsideLikeController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
    
        int no = Integer.parseInt(req.getParameter("no")) ;
        int mNo = Integer.parseInt(req.getParameter("mNo"));
        
        if(mNo == 0) {
            resp.sendRedirect("");
        }
        HealingLikeVo vo = new HealingService().OutsideLikeCnt(no, mNo);            
    
        Gson gson = new Gson();

        String str = gson.toJson(vo);
        
        PrintWriter out = resp.getWriter();
        out.write(str);
    }
}
