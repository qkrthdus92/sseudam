package com.kh.sseudam.admin.healing.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.healing.dao.AdminHealingDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.vo.HealingVo;

public class AdminHealingService {
    
    private final AdminHealingDao dao = new AdminHealingDao();
    
    //냠냠 페이지 수
    public int NyamCount(int sNo, int tNum) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.NyamListCount(conn, tNum, sNo);
        
        JDBCTemplate.close(conn);
       
        return count;
    }

    //냠냠 페이지 리스트
    public List<HealingVo> NyamList(PageVo pv, int sNo, int tNum) {

        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.NyamDefaultList(conn, pv, sNo, tNum);
        
        JDBCTemplate.close(conn);

        return list;
        
    }


}
