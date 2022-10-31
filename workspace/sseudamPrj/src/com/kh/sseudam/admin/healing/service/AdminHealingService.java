package com.kh.sseudam.admin.healing.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.healing.dao.AdminHealingDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.vo.HealingVo;

public class AdminHealingService {
    
    private final AdminHealingDao dao = new AdminHealingDao();

//-----------------------------------------------------------------------------------------  
    //냠냠
//-----------------------------------------------------------------------------------------  
    //냠냠 페이지 수
    public int NyamCount(int sNo, int tNum, String search) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.NyamListCount(conn, tNum, sNo, search);
        
        JDBCTemplate.close(conn);
       
        return count;
    }

    //냠냠 페이지 리스트
    public List<HealingVo> NyamList(PageVo pv, int sNo, int tNum, String search) {

        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.NyamDefaultList(conn, pv, sNo, tNum, search);
        
        JDBCTemplate.close(conn);

        return list;
        
    }

    public int AddNyamOne(HealingVo vo) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.InsertNyamOne(conn, vo);
        
        JDBCTemplate.close(conn);

        return result;
    }

    public HealingVo NyamDetailSelect(String no) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        HealingVo vo = dao.SelectNyamOne(conn, no);
        
        JDBCTemplate.close(conn);
        
        
        return vo;
    }

    public int EditNyamOne(HealingVo vo) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.UpdateNyamOne(conn, vo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

    public int DeleteNyamOne(String no) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.DeleteNyamOne(conn, no);
        
        JDBCTemplate.close(conn);
        
        return result;
    }
//--------------------------------------------------------------------------------------------
    //뒹굴뒹굴
//--------------------------------------------------------------------------------------------
        
    public int InsideCount(int sNo, int tNum, String search) {
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.InsideListCount(conn, tNum, sNo, search);
        
        JDBCTemplate.close(conn);
       
        return count;
    }

        
    public List<HealingVo> InsideList(PageVo pv, int sNo, int tNum, String search) {
            
        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.InsideDefaultList(conn, pv, sNo, tNum, search);
        
        JDBCTemplate.close(conn);

        return list;
    }

    public HealingVo InsideDetailSelect(String no) {
        Connection conn = JDBCTemplate.getConnection();
        
        HealingVo vo = dao.SelectInsideOne(conn, no);
        
        JDBCTemplate.close(conn);       
        
        return vo;
    }

    public int EditInsideOne(HealingVo vo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.UpdateInsideOne(conn, vo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

    public int AddInsideOne(HealingVo vo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.InsertInsideOne(conn, vo);
        
        JDBCTemplate.close(conn);

        return result;
    }

    public int DeleteInsideOne(String no) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.DeleteInsideOne(conn, no);
        
        JDBCTemplate.close(conn);
        
        return result;
    }
//--------------------------------------------------------------------------------------------
   //뚜벅뚜벅
//--------------------------------------------------------------------------------------------
    public int OutsideCount(int sNo, int tNum, String search) {
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.OutsideListCount(conn, tNum, sNo, search);
        
        JDBCTemplate.close(conn);
       
        return count;
    }

    public List<HealingVo> OutsideList(PageVo pv, int sNo, int tNum, String search) {
        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.OutsideDefaultList(conn, pv, sNo, tNum, search);
        
        JDBCTemplate.close(conn);

        return list;
    }

    public int AddOutsideOne(HealingVo vo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.InsertOutsideOne(conn, vo);
        
        JDBCTemplate.close(conn);

        return result;
    }

    public HealingVo OutsideDetailSelect(String no) {
        Connection conn = JDBCTemplate.getConnection();
        
        HealingVo vo = dao.SelectOutsideOne(conn, no);
        
        JDBCTemplate.close(conn);       
        
        return vo;
    }

    public int EditOutsideOne(HealingVo vo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.UpdateOutsideOne(conn, vo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

    public int DeleteOutsideOne(String no) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.DeleteOutsideOne(conn, no);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

}
