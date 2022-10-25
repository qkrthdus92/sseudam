package com.kh.sseudam.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.main.service.MainService;
import com.kh.sseudam.main.vo.MainVo;

@WebServlet(urlPatterns = "/main")
public class MainController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //후기디비 다녀오기
        List<MainVo> reVo = new MainService().ReviewMainPage();
        
        //전문가 디비 다녀오기
        List<MainVo> proVo = new MainService().ProMainPage();
       
        
        //화면 선택
        req.setAttribute("reVo", reVo);
        req.setAttribute("proVo", proVo);
        
        req.getRequestDispatcher("views/main/main.jsp").forward(req, resp);
    
    }
}
