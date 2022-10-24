package com.kh.sseudam.stress.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.stress.service.StressService;

import oracle.jdbc.driver.HAManager;
import temp.MemberVo;

@WebServlet(urlPatterns = "/stress/stressTest")
public class StressTestController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/stress/stressTest.jsp").forward(req, resp);	
	}
	
}
