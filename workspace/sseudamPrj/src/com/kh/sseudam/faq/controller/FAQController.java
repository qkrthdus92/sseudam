package com.kh.sseudam.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.faq.service.FAQService;
import com.kh.sseudam.faq.vo.FAQVo;

@WebServlet(urlPatterns = "/faq")
public class FAQController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FAQVo> list = new FAQService().FAQList();
        
        req.setAttribute("FAQList", list);
        
        req.getRequestDispatcher("/views/mypage/customercenter.jsp").forward(req, resp);
    
    }

}
