package com.kh.sseudam.admin.healing.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.sseudam.admin.common.AdminVo;
import com.kh.sseudam.admin.healing.service.AdminHealingService;
import com.kh.sseudam.healing.vo.HealingVo;

@WebServlet(urlPatterns = "/admin/inside/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024  *1024 * 50 * 5
    )
public class AdminInsideAddController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //강제로그인 -> 추후삭제
        AdminVo vo = new AdminVo();
        vo.setId("1");
        vo.setPwd("1");
        
        req.getSession().setAttribute("loginAdmin", vo);
        
        req.getRequestDispatcher("/views/admin/wallow/add.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 세션 가져오기
        HttpSession s = req.getSession();

        // 로그인 멤버 가져오기
        //AdminVo loginMember = (AdminVo)s.getAttribute("loginMember");
        
        //인코딩
        req.setCharacterEncoding("UTF-8");
        String root = req.getContextPath();
        
        //데이터 꺼내기
        String title = req.getParameter("title");
        String cNum = req.getParameter("cNum");
        String infoA = req.getParameter("infoA");
        String infoB = req.getParameter("infoB");
        String link = req.getParameter("link");
        String stress = req.getParameter("stress");
        
        Part f = req.getPart("file");
        String imgName = f.getSubmittedFileName();
        
        //파일정보 디비에 저장
        String rootPath = req.getServletContext().getRealPath("/");
        String path = rootPath +"resources/upload/inside/"; //최상단경로
        if(f.getSubmittedFileName().length() > 0) {
            
            File target = new File(path + imgName);
            
            BufferedInputStream bis = new BufferedInputStream(f.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
            
            byte[] buf = new byte[1024]; 
            
            int size = 0;
            
            while((size = bis.read(buf)) != -1) {
                
                bos.write(buf, 0, size);
            }
            bos.flush();
            bis.close();
            bos.close();
        }
        
        //데이터 뭉치기
        HealingVo vo = new HealingVo();
        vo.setTitle(title);
        vo.setcNum(cNum);
        vo.setInfoA(infoA);
        vo.setInfoB(infoB);
        vo.setLink(link);
        vo.setImgPath(imgName);
        vo.setStress(stress);

        //디비 다녀오기
        int result = new AdminHealingService().AddInsideOne(vo);
        
        //화면 보여주기
        if(result == 1) {
            s.setAttribute("alertMsg", "컨텐츠 업로드 성공");
            resp.sendRedirect(root + "/admin/inside?pno=1&type="+cNum);
        }else {
            if(f !=null) {
                new File(path+imgName).delete();
            }
            s.setAttribute("msg", "컨텐츠 업로드 실패");
            req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
        }
        
    }

}
