package com.kh.sseudam.main.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.main.dao.MainDao;
import com.kh.sseudam.main.vo.MainVo;

public class MainService {
    
    private final MainDao dao = new MainDao();

    public List<MainVo> ReviewMainPage() {
        
        Connection conn = JDBCTemplate.getConnection();
        
        List<MainVo> list = dao.SelectBestReview(conn);
        
        JDBCTemplate.close(conn);
        
        return list;
    }

    public List<MainVo> ProMainPage() {
        
        Connection conn = JDBCTemplate.getConnection();
        
        List<MainVo> list = dao.SelectPro(conn);
        
        JDBCTemplate.close(conn);
        
        return list;
          
    }

    
}
