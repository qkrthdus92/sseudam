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

import com.kh.sseudam.admin.healing.service.AdminHealingService;
import com.kh.sseudam.healing.vo.HealingVo;

@WebServlet(urlPatterns = "/admin/inside/edit")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024  *1024 * 50 * 5
    )
public class AdminInsideEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String no = req.getParameter("no");
        
        HealingVo vo = new AdminHealingService().InsideDetailSelect(no);
        
        req.setAttribute("insideDetailVo", vo);
        req.getRequestDispatcher("/views/admin/wallow/edit.jsp").forward(req, resp);
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
        String no = req.getParameter("no");
        String title = req.getParameter("name");
        String cNum = req.getParameter("cNum");
        String infoA = req.getParameter("infoA");
        String infoB = req.getParameter("infoB");
        String link = req.getParameter("link");
        String stress = req.getParameter("stress");
        String deleteYn = req.getParameter("deleteYn");
        String writeDate = req.getParameter("writeDate");
        String imgPath = req.getParameter("currentFile"); 
        String changedPath = req.getParameter("changedFile"); 
        Part f = req.getPart("uploadFile");
        
        //파일이 변경된 경우 변경된 파일 저장
        if(!changedPath.equals("")) {
            String imgName = f.getSubmittedFileName();
            
            //파일정보 디비에 저장
            String rootPath = req.getServletContext().getRealPath("/");
            String path = rootPath +"resources/upload/inside/"; //최상단경로
           
            //기존 파일 삭제
            new File(path+imgPath).delete();
            
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
            imgPath = imgName;           
        }
        
        //데이터 뭉치기
        HealingVo vo = new HealingVo();
        vo.setNo(no);
        vo.setTitle(title);
        vo.setcNum(cNum);
        vo.setInfoA(infoA);
        vo.setInfoB(infoB);
        vo.setLink(link);
        vo.setStress(stress);
        vo.setDeleteYn(deleteYn);
        vo.setImgPath(imgPath);
        vo.setWriteDate(writeDate);
        
        int result = new AdminHealingService().EditInsideOne(vo);
        
        if(result == 1) {
            //성공        
            s.setAttribute("alertMsg", "컨텐츠 수정 성공");
            resp.sendRedirect(root + "/admin/inside?pno=1&type="+cNum);
        }else {
            //실패
            req.setAttribute("msg", "컨텐츠 수정 실패");
            req.getRequestDispatcher("/views/common/errorPage.jsp");
        }
    }
}
