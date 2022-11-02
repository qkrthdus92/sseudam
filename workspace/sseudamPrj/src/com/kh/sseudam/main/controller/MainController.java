package com.kh.sseudam.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.main.service.MainService;
import com.kh.sseudam.main.vo.MainVo;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/main")
public class MainController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 세션 가져오기
        HttpSession s = req.getSession();

        // 로그인 멤버 가져오기
        MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
        
        
        //후기디비 다녀오기
        List<MainVo> reVo = new MainService().ReviewMainPage();
        
        //전문가 디비 다녀오기
        List<MainVo> proVo = new MainService().ProMainPage();
       
        
        //화면 선택
        req.setAttribute("reVo", reVo);
        req.setAttribute("proVo", proVo);
        s.setAttribute("loginMember", loginMember);
       
        
        req.getRequestDispatcher("views/main/main.jsp").forward(req, resp);
    
    }
}
