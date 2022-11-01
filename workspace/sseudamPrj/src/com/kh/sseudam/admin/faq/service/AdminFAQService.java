package com.kh.sseudam.admin.faq.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.faq.dao.AdminFAQDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.faq.vo.FAQVo;

public class AdminFAQService {

    private final AdminFAQDao dao = new AdminFAQDao();
    
    //페이지 리스트 카운트
    public int FAQCount(String search) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.FAQListCount(conn,search);
        
        JDBCTemplate.close(conn);
       
        return count;
    }

    //페이지 리스트
    public List<FAQVo> FAQList(PageVo pv, String search) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        List<FAQVo> list = dao.FAQDefaultList(conn,pv,search);
        
        JDBCTemplate.close(conn);
       
        return list;
    }

    public int addFAQOne(FAQVo vo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.InsertFAQOne(conn,vo);
        
        JDBCTemplate.close(conn);
       
        return result;
    }

    public FAQVo FAQDetailSelect(String no) {
        Connection conn = JDBCTemplate.getConnection();
        
        FAQVo vo = dao.SelectFAQOne(conn,no);
        
        JDBCTemplate.close(conn);
       
        return vo;
    }

    public int EditFAQOne(FAQVo vo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.UpdateFAQOne(conn,vo);
        
        JDBCTemplate.close(conn);
       
        return result;
    }

    public int DeleteFAQOne(String no) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.DeleteFAQOne(conn,no);
        
        JDBCTemplate.close(conn);
       
        return result;
    }

}
