/*
 * package com.kh.sseudam.mypage.controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.MultipartConfig; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession; import javax.servlet.http.Part;
 * 
 * import com.kh.sseudam.mypage.service.MypageEditService; import
 * com.kh.sseudam.pro.vo.ProMemberJoinVo;
 * 
 * @WebServlet(urlPatterns = "/mypage/imgupdate")
 * 
 * @MultipartConfig( fileSizeThreshold = 1024 * 1024 , //컴터에선 1024 단위로, 걍 크기 지정한
 * 것 maxFileSize = 1024 * 1024 * 50 , maxRequestSize = 1024 * 1024 * 50 * 5 )
 * public class MypageProfileController extends HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * req.getRequestDispatcher("/views/mypage/promain.jsp").forward(req, resp); }
 * 
 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * req.setCharacterEncoding("UTF-8");
 * 
 * HttpSession s = req.getSession(); ProMemberJoinVo ProloginMember =
 * (ProMemberJoinVo)s.getAttribute("ProloginMember"); String num =
 * ProloginMember.getNo();
 * 
 * Part img = req.getPart("img"); //프로필 파일 업로드 String rootPath =
 * req.getServletContext().getRealPath("/");
 * 
 * String x = "";
 * 
 * if(img.getSubmittedFileName().length() > 0) { x =
 * ReProfileUploader.uploadFile(img, rootPath); }
 * 
 * ProMemberJoinVo vo = new ProMemberJoinVo(); vo.setImg(x); vo.setNo(num);
 * 
 * 
 * int result = new MypageEditService().profileUpload(vo);
 * 
 * if(result == 1) { req.getSession().setAttribute("result", result);
 * req.getRequestDispatcher("/views/mypage/promain.jsp").forward(req, resp); } }
 * 
 * }
 */