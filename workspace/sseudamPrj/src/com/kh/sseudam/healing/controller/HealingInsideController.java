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

@WebServlet(urlPatterns = "/healing/outside")
public class HealingInsideController extends HttpServlet{

    private final HealingService hs = new HealingService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //디비 다녀오기
        List<HealingVo> listVo = hs.InsidePage();
        //화면 보여주기
        req.setAttribute("listVo", listVo);
        req.getRequestDispatcher("/").forward(req, resp);
        
    }
}
