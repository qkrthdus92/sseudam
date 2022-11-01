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

@WebServlet(urlPatterns = "/admin/nyam/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024  *1024 * 50 * 5
    )
public class AdminNyamAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession s = req.getSession();
        
        AdminVo loginAdmin = (AdminVo)s.getAttribute("loginAdmin");
        
        s.setAttribute("loginAdmin", loginAdmin);
        
        req.getRequestDispatcher("/views/admin/yamyam/add.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
     // 세션 가져오기
        HttpSession s = req.getSession();

        // 로그인 멤버 가져오기
        AdminVo loginAdmin = (AdminVo)s.getAttribute("loginAdmin");
        
        //인코딩
        req.setCharacterEncoding("UTF-8");
        String root = req.getContextPath();
        
        //데이터 꺼내기
        String title = req.getParameter("name");
        String cNum = req.getParameter("cNum");
        String addr = req.getParameter("addr");
        String phone = req.getParameter("phone");
        String link = req.getParameter("link");
        
        Part f = req.getPart("file");
        String imgName = f.getSubmittedFileName();
        
        //파일정보 디비에 저장
        String rootPath = req.getServletContext().getRealPath("/");
        String path = rootPath +"resources/upload/nyam/"; //최상단경로
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
        vo.setInfoA(addr);
        vo.setInfoB(phone);
        vo.setLink(link);
        vo.setImgPath(imgName);

        //디비 다녀오기
        int result = new AdminHealingService().AddNyamOne(vo);
        
        //화면 보여주기
        if(result == 1) {
            s.setAttribute("loginAdmin", loginAdmin);
            s.setAttribute("alertMsg", "컨텐츠 업로드 성공");
            resp.sendRedirect(root + "/admin/nyam?pno=1&type="+cNum);
        }else {
            if(f !=null) {
                new File(path+imgName).delete();
            }
            s.setAttribute("msg", "컨텐츠 업로드 실패");
            req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
        }
        
    }

}
